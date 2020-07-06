package com.market.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.market.member.model.dao.NoteDao;
import com.market.member.model.vo.Member;
import com.market.member.model.vo.Note;

import common.JDBCTemplate;

public class NoteService {

	public NoteDao ndao = new NoteDao();

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public int countNote(String user_id) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = ndao.countNote(conn, user_id);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public int countNoteNoRead(String user_id) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = ndao.countNoteNoRead(conn, user_id);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public int insertNote(Note note) {

		int res = 0;
		System.out.println(note);
		Connection conn = jdt.getConnection();

		try {
			res = ndao.insertNote(conn, note);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public int deleteReceiveNote(String user_id) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = ndao.deleteReceiveNote(conn, user_id);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public int deleteSendNote(String user_id) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = ndao.deleteSendNote(conn, user_id);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public Note receiveNoteBox(String user_id) {

		Note res = null;

		Connection conn = jdt.getConnection();

		try {

			res = ndao.receiveNoteBox(conn, user_id);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public Note sendNoteBox(String user_id) {

		Note res = null;

		Connection conn = jdt.getConnection();

		try {

			res = ndao.sendNoteBox(conn, user_id);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

}
