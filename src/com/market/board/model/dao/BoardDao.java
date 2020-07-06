package com.market.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.market.board.model.vo.Board;
import com.market.board.model.vo.Market;

import common.JDBCTemplate;
import common.util.Paging;

public class BoardDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public BoardDao() {

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

	public Board intro(Connection conn, int bd_no) {

		Board board = new Board();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from ";

		return board;
	}

	// 리뷰 게시판 DAO
	// ====================================================================================================================================
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

	public Board SelectReview(Connection conn, int reviewNo) throws SQLException {

		Board board = null;
		PreparedStatement pstmt = null;
		String sql = "select * from bd_review where review_no = ?";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();
				board.setReviewNo(rs.getInt(1));
				board.setReviewTitle(rs.getString(2));
				board.setReviewWriter(rs.getString(3));
				board.setReviewDate(rs.getDate(4));
				board.setReviewViewed(rs.getInt(5));
				board.setReview_orifile(rs.getString(6));
				board.setReview_refile(rs.getString(7));
				board.setReviewContent(rs.getString(8));
				board.setIsDelete(rs.getString(10));
			}
		} finally {
			jdt.close(rs, pstmt);
		}

		return board;

	}

	// 조회수 증가 메서드
	public void increaseViews(int review_no) {

		Connection conn = jdt.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update bd_review set review_viewed = review_viewed + 1 where review_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_no);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
			jdt.close(conn);
		}

	}

	// 리뷰 게시물 작성 및 파일 업로드
	public int insertReview(Connection conn, Board b) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into bd_review(review_no, review_title, review_writer, review_orifile,"
				+ "review_refile, review_content, is_published)" 
				+ "values(review_no.nextval, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getReviewTitle());
			pstmt.setString(2, b.getReviewWriter());
			pstmt.setString(3, b.getReview_orifile());
			pstmt.setString(4, b.getReview_refile());
			pstmt.setString(5, b.getReviewContent());
			pstmt.setString(6, b.getIsPublished());

			result = pstmt.executeUpdate();

		} finally {
			jdt.close(pstmt);
		}

		return result;
	}

	// 리뷰 게시물 지우는 dao

	public int deleteReview(Connection conn, int review_no) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update bd_review set is_delete = 'Y' where review_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_no);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
		}
		return result;

	}

	public List<Board> selectReviewList(Connection conn, Paging p, String orderby) throws SQLException {

		List<Board> bList = new ArrayList<Board>();
		String sql = " select * from (select rownum rnum, n1.* from (select * from bd_review " + " order by " + orderby
				+ " desc) n1) where rnum between ? and ? ";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getStart());
			pstm.setInt(2, p.getEnd());
			rs = pstm.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setReviewNo(rs.getInt(2));
				board.setReviewTitle(rs.getString(3));
				board.setReviewWriter(rs.getString(4));
				board.setReviewDate(rs.getDate(5));
				board.setReviewViewed(rs.getInt(6));
				board.setIsPublished(rs.getString(10));
				board.setIsDelete(rs.getString(11));

				bList.add(board);
			}

		} finally {
			jdt.close(rs, pstm);
		}

		return bList;
	}
	
	//게시글 수정
	public int editReview(Connection conn, Board b) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update set bd_review(review_no, review_title, review_writer, review_orifile,"
				+ "review_refile, review_content, is_published)" 
				+ "values(review_no.nextval, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getReviewTitle());
			pstmt.setString(2, b.getReviewWriter());
			pstmt.setString(3, b.getReview_orifile());
			pstmt.setString(4, b.getReview_refile());
			pstmt.setString(5, b.getReviewContent());
			pstmt.setString(6, b.getIsPublished());

			result = pstmt.executeUpdate();

		} finally {
			jdt.close(pstmt);
		}

		return result;
	}
	
	
	
	
	

	// 리뷰게시판 검색
	public ArrayList<Board> searchReview(int currentPage, int cntPerPage, String searchType, String searchWord) {

		ArrayList<Board> list = new ArrayList<Board>();
		Connection conn = jdt.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Paging p = new Paging();
		currentPage = p.getCurrentPage();

		try {
			if (searchWord == "" || searchWord.equals("") || searchWord == null) {
				String sql = "select * from bd_review order by review_no desc";
				pstmt = conn.prepareStatement(sql);
			} else {
				String sql = "select * from bd_review where " + searchType + " like ? " + "order by review_no desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");
			}

			rs = pstmt.executeQuery();

			int startRow = (currentPage - 1) * 7;
			for (int i = 0; i < startRow; i++) {
				rs.next();
			}
			int j = 0;
			while (rs.next() && j < 5) {
				Board board = new Board();

				board.setReviewNo(rs.getInt(2));
				board.setReviewTitle(rs.getString(3));
				board.setReviewWriter(rs.getString(4));
				board.setReviewDate(rs.getDate(5));
				board.setReviewViewed(rs.getInt(6));
				board.setIsPublished(rs.getString(10));

				list.add(board);

				j++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("searchReview 게시판 에러 임");
		} finally {
			jdt.close(rs);
			jdt.close(pstmt);
			jdt.close(conn);
		}

		return list;

	}

	public int rContentCnt(Connection conn) throws SQLException {

		int res = 0;

		String sql = "select count(*) from bd_review";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				res = rs.getInt(1);
			}

		} finally {
			jdt.close(rs, stmt);
		}

		return res;
	}

	// 댓글 dao
	public List<Board> rcSelect(Connection conn, Paging p, int reviewNo) throws SQLException {

		List<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		String sql = "select * from review_comment where review_no = ?";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setRc_no(rs.getInt(1));
				board.setRc_writer(rs.getString(3));
				board.setRc_content(rs.getString(4));
				board.setRc_date(rs.getDate(5));

				list.add(board);
			}

		} finally {
			jdt.close(rs, pstmt);
		}

		return list;
	}

	public int rcContentCnt(Connection conn, int reviewNo) throws SQLException {

		int res = 0;

		String sql = "select count(*) from review_comment where review_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				res = rs.getInt(1);
			}

		} finally {
			jdt.close(rs, pstmt);
		}

		return res;
	}

	public int rcInsert(Connection conn, Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into review_comment(rvcom_no, review_no, rvcom_writer, rvcom_content)"
				+ " values (rvcom_no.nextval,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getReviewNo());
			pstmt.setString(2, board.getRc_writer());
			pstmt.setString(3, board.getRc_content());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
		}

		return result;

	}

	public int rcDelete(Connection conn, int review_no) {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from review_comment where review_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_no);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
		}
		return result;

	}

	// 공지사항 DAO
	// =========================================================================================================================================

	/**
	 * <pre>
	 * com.market.notice.model.dao
	 * NoticeDao.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param noticeNo
	 * @return
	 */

	public Board selectNotice(Connection conn, int noticeNo) {

		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from bd_notice where notice_no = ?; " + "execute ex_notice(?)";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, noticeNo);
			pstm.setInt(2, noticeNo);
			rs = pstm.executeQuery();

			if (rs.next()) {
				board = new Board();

				board.setNoticeNo(rs.getInt(1));
				board.setNoticeTitle(rs.getString(2));
				board.setNoticeWriter(rs.getString(3));
				board.setNoticeDate(rs.getDate(4));
				board.setNoticeViewed(rs.getInt(5));

				board.setNoticeContent(rs.getString(7));

				rs = pstm.executeQuery();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstm);
		}

		return board;
	}

	/**
	 * <pre>
	 * com.market.notice.model.dao
	 * NoticeDao.java
	 * </pre>
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @return
	 */

	public List<Board> selectNoticeList(Connection conn, Paging p, String orderby) throws SQLException {

		List<Board> blist = new ArrayList<Board>();
		String sql = " select * from " + " (select rownum rnum, n1.* " + " from " + " (select * from bd_notice "
				+ " order by " + orderby + " desc) n1) " + " where rnum between ? and ? ";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getStart());
			pstm.setInt(2, p.getEnd());
			rs = pstm.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setNoticeNo(rs.getInt(2));
				board.setNoticeTitle(rs.getString(3));
				board.setNoticeDate(rs.getDate(4));
				board.setNoticeContent(rs.getString(5));

				blist.add(board);
			}

		} finally {
			jdt.close(rs, pstm);
		}

		return blist;
	}

	public int nContentCnt(Connection conn) throws SQLException {

		int res = 0;

		String sql = "select count(*) from bd_notice";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				res = rs.getInt(1);
			}

		} finally {
			jdt.close(rs, stmt);
		}

		return res;
	}

	// =======================================================================================================================
	// 시장 검색 DAO

	public List<Market> searchMarket(Connection conn, String searchType, String keyword) throws SQLException {

		List<Market> list = new ArrayList<Market>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from local_currency where " + searchType + " like '%' || ? || '%'";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, keyword);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Market market = new Market();

				market.setNameCity(rs.getString(1));
				market.setNameBrand(rs.getString(2));
				market.setNameBusiness(rs.getString(3));
				market.setAdresRoad(rs.getString(4));
				market.setAdresNum(rs.getString(5));
				market.setTell(rs.getString(6));
				market.setZipcode(rs.getString(7));
				market.setLatitude(rs.getString(8));
				market.setLongitude(rs.getString(9));
				market.setDataUpdate(rs.getDate(10));

				list.add(market);
			}
		} finally {
			jdt.close(pstm);
		}

		return list;

	}

	// ======================================================================================================================
	// 중고 게시판

	/**
	 * com.market.notice.model.dao NoticeDao.java
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 29.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param used_no
	 * @return
	 */

	public Board SelectUsed(Connection conn, int used_no) throws SQLException {

		Board Board = null;
		PreparedStatement pstmt = null;
		String sql = "select * from bd_used where used_no = ?";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, used_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Board = new Board();
				Board.setUsedNo(rs.getInt(1));
				Board.setUsedTitle(rs.getString(2));
				Board.setUsedWriter(rs.getString(3));
				Board.setSellPrice(rs.getString(4));
				Board.setUsedDate(rs.getDate(5));
				Board.setUsedViewed(rs.getInt(6));
				Board.setUsed_orifile(rs.getString(7));
				Board.setUsed_refile(rs.getString(8));
				Board.setUsedContent(rs.getString(9));
				Board.setIsPublished(rs.getString(10));
			}

		} finally {
			jdt.close(rs, pstmt);
		}
		return Board;
	}

	// 중고 게시판 조회수 증가 메서드
	public void increaseUsed(int used_no) {

		Connection conn = jdt.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update bd_used set used_viewed = used_viewed + 1 where used_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, used_no);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
			jdt.close(conn);
		}

	}

	/**
	 * com.market.notice.model.dao NoticeDao.java
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 29.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param used_no
	 * @return
	 */

	public int insertUsed(Connection conn, Board b) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO BD_USED(USED_NO, USED_TITLE, USED_WRITER, "
				+ "SELL_PRICE, USED_ORIFILE, USED_REFILE, USED_CONTENT, IS_PUBLISHED)"
				+ "VALUES(USED_NO.NEXTVAL,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getUsedTitle());
			pstmt.setString(2, b.getUsedWriter());
			pstmt.setString(3, b.getSellPrice());
			pstmt.setString(4, b.getUsed_orifile());
			pstmt.setString(5, b.getUsed_refile());
			pstmt.setString(6, b.getUsedContent());
			pstmt.setString(7, b.getIsPublished());

			result = pstmt.executeUpdate();

		} finally {
			jdt.close(pstmt);
		}

		return result;
	}

	/**
	 * com.market.notice.model.dao NoticeDao.java
	 *
	 * @작성자 : Sohn
	 * @작업일 : 2020. 4. 29.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param used_no
	 * @return
	 */

	public int deleteUsed(Connection conn, int used_no) {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from bd_used where used_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, used_no);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
		}
		return result;
	}

	public List<Board> selectUsedList(Connection conn, Paging p, String orderby) throws SQLException {

		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from (select rownum rnum, n1.* from (select * from bd_used " + " order by " + orderby
				+ " desc) n1) where rnum between ? and ? ";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getStart());
			pstm.setInt(2, p.getEnd());
			rs = pstm.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setUsedNo(rs.getInt(2));
				board.setUsedTitle(rs.getString(3));
				board.setUsedWriter(rs.getString(4));
				board.setSellPrice(rs.getString(5));
				board.setUsedDate(rs.getDate(6));
				board.setUsedViewed(rs.getInt(7));
				board.setUsed_orifile(rs.getString(8));
				board.setUsed_refile(rs.getString(9));
				board.setUsedContent(rs.getString(10));
				board.setIsPublished(rs.getString(11));

				bList.add(board);
			}

		} finally {
			jdt.close(rs, pstm);
		}

		return bList;
	}

	public int uContentCnt(Connection conn) throws SQLException {

		int res = 0;

		String sql = "select count(*) from bd_used";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				res = rs.getInt(1);
			}

		} finally {
			jdt.close(rs, stmt);
		}

		return res;
	}

	// 댓글 dao
	public List<Board> ucSelect(Connection conn, Paging p, int used_no) throws SQLException {

		List<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		String sql = "select * from used_comment where used_no = ?";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, used_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				
				board.setUc_no(rs.getInt(1));
				board.setUc_writer(rs.getString(3));
				board.setUc_content(rs.getString(4));
				board.setUc_date(rs.getDate(5));
				board.setIsDelete(rs.getString(6));
				
				list.add(board);
			}

		} finally {
			jdt.close(pstmt);
		}

		return list;
	}

	public int ucInsert(Connection conn, Board b) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into used_comment(UDCOM_NO,USED_NO,UDCOM_WRITER,UDCOM_CONTENT)" + " values (udcom_no.nextval,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getUsedNo());
			pstmt.setString(2, b.getUc_writer());
			pstmt.setString(3, b.getUc_content());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
		}

		return result;

	}

	public int ucDelete(Connection conn, int used_no) {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from used_comment where used_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, used_no);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstmt);
		}
		return result;

	}
	
	public int ucContentCnt(Connection conn, int usedNo) throws SQLException {

		int res = 0;

		String sql = "select count(*) from used_comment where used_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				res = rs.getInt(1);
			}

		} finally {
			jdt.close(rs, pstmt);
		}

		return res;
	}

}
