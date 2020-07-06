package common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.frontController.ModelAndView;
import common.vo.UploadFile;

public class FileUtil {

	public UploadFile fileUpload(String uploadFolder, HttpServletRequest request) {
		UploadFile uf = new UploadFile();

		int maxSize = 1024 * 1024 * 10;

		String originFileName = "";

		String renameFileName = "";

		String root = request.getServletContext().getRealPath("/");

		String savePath = root + uploadFolder;

		// request를 MultipartRequest로 교체
		// MultipartRequest 객체가 생성됨과 동시에 파일 업로드가 이루어 진다.
		MultipartRequest mrequest;
		try {
			mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			originFileName = mrequest.getFilesystemName("reviewFile");
			if (originFileName != null) {
				String fileName = String.valueOf(new Date().getTime());

				renameFileName = fileName + originFileName.substring(originFileName.lastIndexOf("."));

				File originFile = new File(savePath + "\\" + originFileName);
				File renameFile = new File(savePath + "\\" + renameFileName);

				originFile.renameTo(renameFile);
			}

			uf.setSuccess(true);
			uf.setOriginalFileName(originFileName);
			uf.setRenameFileName(renameFileName);
			uf.setSavePath(savePath);
			uf.setMrequest(mrequest);
		} catch (IOException e) {
			e.printStackTrace();
			uf.setSuccess(false);
			uf.setOriginalFileName(originFileName);
		}

		return uf;
	}
	
	public UploadFile usedfileUpload(String uploadFolder, HttpServletRequest request) {
		UploadFile uf = new UploadFile();

		int maxSize = 1024 * 1024 * 10;

		String originFileName = "";

		String renameFileName = "";

		String root = request.getServletContext().getRealPath("/");

		String savePath = root + uploadFolder;

		// request를 MultipartRequest로 교체
		// MultipartRequest 객체가 생성됨과 동시에 파일 업로드가 이루어 진다.
		MultipartRequest mrequest;
		try {
			mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			originFileName = mrequest.getFilesystemName("usedFile");
			if (originFileName != null) {
				String fileName = String.valueOf(new Date().getTime());

				renameFileName = fileName + originFileName.substring(originFileName.lastIndexOf("."));

				File originFile = new File(savePath + "\\" + originFileName);
				File renameFile = new File(savePath + "\\" + renameFileName);

				originFile.renameTo(renameFile);
			}

			uf.setSuccess(true);
			uf.setOriginalFileName(originFileName);
			uf.setRenameFileName(renameFileName);
			uf.setSavePath(savePath);
			uf.setMrequest(mrequest);
		} catch (IOException e) {
			e.printStackTrace();
			uf.setSuccess(false);
			uf.setOriginalFileName(originFileName);
		}

		return uf;
	}

	public boolean fileDownload(ModelAndView mav, HttpServletResponse response) {
		File downFile = new File((String) mav.getData().get("path"));
		String ofName = (String) mav.getData().get("ofName");
		ServletOutputStream downOutput;
		try {
			response.setHeader("Content-Disposition", "attachment);filename=" + URLEncoder.encode(ofName, "UTF-8"));
			downOutput = response.getOutputStream();
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
			int read = 0;
			while ((read = bin.read()) < -1) {
				downOutput.write(read);
				downOutput.flush();
			}
			downOutput.close();
			bin.close();
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
