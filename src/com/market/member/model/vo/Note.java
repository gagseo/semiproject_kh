package com.market.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

// 쪽지 VO
public class Note implements Serializable {

	private Member member = new Member();
	/**
	 * 
	 */
	private static final long serialVersionUID = -3099623490851482494L;

	/*
	 * CREATE TABLE SMW_NOTE ( NOTE_NO NUMBER(6) PRIMARY KEY NOT NULL ,SEND_USER
	 * VARCHAR2(30) NOT NULL ,RECEIVE_USER VARCHAR2(30) NOT NULL ,RECEIVE_DATE DATE
	 * DEFAULT SYSDATE NOT NULL ,NOTE_TITLE NVARCHAR2(60) NOT NULL ,NOTE_CONTENT
	 * NVARCHAR2(2000) NOT NULL ,IS_READ VARCHAR2(1) DEFAULT 'N' NOT NULL ,IS_DELETE
	 * VARCHAR2(1) DEFAULT 'N' NOT NULL );
	 */

	//노트no
	private int note_no;
	//보낸 사람
	private String send_user;
	// 받는 사람
	private String receive_user;
	// 받은 날짜
	private Date receive_date;
	// 쪽지 제목
	private String note_title;
	// 쪽지 내용
	private String note_content;
	// 읽음 유무
	private String is_read;
	// 받은 사람이 받은 쪽지 지울때 
	private String is_senddelete;
	// 보낸 사람이 보낸 쪽지 지울때
	private String is_receivedelete;
	
	public Note() {
		super();
	}

	public Note(Member member, int note_no, String send_user, String receive_user, Date receive_date, String note_title,
			String note_content, String is_read, String is_senddelete, String is_receivedelete) {
		super();
		this.member = member;
		this.note_no = note_no;
		this.send_user = send_user;
		this.receive_user = receive_user;
		this.receive_date = receive_date;
		this.note_title = note_title;
		this.note_content = note_content;
		this.is_read = is_read;
		this.is_senddelete = is_senddelete;
		this.is_receivedelete = is_receivedelete;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getNote_no() {
		return note_no;
	}

	public void setNote_no(int note_no) {
		this.note_no = note_no;
	}

	public String getSend_user() {
		return send_user;
	}

	public void setSend_user(String send_user) {
		this.send_user = send_user;
	}

	public String getReceive_user() {
		return receive_user;
	}

	public void setReceive_user(String receive_user) {
		this.receive_user = receive_user;
	}

	public Date getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}

	public String getNote_title() {
		return note_title;
	}

	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public String getIs_read() {
		return is_read;
	}

	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}

	public String getIs_senddelete() {
		return is_senddelete;
	}

	public void setIs_senddelete(String is_senddelete) {
		this.is_senddelete = is_senddelete;
	}

	public String getIs_receivedelete() {
		return is_receivedelete;
	}

	public void setIs_receivedelete(String is_receivedelete) {
		this.is_receivedelete = is_receivedelete;
	}

	@Override
	public String toString() {
		return "Note [member=" + member + ", note_no=" + note_no + ", send_user=" + send_user + ", receive_user="
				+ receive_user + ", receive_date=" + receive_date + ", note_title=" + note_title + ", note_content="
				+ note_content + ", is_read=" + is_read + ", is_senddelete=" + is_senddelete + ", is_receivedelete="
				+ is_receivedelete + "]";
	}


	
}
