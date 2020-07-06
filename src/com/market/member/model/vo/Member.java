package com.market.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 7123549328188200271L;
	// 회원번호
	private int user_no;
	// 회원 이름
	private String user_name;
	// 회원아이디
	private String user_id;
	// 회원비밀번호
	private String user_pwd;
	// 닉네임
	private String nickname;
	// 전화번호
	// 010 , 02, ....
	private String user_tell1;
	// 전화번호 중간자리
	private String user_tell2;
	// 전화번호 끝자리
	private String user_tell3;
	// 생년월일 년
	private String birthday_yy;
	// 생년월일 월
	private String birthday_mm;
	// 생년월일 일
	private String birthday_dd;
	// 이메일1
	private String user_mail;
	// 이메일2 @뒤에
	private String user_mail2;
	// 우편번호
	private String zipcode;
	// 주소1
	private String address;
	// 주소2
	private String address_etc;
	// 가입일자
	private Date joindate;
	// 회원점수
	private int user_score;
	// 탈퇴 여부
	private String is_exit;
	// 탈퇴 날짜
	private Date exit_date;

	public Member() {
		super();
	}

	public Member(int user_no, String user_name, String user_id, String user_pwd, String nickname, String user_tell1,
			String user_tell2, String user_tell3, String birthday_yy, String birthday_mm, String birthday_dd,
			String user_mail, String user_mail2, String zipcode, String address, String address_etc, Date joindate,
			int user_score, String is_exit, Date exit_date) {
		super();
		this.user_no = user_no;
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.nickname = nickname;
		this.user_tell1 = user_tell1;
		this.user_tell2 = user_tell2;
		this.user_tell3 = user_tell3;
		this.birthday_yy = birthday_yy;
		this.birthday_mm = birthday_mm;
		this.birthday_dd = birthday_dd;
		this.user_mail = user_mail;
		this.user_mail2 = user_mail2;
		this.zipcode = zipcode;
		this.address = address;
		this.address_etc = address_etc;
		this.joindate = joindate;
		this.user_score = user_score;
		this.is_exit = is_exit;
		this.exit_date = exit_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUser_tell1() {
		return user_tell1;
	}

	public void setUser_tell1(String user_tell1) {
		this.user_tell1 = user_tell1;
	}

	public String getUser_tell2() {
		return user_tell2;
	}

	public void setUser_tell2(String user_tell2) {
		this.user_tell2 = user_tell2;
	}

	public String getUser_tell3() {
		return user_tell3;
	}

	public void setUser_tell3(String user_tell3) {
		this.user_tell3 = user_tell3;
	}

	public String getBirthday_yy() {
		return birthday_yy;
	}

	public void setBirthday_yy(String birthday_yy) {
		this.birthday_yy = birthday_yy;
	}

	public String getBirthday_mm() {
		return birthday_mm;
	}

	public void setBirthday_mm(String birthday_mm) {
		this.birthday_mm = birthday_mm;
	}

	public String getBirthday_dd() {
		return birthday_dd;
	}

	public void setBirthday_dd(String birthday_dd) {
		this.birthday_dd = birthday_dd;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_mail2() {
		return user_mail2;
	}

	public void setUser_mail2(String user_mail2) {
		this.user_mail2 = user_mail2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_etc() {
		return address_etc;
	}

	public void setAddress_etc(String address_etc) {
		this.address_etc = address_etc;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public int getUser_score() {
		return user_score;
	}

	public void setUser_score(int user_score) {
		this.user_score = user_score;
	}

	public String getIs_exit() {
		return is_exit;
	}

	public void setIs_exit(String is_exit) {
		this.is_exit = is_exit;
	}

	public Date getExit_date() {
		return exit_date;
	}

	public void setExit_date(Date exit_date) {
		this.exit_date = exit_date;
	}

	@Override
	public String toString() {
		return "Member [user_no=" + user_no + ", user_name=" + user_name + ", user_id=" + user_id + ", user_pwd="
				+ user_pwd + ", nickname=" + nickname + ", user_tell1=" + user_tell1 + ", user_tell2=" + user_tell2
				+ ", user_tell3=" + user_tell3 + ", birthday_yy=" + birthday_yy + ", birthday_mm=" + birthday_mm
				+ ", birthday_dd=" + birthday_dd + ", user_mail=" + user_mail + ", user_mail2=" + user_mail2
				+ ", zipcode=" + zipcode + ", address=" + address + ", address_etc=" + address_etc + ", joindate="
				+ joindate + ", user_score=" + user_score + ", is_exit=" + is_exit + ", exit_date=" + exit_date + "]";
	}

}