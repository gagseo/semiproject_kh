package com.market.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.board.model.dao.BoardDao;
import com.market.board.model.vo.Board;
import com.market.board.model.vo.Market;

import common.JDBCTemplate;
import common.util.Paging;

public class BoardService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	BoardDao bdao = new BoardDao();

	public BoardService() {

	}

	/**
	 * com.market.board.model.service BoardService.java
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 27.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	public Board intro(int bd_no) {

		Board board = null;
		Connection conn = jdt.getConnection();

		board = bdao.intro(conn, bd_no);

		return board;

	}

	// ============================================================================================================================================
	// 리뷰 게시판

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param review_no
	 * @return
	 */

	public Board selectReview(int reviewNo) {

		Board board = null;
		Connection conn = jdt.getConnection();

		try {
			board = bdao.SelectReview(conn, reviewNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;

	}

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param board
	 * @return
	 */

	public int insertReview(Board board) {
		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = bdao.insertReview(conn, board);
			if (res >= 1) {
				jdt.commit(conn);
			} else {
				jdt.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return res;
	}

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param used_no
	 * @return
	 */

	public int deleteReview(int review_no) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = bdao.deleteReview(conn, review_no);
			if (res > 0) {
				jdt.commit(conn);
			} else {
				jdt.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public Map<String, Object> selectReviewList(String orderby, int currentPage, int cntPerPage) {

		Map<String, Object> res = new HashMap<String, Object>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> bList = null;

		try {
			p = new Paging(bdao.rContentCnt(conn), currentPage, cntPerPage);
			bList = bdao.selectReviewList(conn, p, orderby);
			res.put("paging", p);
			res.put("bList", bList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public Map<String, Object> searchReview(int currentPage, int cntPerPage, String searchType, String searchWord) {

		Map<String, Object> res = new HashMap<String, Object>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> sList = null;

		try {
			p = new Paging(bdao.rContentCnt(conn), currentPage, cntPerPage);
			sList = bdao.searchReview(currentPage, cntPerPage, searchType, searchWord);
			res.put("paging", p);
			res.put("bList", sList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}
	
	//게시글 수정
	public int editReview(Board board) {
		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = bdao.editReview(conn, board);
			if (res >= 1) {
				jdt.commit(conn);
			} else {
				jdt.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return res;
	}
	

	public Map<String, Object> rcSelect(int reviewNo, int currentPage, int cntPerPage) {

		Map<String, Object> res = new HashMap<>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> list = null;

		try {
			p = new Paging(bdao.rcContentCnt(conn, reviewNo), currentPage, cntPerPage);
			list = bdao.rcSelect(conn, p, reviewNo);
			res.put("paging", p);
			res.put("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public int rcInsert(Board board) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = bdao.rcInsert(conn, board);
			if (res >= 1) {
				jdt.commit(conn);
			} else {
				jdt.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return res;

	}

	public int rcDelete(int review_no) {

		int result = 0;
		Connection conn = jdt.getConnection();

		result = bdao.rcDelete(conn, review_no);
		return result;
	}

	// =================================================================================================================================================
	/**
	 * <pre>
	 * com.market.notice.model.service
	 * NoticeService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param noticeNo
	 * @return
	 */

	public Board selectNotice(int noticeNo) {

		Board board = null;
		Connection conn = jdt.getConnection();

		board = bdao.selectNotice(conn, noticeNo);

		return board;
	}

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param orderby
	 * @param currentPage
	 * @param cntPerPage
	 * @return
	 */

	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage) {

		Map<String, Object> res = new HashMap<>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> blist = null;

		try {
			p = new Paging(bdao.nContentCnt(conn), currentPage, cntPerPage);
			blist = bdao.selectNoticeList(conn, p, orderby);
			res.put("paging", p);
			res.put("blist", blist);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	// ============================================================================================================================
	// 시장 검색 게시판 기능 구현

	public List<Market> searchMarket(String searchType, String keyword) {

		List<Market> res = new ArrayList<>();
		Connection conn = jdt.getConnection();

		try {
			res = bdao.searchMarket(conn, searchType, keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;

	}

	// ============================================================================================================================
	// 중고 게시판

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param used_no
	 * @return
	 */

	public Board selectUsed(int used_no) {

		Board board = null;
		Connection conn = jdt.getConnection();

		try {
			board = bdao.SelectUsed(conn, used_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;

	}

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param board
	 * @return
	 */

	public int insertUsed(Board board) {

		Connection conn = jdt.getConnection();
		int result = 0;

		try {
			result = bdao.insertUsed(conn, board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result > 0) {
			jdt.close(conn);
		} else {
			jdt.rollback(conn);
		}

		jdt.close(conn);
		return result;

	}

	/**
	 * <pre>
	 * com.market.board.model.service
	 * BoardService.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 5. 1.
	 * @해야할일 :TODO
	 *
	 * @param used_no
	 * @return
	 */

	public int deleteUsed(int used_no) {

		int result = 0;
		Connection conn = jdt.getConnection();

		result = bdao.deleteUsed(conn, used_no);
		return result;

	}

	public Map<String, Object> selectUsedList(String orderby, int currentPage, int cntPerPage) {

		Map<String, Object> res = new HashMap<>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> bList = null;

		try {
			p = new Paging(bdao.uContentCnt(conn), currentPage, cntPerPage);
			bList = bdao.selectUsedList(conn, p, orderby);
			res.put("paging", p);
			res.put("bList", bList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public Map<String, Object> ucSelect(int used_no, int currentPage, int cntPerPage) {

		Map<String, Object> res = new HashMap<>();
		Paging p = null;
		List<Board> list = null;

		Connection conn = jdt.getConnection();

		try {
			p = new Paging(bdao.ucContentCnt(conn, used_no), currentPage, cntPerPage);
			list = bdao.ucSelect(conn, p, used_no);
			res.put("paging", p);
			res.put("list", list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		
		return res;

	}

	public int ucInsert(Board b) {

		Connection conn = jdt.getConnection();
		int result = 0;

		try {
			result = bdao.ucInsert(conn, b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result > 0) {
			jdt.close(conn);
		} else {
			jdt.rollback(conn);
		}

		jdt.close(conn);
		return result;

	}

	public int ucDelete(int used_no) {

		int result = 0;
		Connection conn = jdt.getConnection();

		result = bdao.ucDelete(conn, used_no);
		return result;
	}

}
