package com.market.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.member.model.service.NoteService;
import com.market.member.model.vo.Member;
import com.market.member.model.vo.Note;

import common.frontController.Controller;
import common.frontController.ModelAndView;

public class NoteController implements Controller {

	NoteService ns = new NoteService();

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYENG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView noteBox(HttpServletRequest request, HttpServletResponse response) {
		// 쪽지함 접근
		ModelAndView mav = new ModelAndView();

		mav.setView("note/noteBox");
		return mav;
	}

	public ModelAndView countNote(HttpServletRequest request, HttpServletResponse response) {
		// 전체 쪽지가 몇통왔는지 확인

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		int res = ns.countNote(member.getUser_id());

		if (res >= 0) {
			// 전체쪽지의 수 담아주기
			mav.addObject("countNote", res);

		}
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView countNoteNoRead(HttpServletRequest request, HttpServletResponse response) {
		// 읽지않은 쪽지가 몇통왔는지 확인

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		int res = ns.countNoteNoRead(member.getUser_id());

		if (res >= 0) {
			// 읽지않은쪽지의 수 담아주기
			mav.addObject("countNoteNoRead", res);

		}
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertNote(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		// 쪽지 db에 저장

		// CREATE TABLE SMW_NOTE (
		// NOTE_NO NUMBER(6) PRIMARY KEY NOT NULL
		// ,SEND_USER VARCHAR2(30) NOT NULL
		// ,RECEIVE_USER VARCHAR2(30) NOT NULL
		// ,RECEIVE_DATE DATE DEFAULT SYSDATE NOT NULL
		// ,NOTE_TITLE NVARCHAR2(60) NOT NULL
		// ,NOTE_CONTENT NVARCHAR2(2000) NOT NULL
		// ,IS_READ VARCHAR2(1) DEFAULT 'N' NOT NULL
		// ,IS_DELETE VARCHAR2(1) DEFAULT 'N' NOT NULL
		// );

		Note note = new Note();

		note.setSend_user(request.getParameter("SEND_USER"));
		note.setReceive_user(request.getParameter("RECEIVE_USER"));
		note.setNote_title(request.getParameter("NOTE_TITLE"));
		note.setNote_content(request.getParameter("NOTE_CONTENT"));

		int res = ns.insertNote(note);
		if (res >= 1) {

			mav.addObject("noteInfo", note);

		} else {
			mav.addObject("isSuccess", "false");
		}

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView receiveNoteBox(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		// 받은쪽지함
		// 받은 쪽지함의 RECEIVE_USER가 로그인된 아이디와 같은지 확인하여 비교 후 뿌려주기
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");

		Note res = ns.receiveNoteBox(member.getUser_id());

		if (res != null) {

			session = request.getSession();
			session.setAttribute("receiveNote", res);
			mav.setView("note/receiveNoteBox");

		} else {

		}

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView sendNoteBox(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		// 보낸쪽지함
		// 보낸 쪽지함의 SEND_USER가 로그인된 아이디와 같은지 확인하여 비교하여 뿌려주기
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");

		Note res = ns.sendNoteBox(member.getUser_id());

		if (res != null) {

			session = request.getSession();
			session.setAttribute("sendNote", res);
			mav.setView("note/sendNoteBox");

		} else {

		}

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteReceiveNote(HttpServletRequest request, HttpServletResponse response) {
		// 받은 쪽지함 쪽지삭제
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");

		int res = ns.deleteReceiveNote(member.getUser_id());

		if (res > 0) {
			mav.addObject("alertMsg", "쪽지가 삭제되었습니다.");
			mav.addObject("url", "/smwMarket/note/sendNoteBox.do");
			mav.setView("common/result");
		} else {

		}
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * NoteController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 8.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteSendNote(HttpServletRequest request, HttpServletResponse response) {
		// 보낸 쪽지함 쪽지삭제
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");

		int res = ns.deleteSendNote(member.getUser_id());

		if (res > 0) {
			mav.addObject("alertMsg", "쪽지가 삭제되었습니다.");
			mav.addObject("url", "/smwMarket/note/sendNoteBox.do");
			mav.setView("common/result");
		} else {

		}
		return mav;
	}

}
