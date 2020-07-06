package com.market.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.market.member.model.vo.Member;
import com.market.member.model.vo.Note;

import common.JDBCTemplate;

public class NoteDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public int countNote(Connection conn, String user_id) throws SQLException {
		int res = 0; // 카운트의 지역변수니까 초기화

		PreparedStatement pstm = null;
		ResultSet rs = null;
		// 쪽지가 몇통왔는지 알려주기 위한 쿼리를 작성
		// 받는 사람 아이디가 내 아이디 이면 내 쪽지 이므로 조건을 사용한다.
		String sql = "SELECT count(*) FROM SMW_NOTE WHERE receive_user ='" + user_id + "'";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			rs.next(); // 한건만 결과를 가져오니까
			res = rs.getInt(1); // 값을 가져온다

		} finally {
			jdt.close(pstm);
		}

		return res; // 몇통 왔는지 알려줘야 하니까 리턴
	}

	public int countNoteNoRead(Connection conn, String user_id) throws SQLException {
		int res = 0; // 카운트의 지역변수니까 초기화

		PreparedStatement pstm = null;
		ResultSet rs = null;
		// 쪽지가 몇통왔는지 알려주기 위한 쿼리를 작성
		// 받는 사람 아이디가 내 아이디 이면 내 쪽지 이므로 조건을 사용한다.
		String sql = "SELECT count(*) FROM SMW_NOTE WHERE receive_user ='" + user_id + "'" + "   AND is_read = N";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			rs.next(); // 한건만 결과를 가져오니까
			res = rs.getInt(1); // 값을 가져온다

		} finally {
			jdt.close(pstm);
		}

		return res; // 몇통 왔는지 알려줘야 하니까 리턴
	}

	public int insertNote(Connection conn, Note note) throws SQLException {
		int res = 0;
		PreparedStatement pstm = null;

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

		String sql = "INSERT INTO SMW_NOTE VALUES(NOTE_NO.nextval, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, note.getSend_user());
			pstm.setString(2, note.getReceive_user());
			pstm.setString(3, note.getNote_title());
			pstm.setString(4, note.getNote_content());

			res = pstm.executeUpdate();
		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	public Note receiveNoteBox(Connection conn, String user_id) throws SQLException {
		Note res = null;
		String sql = "select * from SMW_NOTE where RECEIVE_USER = ?  ";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				res = new Note();
				// 담을값 작성
			}

		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	public Note sendNoteBox(Connection conn, String user_id) throws SQLException {
		Note res = null;
		String sql = "select * from SMW_NOTE where SEND_USER = ?  ";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user_id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				res = new Note();
				// 담을값 작성
			}

		} finally {
			jdt.close(pstm);
		}
		return res;
	}

	public int deleteReceiveNote(Connection conn, String user_id) throws SQLException {

		PreparedStatement pstm = null;
		int res = 0;
		// 받은 쪽지 보낸쪽지 에서 삭제되는 쪽지가
		// 받은 쪽지함에선 로그인된 아이디가 RECEIVE_USER 와 같아야하고
		// 보낸 쪽지함에선 로그인된 아이디가 SEND_USER 와 같아야 한다.

		// jsp 구현이 아직 안된상태여서 sql문이 완성이 안된상태
		// 만약 checkbox 버튼으로 쪽지 선택하여 삭제시 그 쪽지의 NOTE_NO를 찾아서 삭제 해야할지 구상중
		// 여기도 마찬가지로 N Y로 변경하여 보여지지 않게 처리
		String sql = "update SMW_NOTE SET IS_SENDDELETE = 'y' where user_id = ?";

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

	public int deleteSendNote(Connection conn, String user_id) throws SQLException {

		PreparedStatement pstm = null;
		int res = 0;
		// 받은 쪽지 보낸쪽지 에서 삭제되는 쪽지가
		// 받은 쪽지함에선 로그인된 아이디가 RECEIVE_USER 와 같아야하고
		// 보낸 쪽지함에선 로그인된 아이디가 SEND_USER 와 같아야 한다.

		// jsp 구현이 아직 안된상태여서 sql문이 완성이 안된상태
		// 만약 checkbox 버튼으로 쪽지 선택하여 삭제시 그 쪽지의 NOTE_NO를 찾아서 삭제 해야할지 구상중
		// 여기도 마찬가지로 N Y로 변경하여 보여지지 않게 처리
		String sql = "update SMW_NOTE SET IS_RECEIVEDELETE = 'y' where user_id = ?";

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

}
