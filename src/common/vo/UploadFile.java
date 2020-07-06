/**
 * 
 */
package common.vo;

import com.oreilly.servlet.MultipartRequest;

public class UploadFile {

	private boolean isSuccess = false;
	private String originalFileName;
	private String renameFileName;
	private String savePath;
	private MultipartRequest mrequest;

	public UploadFile() {
		super();
	}

	public UploadFile(boolean isSuccess, String originalFileName, String renameFileName, String savePath,
			MultipartRequest mrequest) {
		super();
		this.isSuccess = isSuccess;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
		this.savePath = savePath;
		this.mrequest = mrequest;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public MultipartRequest getMrequest() {
		return mrequest;
	}

	public void setMrequest(MultipartRequest mrequest) {
		this.mrequest = mrequest;
	}

	@Override
	public String toString() {
		return "UploadFile [isSuccess=" + isSuccess + ", originalFileName=" + originalFileName + ", renameFileName="
				+ renameFileName + ", savePath=" + savePath + ", mrequest=" + mrequest + "]";
	}

}
