package com.market.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport;

import com.market.board.model.vo.Board;
import com.market.member.model.vo.Member;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import common.JDBCTemplate;
import common.util.Paging;

public class MemberDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	/**
	 * <pre>
	 * com.market.member.model.dao
	 * MemberDao.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 24.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public int insertMember(Connection conn, Member member) throws SQLException {

		int res = 0;
		String sql = "insert into smw_user(USER_NO,USER_NAME,USER_ID,USER_PWD,NICKNAME,USER_TELL1,USER_TELL2,USER_TELL3"
				+ ",BIRTHDAY_YY,BIRTHDAY_MM,BIRTHDAY_DD,ZIPCODE,ADDRESS,ADDRESS_ETC,USER_EMAIL,USER_EMAIL2)"
				+ " values(USER_NO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, member.getUser_name());
			pstm.setString(2, member.getUser_id());
			pstm.setString(3, member.getUser_pwd());
			pstm.setString(4, member.getNickname());
			pstm.setString(5, member.getUser_tell1());
			pstm.setString(6, member.getUser_tell2());
			pstm.setString(7, member.getUser_tell3());
			pstm.setString(8, member.getBirthday_yy());
			pstm.setString(9, member.getBirthday_mm());
			pstm.setString(10, member.getBirthday_dd());
			pstm.setString(11, member.getZipcode());
			pstm.setString(12, member.getAddress());
			pstm.setString(13, member.getAddress_etc());
			pstm.setString(14, member.getUser_mail());
			pstm.setString(15, member.getUser_mail2());

			res = pstm.executeUpdate();

		} finally {
			jdt.close(pstm);
		}

		return res;
	}

	/**
	 * <pre>
	 * com.market.member.model.dao
	 * MemberDao.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public String idCheck(Connection conn, String user_id) throws SQLException {

		String res = "";
		String sql = "select USER_ID from SMW_USER where USER_ID = '" + user_id + "'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				res = rs.getString(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}

	/**
	 * <pre>
	 * com.market.member.model.dao
	 * MemberDao.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 2.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param nickName
	 * @return
	 * @throws SQLException
	 */
	public String nickCheck(Connection conn, String nickName) throws SQLException {

		String res = "";
		String sql = "select nickname from smw_user where nickname = '" + nickName + "'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				res = rs.getString(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}

	/**
	 * <pre>
	 * com.market.member.model.dao
	 * MemberDao.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param user_id
	 * @param user_pw
	 * @return
	 * @throws SQLException
	 */
	public Member login(Connection conn, String user_id, String user_pw) throws SQLException {
		Member res = null;
		String sql = "select * from SMW_USER where USER_ID = ? and USER_PWD = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);
			pstm.setString(2, user_pw);
			rs = pstm.executeQuery();

			if (rs.next()) {
				res = new Member();
				res.setUser_no(rs.getInt(1));
				res.setUser_name(rs.getString(2));
				res.setUser_id(rs.getString(3));
				res.setUser_pwd(rs.getString(4));
				res.setNickname(rs.getString(5));
				res.setUser_tell1(rs.getString(6));
				res.setUser_tell2(rs.getString(7));
				res.setUser_tell3(rs.getString(8));
				res.setBirthday_yy(rs.getString(9));
				res.setBirthday_mm(rs.getString(10));
				res.setBirthday_dd(rs.getString(11));
				res.setZipcode(rs.getString(12));
				res.setAddress(rs.getString(13));
				res.setAddress_etc(rs.getString(14));
				res.setJoindate(rs.getDate(15));
				res.setUser_score(rs.getInt(16));
				res.setUser_mail(rs.getString(17));
				res.setUser_mail2(rs.getString(18));
				res.setIs_exit(rs.getString(19));
				res.setExit_date(rs.getDate(20));

			}

		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	public int deleteInfo(Connection conn, String user_id) throws SQLException {

		PreparedStatement pstm = null;
		int res = 0;
		String sql = "update smw_user SET IS_EXIT = 'y', EXIT_DATE = sysdate where user_id = ?";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);

			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}
		System.out.println(res);
		return res;
	}

	/**
	 * <pre>
	 * com.market.member.model.dao
	 * MemberDao.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 3.
	 * @해야할일 :TODO
	 *
	 * @param conn
	 * @param id
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public int modify(Connection conn, String id, Member member) throws SQLException {
		int res = -1;
		PreparedStatement pstm = null;
		try {
			String sql = "UPDATE SMW_USER SET USER_PWD=?, USER_TELL1=?, USER_TELL2=?, USER_TELL3=?, ZIPCODE=?, ADDRESS=?, ADDRESS_ETC=? WHERE USER_ID= ?";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, member.getUser_pwd());
			pstm.setString(2, member.getUser_tell1());
			pstm.setString(3, member.getUser_tell2());
			pstm.setString(4, member.getUser_tell3());
			pstm.setString(5, member.getZipcode());
			pstm.setString(6, member.getAddress());
			pstm.setString(7, member.getAddress_etc());
			pstm.setString(8, id);

			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);

		}
		return res;
	} // end modify

	public List<Board> myNoticeList(Connection conn, Paging p, String nickName) throws SQLException {
		// 마이페이지에 내가 등록한 게시글
		List<Board> myNoticeList = new ArrayList<Board>();
		String sql = "SELECT BD_REVIEW.REVIEW_TITLE,BD_REVIEW.REVIEW_WRITER,BD_REVIEW.REVIEW_TIME,BD_REVIEW.REVIEW_VIEWED"
				+ ",BD_USED.USED_TITLE,BD_USED.USED_WRITER,BD_USED.USED_TIME,BD_USED.USED_VIEWED "
				+ "FROM SMW_USER,BD_REVIEW,BD_USED " + "WHERE NICKNAME = '" + nickName
				+ "' AND NICKNAME = REVIEW_WRITER(+)" + " AND NICKNAME = USED_WRITER(+)";
		;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Board board = new Board();

				board.setReviewTitle(rs.getString(1));
				board.setReviewWriter(rs.getString(2));
				board.setReviewDate(rs.getDate(3));
				board.setReviewViewed(rs.getInt(4));
				board.setUsedTitle(rs.getString(5));
				board.setUsedWriter(rs.getString(6));
				board.setUsedDate(rs.getDate(7));
				board.setUsedViewed(rs.getInt(8));

				myNoticeList.add(board);
			}

			System.out.println("다오 내가 등록한 게시물 : " + myNoticeList);

		} finally {
			jdt.close(rs, stmt);
		}

		return myNoticeList;
	}

	public List<Board> myRcList(Connection conn, Paging p, String nickname) throws SQLException {
		// 마이페이지에 내가 댓글단 게시글
		List<Board> myRcList = new ArrayList<Board>();
		String sql = "SELECT BD_REVIEW.REVIEW_TITLE,BD_REVIEW.REVIEW_WRITER,BD_REVIEW.REVIEW_TIME,BD_REVIEW.REVIEW_VIEWED,"
				+ "BD_USED.USED_TITLE,BD_USED.USED_WRITER,BD_USED.USED_TIME,BD_USED.USED_VIEWED"
				+ " FROM SMW_USER,BD_REVIEW,REVIEW_COMMENT,BD_USED,USED_COMMENT WHERE NICKNAME = '" + nickname + "'"
				+ " AND NICKNAME = RVCOM_WRITER(+) AND NICKNAME = UDCOM_WRITER(+)";

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Board board = new Board();

				board.setReviewTitle(rs.getString(1));
				board.setReviewWriter(rs.getString(2));
				board.setReviewDate(rs.getDate(3));
				board.setReviewViewed(rs.getInt(4));
				board.setUsedTitle(rs.getString(5));
				board.setUsedWriter(rs.getString(6));
				board.setUsedDate(rs.getDate(7));
				board.setUsedViewed(rs.getInt(8));

				myRcList.add(board);
			}

			System.out.println("다오 댓글 게시글 : " + myRcList);
		} finally {
			jdt.close(rs, stmt);
		}

		return myRcList;
	}

	public List<Board> myUcList(Connection conn, Paging p, String nickname) throws SQLException {
		// 마이페이지에 내가 댓글 보기
		List<Board> myUcList = new ArrayList<Board>();

		String sql = "SELECT REVIEW_COMMENT.RVCOM_CONTENT, REVIEW_COMMENT.RVCOM_DATE,"
				+ "USED_COMMENT.UDCOM_CONTENT, USED_COMMENT.UDCOM_DATE" + " FROM SMW_USER,REVIEW_COMMENT,USED_COMMENT"
				+ " WHERE NICKNAME = '" + nickname + "' AND NICKNAME = REVIEW_COMMENT.RVCOM_WRITER(+) "
				+ "AND NICKNAME = USED_COMMENT.UDCOM_WRITER(+)";

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Board board = new Board();

				myUcList.add(board);
			}

		} finally {
			jdt.close(rs, stmt);
		}

		return myUcList;
	}

}
