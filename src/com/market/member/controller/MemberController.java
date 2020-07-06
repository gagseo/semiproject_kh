package com.market.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.member.model.service.MemberService;
import com.market.member.model.vo.Member;

import common.frontController.Controller;
import common.frontController.ModelAndView;

public class MemberController implements Controller {

	MemberService ms = new MemberService();

	/**
	 * com.market.member.controller MemberController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView memberJoin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("member/memberJoin");
		return mav;
	}

	/**
	 * com.market.member.controller MemberController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("member/memberLogin");
		return mav;
	}

	/**
	 * com.market.member.controller MemberController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 24.
	 * @해야할일 :TODO 로그인 처리 하고 session에 loginInfo 라는 키값으로 Member 객체 저장할것. session에
	 *       Member객체 저장 하였고, Member 객체가 null일 경우 alert창 띄워주고 메세지 출력 ,에러 페이지 구현 전임
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		// 파라미터 값이 대문자입니다.
		String user_id = request.getParameter("USER_ID").toUpperCase();
		String user_pw = request.getParameter("USER_PWD");

		Member res = ms.login(user_id, user_pw);

		if (res != null) {

			if (res.getIs_exit().toUpperCase().equals("N")) {
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", res);
				mav.setView("index/index");
			} else {
				mav.addObject("alertMsg", "탈퇴된 회원입니다.");
				mav.addObject("url", "/smwMarket/index/index.do");
				mav.setView("common/result");
			}
		} else {
			mav.addObject("alertMsg", "아이디나 비밀번호를 확인하세요");
			mav.addObject("url", "/smwMarket/index/index.do");
			mav.setView("common/result");
		}
		return mav;
	}

	/**
	 * com.market.member.controller MemberController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView myPagePw(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("member/myPagePw");
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 4.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		// HttpSession session = request.getSession(false);
		// Member member = (Member) session.getAttribute("loginInfo");
		// // 찾는 용도
		// String nickName = member.getNickname();
		// int currentPage = 1;
		// int cntPerPage = 10;
		//
		// if (request.getParameter("cPage") != null) {
		// currentPage = Integer.parseInt(request.getParameter("cPage"));
		// }
		//
		// if (request.getParameter("cntPerPage") != null) {
		// cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		// }
		//
		// // 분기문 나눌것
		// // 마이페이지에서 등록한 게시글, 댓글단게시글, 등록한댓글 로
		//
		// Map<String, Object> res1 = ms.myNoticeList(nickName, currentPage,
		// cntPerPage);
		// Map<String, Object> res2 = ms.myRcList(nickName, currentPage, cntPerPage);
		// Map<String, Object> res3 = ms.myUcList(nickName, currentPage, cntPerPage);

		// Map<String,String[]> res = request.getParameterMap();
		// System.out.println(request);
		// for(String sss : res.keySet()) {
		// System.out.println(res.size());
		// System.out.println("================================");
		// System.out.println(sss);
		// }
		//
		// System.out.println(res.get("mynoticelist"));
		//
		// System.out.println(request.getParameter("mynoticelist"));
		// if (request.getParameter("mynoticelist").equals("mynoticelist")) {
		// mav.addObject("paging", res1.get("paging"));
		// mav.addObject("bData", res1.get("myNoticeList"));
		// mav.addObject("url", "/smwMarket/member/mynoticelist.do");
		// mav.setView("common/result");
		// System.out.println("mypage.noticeList : " + res1);
		// } else if (request.getParameter("myrclist").equals("myrclist")) {
		// mav.addObject("paging", res2.get("paging"));
		// mav.addObject("bData", res2.get("myRcList"));
		// mav.addObject("url", "/smwMarket/member/myrclist.do");
		// mav.setView("common/result");
		// System.out.println("내가 등록한 게시글 보기" + res2);
		// } else if (request.getParameter("myuclist").equals("myuclist")) {
		// mav.addObject("paging", res3.get("paging"));
		// mav.addObject("bData", res3.get("myUcList"));
		// mav.addObject("url", "/smwMarket/member/myuclist.do");
		// mav.setView("common/result");
		// }

		mav.setView("member/myPage");
		return mav;
	}

	/**
	 * com.market.member.controller MemberController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 24.
	 * @해야할일 :TODO 리디렉션 URL이 네이버로 설정되어있음, 추후 결정되는 곳으로 리디렉션 해주면 됨. 우리 인덱스 페이지로 설정
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		// 세션이 존재하지 않다면 새로 생성하지 않음.
		HttpSession session = request.getSession(false);
		// 세션에는 로그인 정보 뿐만 아니라 많은 정보를 저장하기 때문에 invalidate 하지 않고, 로그인 정보만 삭제 한다.
		session.removeAttribute("loginInfo");
		mav.setView("index/index");

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView join(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		Member member = new Member();
		member.setUser_id(request.getParameter("USER_ID").toUpperCase());
		member.setUser_name(request.getParameter("USER_NAME").toUpperCase());
		member.setUser_pwd(request.getParameter("USER_PWD"));
		member.setNickname(request.getParameter("NICKNAME").toUpperCase());
		member.setUser_tell1(request.getParameter("USER_TELL1"));
		member.setUser_tell2(request.getParameter("USER_TELL2"));
		member.setUser_tell3(request.getParameter("USER_TELL3"));
		member.setBirthday_yy(request.getParameter("BIRTHDAY_YY"));
		member.setBirthday_mm(request.getParameter("BIRTHDAY_MM"));
		member.setBirthday_dd(request.getParameter("BIRTHDAY_DD"));
		member.setZipcode(request.getParameter("ZIPCODE"));
		member.setAddress(request.getParameter("ADDRESS"));
		System.out.println(request.getParameter("ADDRESS"));
		member.setAddress_etc(request.getParameter("ADDRESS_ETC"));
		member.setUser_mail(request.getParameter("USER_MAIL"));
		member.setUser_mail2(request.getParameter("USER_MAIL2"));

		int res = ms.insertMember(member);
		if (res >= 1) {
			// 가입성공 후 성공페이지로 이동, 이동후 가입내용 보여주기
			mav.setView("member/joinComplete");
			// Ryan - memberInfo 라는 키값으로 member 객체를 모두 보내줌.
			mav.addObject("memberInfo", member);

		} else {
			mav.setView("member/memberJoin");
			mav.addObject("isSuccess", "false");
		}
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @return
	 */
	public ModelAndView idCheck(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		String res = ms.idCheck(request.getParameter("USER_ID").toUpperCase());
		mav.setView("idCheck");
		mav.addObject("USER_ID", res);

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 2.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView nickCheck(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		String res = ms.nickCheck(request.getParameter("NICKNAME").toUpperCase());
		mav.setView("nickCheck");
		mav.addObject("NICKNAME", res);
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView joinEmailCheck(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Member member = new Member();
		member.setUser_id(request.getParameter("USER_ID"));
		member.setUser_name(request.getParameter("USER_NAME"));
		member.setUser_pwd(request.getParameter("USER_PWD"));
		member.setNickname(request.getParameter("NICKNAME"));
		member.setUser_tell1(request.getParameter("USER_TELL1"));
		member.setUser_tell2(request.getParameter("USER_TELL2"));
		member.setUser_tell3(request.getParameter("USER_TELL3"));
		member.setBirthday_yy(request.getParameter("BIRTHDAY_YY"));
		member.setBirthday_mm(request.getParameter("BIRTHDAY_MM"));
		member.setBirthday_dd(request.getParameter("BIRTHDAY_DD"));
		member.setZipcode(request.getParameter("ZIPCODE"));
		member.setAddress(request.getParameter("ADDRESS"));
		member.setAddress_etc(request.getParameter("ADDRESS_ETC"));
		member.setUser_mail(request.getParameter("USER_MAIL"));
		member.setUser_mail2(request.getParameter("USER_MAIL2"));

		ms.joinEmailCheck(member);
		mav.addObject("alertMsg", "등록하신 이메일로 인증메일이 발송되었습니다.");
		mav.addObject("url", "/smwMarket/index/index.do");
		mav.setView("common/result");
		return mav;

	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 4.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteInfo(HttpServletRequest request, HttpServletResponse response) {
		// 회원 탈퇴 기능
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		int res = ms.deleteInfo(member.getUser_id());
		if (res > 0) {
			session.removeAttribute("loginInfo");
			mav.addObject("alertMsg", "탈퇴가 완료되었습니다.");
			mav.addObject("url", "/smwMarket/index/index.do");
			mav.setView("common/result");
		} else {
			mav.addObject("alertMsg", "탈퇴가 정상 처리되지 않았습니다.");
			mav.addObject("url", "/smwMarket/member/mypage.do");
			mav.setView("common/result");
		}
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 4.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse response) {
		// 마이페이지에서 바로 수정
		// 회원 수정 기능
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		// 찾는 용도
		String id = member.getUser_id();
		int result = -1;
		// 수정하는 용도

		// 다듬기
		// 변경 사항 빼고 원래 정보 담아주기
		if (member.getUser_pwd().equals(request.getParameter("USER_PWD"))
				&& member.getUser_tell1().equals(request.getParameter("USER_TELL1"))
				&& member.getUser_tell2().equals(request.getParameter("USER_TELL2"))
				&& member.getUser_tell3().equals(request.getParameter("USER_TELL3"))
				&& member.getZipcode().equals(request.getParameter("ZIPCODE"))
				&& member.getAddress().equals(request.getParameter("ADDRESS"))
				&& member.getAddress_etc().equals(request.getParameter("ADDRESS_ETC"))) {
			result = 0;
		} else {

			member.setUser_pwd(request.getParameter("USER_PWD"));
			member.setUser_tell1(request.getParameter("USER_TELL1"));
			member.setUser_tell2(request.getParameter("USER_TELL2"));
			member.setUser_tell3(request.getParameter("USER_TELL3"));
			member.setZipcode(request.getParameter("ZIPCODE"));
			member.setAddress(request.getParameter("ADDRESS"));
			member.setAddress_etc(request.getParameter("ADDRESS_ETC"));

			result = ms.modify(id, member);
		}

		if (result > 0) {
			session.setAttribute("loginInfo", member);
			mav.addObject("alertMsg", "회원정보가 수정되었습니다.");
			mav.addObject("url", "/smwMarket/member/mypage.do");
			mav.setView("common/result");
		} else if (result == 0) {
			mav.addObject("alertMsg", "수정된 항목이 없습니다.");
			mav.addObject("url", "/smwMarket/member/mypage.do");
			mav.setView("common/result");
		} else {
			mav.addObject("alertMsg", "회원정보 수정에 실패하였습니다.");
			mav.addObject("url", "/smwMarket/member/mypage.do");
			mav.setView("common/result");
		}
		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
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
	public ModelAndView myNoticeList(HttpServletRequest request, HttpServletResponse response) {
		// 마이페이지에 내가 등록한 게시글 보기
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		// 찾는 용도
		String nickName = member.getNickname();
		int currentPage = 1;
		int cntPerPage = 10;

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = ms.myNoticeList(nickName, currentPage, cntPerPage);
		System.out.println("컨트롤러 res " + res);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("bData", res.get("myNoticeList"));
		mav.setView("member/myPage");

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
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
	public ModelAndView myRcList(HttpServletRequest request, HttpServletResponse response) {
		// 마이페이지에 내가 등록한 게시글 보기
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		// 찾는 용도
		String nickName = member.getNickname();
		int currentPage = 1;
		int cntPerPage = 10;

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = ms.myRcList(nickName, currentPage, cntPerPage);
		System.out.println("내가 등록한 게시글 보기" + res);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("bData", res.get("myRcList"));
		mav.setView("member/myPage");

		return mav;
	}

	/**
	 * <pre>
	 * com.market.member.controller
	 * MemberController.java
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
	public ModelAndView myUcList(HttpServletRequest request, HttpServletResponse response) {
		// 마이페이지에 내가 댓글 보기
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("loginInfo");
		// 찾는 용도
		String nickName = member.getNickname();
		int currentPage = 1;
		int cntPerPage = 10;

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = ms.myUcList(nickName, currentPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("bData", res.get("myUcList"));
		mav.setView("member/myPage");

		return mav;
	}

}
