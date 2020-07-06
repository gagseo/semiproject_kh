package common.frontController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.FileUtil;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping hm = new HandlerMapping();
	private HandlerAdapter ha = new HandlerAdapter();

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String[] uriArr = request.getRequestURI().split("/");
		System.out.println(Arrays.toString(uriArr));

		Controller ctr = hm.getController(uriArr);
		String methodName = hm.getMethod(uriArr);
		ModelAndView mav = ha.excute(ctr, methodName, request, response);

		// 이부분 확실히 처리 할것 - ryan
		if (mav.getView().equals("idCheck")) {
			PrintWriter pw = response.getWriter();
			String res = (String) mav.getData().get("USER_ID");
			if (res.equals((String) mav.getData().get("USER_ID"))) {
				pw.write(res);
			}
		} else if (mav.getView().equals("nickCheck")) {
			PrintWriter pw = response.getWriter();
			String res = (String) mav.getData().get("NICKNAME");
			if (res.equals((String) mav.getData().get("NICKNAME"))) {
				pw.write(res);
			}
		} else if (mav.getView().equals("file")) {
			FileUtil fu = new FileUtil();
			if (!fu.fileDownload(mav, response)) {
				mav.addObject("alertMsg", "파일 다운로드에 실패했습니다.");
				mav.addObject("back", "back");
				mav.setView("common/result");
				ViewResolver vr = new ViewResolver(mav.getView());
				RequestDispatcher rd = request.getRequestDispatcher(vr.getView());
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("data", mav.getData());
			ViewResolver vr = new ViewResolver(mav.getView());
			RequestDispatcher rd = request.getRequestDispatcher(vr.getView());
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
