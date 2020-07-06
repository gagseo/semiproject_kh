package com.market.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.board.model.service.BoardService;
import com.market.board.model.vo.Board;
import com.market.board.model.vo.Market;
import com.market.member.model.vo.Member;

import common.frontController.Controller;
import common.frontController.ModelAndView;
import common.util.FileUtil;
import common.vo.UploadFile;

public class BoardController implements Controller {

	/**
	 * com.market.board.controller BoardController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	BoardService bs = new BoardService();

	public ModelAndView intro(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/intro");
		return mav;
	}

	// 5/6 넘어가는 페이지를 위해 추가기입함
	public ModelAndView introIntroduce(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/introIntroduce");
		return mav;
	}

	public ModelAndView introKind(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/introKind");
		return mav;
	}

	public ModelAndView introInstructions(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/introInstructions");
		return mav;
	}

	// ===========================================================================================================

	public ModelAndView reviewDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		int currentPage = 1;
		int cntPerPage = 5;

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		Board board = bs.selectReview(reviewNo);

		Map<String, Object> res = bs.rcSelect(reviewNo, currentPage, cntPerPage);
		mav.addObject("review", board);
		mav.addObject("rvcom", res.get("list"));
		mav.setView("board/reviewLeading");

		return mav;
	}

	public ModelAndView reviewDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		int reviewNo = Integer.parseInt(request.getParameter("deleteReview"));
		int res = bs.deleteReview(reviewNo);
		
		if (res > 0) {
			mav.addObject("alertMsg", "게시물을 삭제하였습니다.");
			mav.addObject("url", "/smwMarket/board/review.do");
			mav.setView("common/result");
		} else {
			mav.addObject("back", "back");
		}

		return mav;
	}

	public ModelAndView reviewInsert(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/reviewWriter");
		return mav;
	}

	public ModelAndView reviewUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView mav = new ModelAndView();
		Member member = (Member) request.getSession().getAttribute("loginInfo");

		String uploadFolder = "resources/upload";
		UploadFile uf = new FileUtil().fileUpload(uploadFolder, request);

		if (uf.isSuccess()) {
			mav.addObject("alertMsg", "게시물 등록이 성공되었습니다.");
			Board board = new Board();
			board.setReviewTitle(uf.getMrequest().getParameter("reviewTitle"));
			board.setReviewContent(uf.getMrequest().getParameter("reviewContent"));
			board.setReviewWriter(member.getNickname());
			board.setReview_orifile(uf.getOriginalFileName());
			board.setReview_refile(uf.getRenameFileName());
			board.setIsPublished(uf.getMrequest().getParameter("0"));

			if (bs.insertReview(board) > 0) {
				mav.addObject("alertMsg", "게시물 등록이 성공하였습니다.");
				mav.addObject("url", "/smwMarket/board/review.do");
				mav.setView("common/result");
			} else {
				mav.addObject("alertMsg", "게시물 등록이 실패하였습니다.");
				mav.addObject("back", "back");
				mav.setView("common/result");
			}
			mav.setView("common/result");
		}

		return mav;
	}

	public ModelAndView reviewList(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		int currentPage = 1;
		int cntPerPage = 10;
		String orderby = "review_no";

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = bs.selectReviewList(orderby, currentPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("bData", res.get("bList"));
		mav.setView("board/review");

		return mav;
	}

	public ModelAndView searchReview(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		int currentPage = 1;
		int cntPerPage = 5;
		String searchType = "";
		String searchWord = "";
		// String orderby = "review_no";

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		if (request.getParameter("searchType") != null) {
			searchType = request.getParameter("searchType");
		}

		if (request.getParameter("searchWord") != null) {
			searchWord = request.getParameter("searchWord");
		}

		Map<String, Object> res = bs.searchReview(currentPage, cntPerPage, searchType, searchWord);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("sData", res.get("sList"));
		mav.setView("board/review");

		return mav;
	}
	
	//게시글 수정
	public ModelAndView editReview(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		Member member = (Member) request.getSession().getAttribute("loginInfo");
		
		String uploadFolder = "resources/upload";
		UploadFile uf = new FileUtil().fileUpload(uploadFolder, request);
		
		if (uf.isSuccess()) {
			mav.addObject("alertMsg", "게시물 수정에 성공하였습니다.");
			Board board = new Board();
			board.setReviewTitle(uf.getMrequest().getParameter("reviewTitle"));
			board.setReviewContent(uf.getMrequest().getParameter("reviewContent"));
			board.setReviewWriter(member.getNickname());
			board.setReview_orifile(uf.getOriginalFileName());
			board.setReview_refile(uf.getRenameFileName());
			board.setIsPublished(uf.getMrequest().getParameter("0"));

			if (bs.editReview(board) > 0) {
				mav.addObject("alertMsg", "게시물 수정에 성공하였습니다.");
				mav.addObject("url", "/smwMarket/board/review.do");
				mav.setView("common/result");
			} else {
				mav.addObject("alertMsg", "게시물 수정에 실패하였습니다.");
				mav.addObject("back", "back");
				mav.setView("common/result");
			}
			mav.setView("common/result");
		}
		
		
		
		return mav;
	}

	// 댓글 쓰기
	public ModelAndView rcInsert(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Board board = new Board();

		board.setRc_writer(request.getParameter("rvcom_writer"));
		board.setRc_content(request.getParameter("rvcom_content"));
		board.setReviewNo(Integer.parseInt(request.getParameter("review_no")));

		if (bs.rcInsert(board) > 0) {
			mav.addObject("alertMsg", "댓글 등록이 성공하였습니다.");
			mav.addObject("url", "/smwMarket/board/reviewdetail.do?reviewNo=" + board.getReviewNo());
			mav.setView("common/result");
		} else {
			mav.addObject("alertMsg", "댓글 등록이 실패하였습니다.");
			mav.addObject("back", "back");
			mav.setView("common/result");
		}

		return mav;
	}

	// 댓글 삭제
	public ModelAndView rcDelete(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setView("board/reviewList");

		return mav;
	}

	// =======================================================================================================
	/**
	 * com.market.board.controller BoardController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView searchMarket(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/searchMarket");
		return mav;
	}

	// 마켓 검색 기능
	public ModelAndView marketInfo(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Market market = new Market(); // board vo의 market 인스턴스화

		String searchType = request.getParameter("searchType"); // searchMarket.jsp에서 파라미터로 검색 조건을 가져옴
		String keyword = request.getParameter("srBar"); // 검색어를 받아옴

		List<Market> res = bs.searchMarket(searchType, keyword); // 서비스를 호출하면서 매개변수로 jsp에서 받은 값을 넘겨준다.
		mav.addObject("search", res);
		mav.setView("board/searchMarket");

		for (Market mar : res) {
			System.out.println(mar.getNameBrand());
			System.out.println(mar.getLatitude());
			System.out.println(mar.getLongitude());
		}

		return mav;
	}

	// =================================================================================================================

	/**
	 * com.market.board.controller BoardController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView usedDetail(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		int currentPage = 1;
		int cntPerPage = 5;
		
		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}
		
		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		int usedNo = Integer.parseInt(request.getParameter("usedNo"));
		Board board = bs.selectUsed(usedNo);
		
		Map<String, Object> res = bs.ucSelect(usedNo, currentPage, cntPerPage);
		
		mav.addObject("used", board);
		mav.addObject("udcom", res.get("list"));
		mav.setView("board/usedLeading");
		
		return mav;
	}
	

	public ModelAndView usedInsert(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Board board = new Board();

		mav.setView("board/usedMarketWriter");
		return mav;
	}

	public ModelAndView usedDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/usedMarket");
		return mav;
	}

	public ModelAndView usedUpload(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Member member = (Member) request.getSession().getAttribute("loginInfo");

		String uploadFolder = "resources/upload";
		UploadFile uf = new FileUtil().usedfileUpload(uploadFolder, request);

		if (uf.isSuccess()) {
			mav.addObject("alertMsg", "게시물 등록이 성공되었습니다.");
			Board board = new Board();
			board.setUsedTitle(uf.getMrequest().getParameter("usedTitle"));
			board.setUsedContent(uf.getMrequest().getParameter("usedContent"));
			board.setUsedWriter(member.getNickname());
			board.setSellPrice(uf.getMrequest().getParameter("usedPrice"));
			board.setUsed_orifile(uf.getOriginalFileName());
			board.setUsed_refile(uf.getRenameFileName());
			board.setIsPublished(uf.getMrequest().getParameter("0"));

			if (bs.insertUsed(board) > 0) {
				mav.addObject("alertMsg", "게시물 등록이 성공하였습니다.");
				mav.addObject("url", "/smwMarket/board/usedmarket.do");
				mav.setView("common/result");
			} else {
				mav.addObject("alertMsg", "게시물 등록이 실패하였습니다.");
				mav.addObject("back", "back");
				mav.setView("common/result");
			}
			mav.setView("common/result");
		}

		return mav;
	}

	// 페이징 기능
	public ModelAndView usedList(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		int currentPage = 1;
		int cntPerPage = 12;
		String orderby = "used_no";

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = bs.selectUsedList(orderby, currentPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("bData", res.get("bList"));
		mav.setView("board/usedMarket");

		return mav;
	}

/*	// 중고 게시판 댓글 기능
	public ModelAndView ucSelect(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		int board = Integer.parseInt(request.getParameter("uc_no"));
		Board b = bs.ucSelect(board);

		mav.addObject("used", b);
		mav.setView("board/used");

		return mav;
	}*/

	// 댓글 쓰기
	public ModelAndView ucInsert(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Board board = new Board();

		board.setUc_writer(request.getParameter("udcom_writer"));
		board.setUc_content(request.getParameter("udcom_content"));
		board.setUsedNo(Integer.parseInt(request.getParameter("usedNo")));

		if (bs.ucInsert(board) > 0) {
			mav.addObject("alertMsg", "댓글 등록이 성공하였습니다.");
			mav.addObject("url", "/smwMarket/board/useddetail.do?usedwNo=" + board.getUsedNo());
			mav.setView("common/result");
		} else {
			mav.addObject("alertMsg", "댓글 등록이 실패하였습니다.");
			mav.addObject("back", "back");
			mav.setView("common/result");
		}

		return mav;
	}

	// 댓글 삭제
	public ModelAndView ucDelete(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		mav.setView("board/usedList");

		return mav;
	}

	// =================================================================================================================
	// 공지 게시판

	/**
	 * com.market.board.controller BoardController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView notice(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("board/notice");
		return mav;
	}

	/**
	 * <pre>
	 * com.market.notice.controller
	 * NoticeController.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @return
	 */

	public ModelAndView noticeDetail(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		int board = Integer.parseInt(request.getParameter("noticeNo"));
		Board b = bs.selectNotice(board);

		mav.addObject("notice", b);
		mav.setView("board/notice");

		return mav;
	}

	/**
	 * <pre>
	 * com.market.board.controller
	 * BoardController.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @return
	 */
	// 페이징 기능
	public ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		int currentPage = 1;
		int cntPerPage = 5;
		String orderby = "noticeno";

		if (request.getParameter("cPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("cPage"));
		}

		if (request.getParameter("cntPerPage") != null) {
			cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
		}

		Map<String, Object> res = bs.selectNoticeList(orderby, currentPage, cntPerPage);

		mav.addObject("paging", res.get("paging"));
		mav.addObject("bdata", res.get("blist"));
		mav.setView("board/notice");

		return mav;
	}

}
