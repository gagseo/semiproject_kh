package com.market.member.model.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.market.board.model.dao.BoardDao;
import com.market.board.model.vo.Board;
import com.market.member.model.dao.MemberDao;
import com.market.member.model.vo.Member;

import common.JDBCTemplate;
import common.util.Paging;

/**
 * @author HOYEONG
 *
 */
public class MemberService {

	public MemberDao mdao = new MemberDao();
	public BoardDao bdao = new BoardDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	/**
	 * <pre>
	 * com.market.member.model.service
	 * MemberService.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 24.
	 * @해야할일 :TODO
	 *
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {

		int res = 0;
		System.out.println(member);
		Connection conn = jdt.getConnection();

		try {
			res = mdao.insertMember(conn, member);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	/**
	 * <pre>
	 * com.market.member.model.service
	 * MemberService.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param user_id
	 * @param user_pw
	 * @return
	 */
	public Member login(String user_id, String user_pw) {

		Member res = null;

		Connection conn = jdt.getConnection();

		try {

			res = mdao.login(conn, user_id, user_pw);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	/**
	 * <pre>
	 * com.market.member.model.service
	 * MemberService.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 28.
	 * @해야할일 :TODO
	 *
	 * @param user_id
	 * @return
	 */
	public String idCheck(String user_id) {

		String res = null;
		Connection conn = jdt.getConnection();

		try {
			res = mdao.idCheck(conn, user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		System.out.println(res);
		return res;

	}

	/**
	 * <pre>
	 * com.market.member.model.service
	 * MemberService.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 2.
	 * @해야할일 :TODO
	 *
	 * @param nickName
	 * @return
	 */
	public String nickCheck(String nickName) {

		String res = null;
		Connection conn = jdt.getConnection();

		try {
			res = mdao.nickCheck(conn, nickName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		System.out.println(res);
		return res;

	}

	/**
	 * <pre>
	 * com.market.member.model.service
	 * MemberService.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 4. 30.
	 * @해야할일 :TODO
	 *
	 * @param m
	 */
	public void joinEmailCheck(Member member) {

		// 구글에 smtp서버를 사용하기 위한 인증정보
		// 이메일은 smwproject4@gmail.com 입니다.
		// 이메일 설정에서 pop/imap 설정 사용가능하게 변경해두었습니다.
		String email = "smwproject4@gmail.com";
		PasswordAuthentication pa = new PasswordAuthentication(email, "smwtest1!!");
		System.out.println(email);

		// 사용할 smtp서버 설정
		// smtp : send mail transfer protocol
		// 설정하지않으면 우리가 smtp서버여야 한다.
		Properties prop = System.getProperties();
		// tls(ssl)암호화 사용여부
		prop.put("mail.smtp.starttls.enable", "true");
		// 구글 smtp서버사용
		prop.put("mail.smtp.host", "smtp.gmail.com");
		// smtp서버에 접근할 때 사용자 인증
		prop.put("mail.smtp.auth", "true");
		// smtp서버의 포트번호
		prop.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return pa;
			}
		});

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("smwproject4@gmail.com", "Admin"));

			System.out.println(member.getUser_name());
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(member.getUser_mail() + "@" + member.getUser_mail2(), member.getUser_name()));
			msg.setSubject("우리 사이트 가입을 환영합니다.");

			// 히든벨류에 모든 회원 정보를 받도록 하겠습니다.
			// ID, PASSWORD, EMAIL12, TELL123, NAEM, NICKNAME, BIRTHDAY_YYMMDD, ADDRESS,ETC
			String htmlBody = "<form action='http://localhost:8787/smwMarket/member/join.do'"
					+ "method='post'><h3>회원가입완료를 원하시면 버튼을 클릭하세요</h3>" + "<input type='hidden' value='"
					+ member.getUser_id() + "' name ='USER_ID'>" + "<input type='hidden' value= '"
					+ member.getUser_pwd() + "' name ='USER_PWD'>" + "<input type='hidden' value= '"
					+ member.getUser_tell1() + "' name ='USER_TELL1'>" + "<input type='hidden' value= '"
					+ member.getUser_tell2() + "' name ='USER_TELL2'>" + "<input type='hidden' value= '"
					+ member.getUser_tell3() + "' name ='USER_TELL3'>" + "<input type='hidden' value= '"
					+ member.getUser_name() + "' name ='USER_NAME'>" + "<input type='hidden' value= '"
					+ member.getNickname() + "' name ='NICKNAME'>" + "<input type='hidden' value= '"
					+ member.getBirthday_yy() + "' name ='BIRTHDAY_YY'>" + "<input type='hidden' value= '"
					+ member.getBirthday_mm() + "' name ='BIRTHDAY_MM'>" + "<input type='hidden' value= '"
					+ member.getBirthday_dd() + "' name ='BIRTHDAY_DD'>" + "<input type='hidden' value= '"
					+ member.getZipcode() + "' name ='ZIPCODE'>" + "<input type='hidden' value= '" + member.getAddress()
					+ "' name ='ADDRESS'>" + "<input type='hidden' value= '" + member.getAddress_etc()
					+ "' name ='ADDRESS_ETC'>" + "<input type='hidden' value= '" + member.getUser_mail()
					+ "' name ='USER_MAIL'>" + "<input type='hidden' value= '" + member.getUser_mail2()
					+ "' name ='USER_MAIL2'>" + "<button type='submit'>회원가입하기</button></form>";
			/* byte[] attachmentData = null; */
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlBody, "text/html; charset=utf-8");
			mp.addBodyPart(htmlPart);

			/*
			 * MimeBodyPart attachment = new MimeBodyPart(); InputStream
			 * attachmentDataStream = new ByteArrayInputStream(attachmentData);
			 * attachment.setFileName("manual.pdf");
			 * attachment.setContent(attachmentDataStream, "application/pdf");
			 * mp.addBodyPart(attachment);
			 */
			msg.setContent(mp);
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * <pre>
	 * com.market.member.model.service
	 * MemberService.java
	 * </pre>
	 *
	 * @작성자 : HOYEONG
	 * @작업일 : 2020. 5. 4.
	 * @해야할일 :TODO 수정 - Ryan .
	 * @param member
	 * @return
	 */
	public int deleteInfo(String user_id) {

		int res = 0;
		Connection conn = jdt.getConnection();

		try {
			res = mdao.deleteInfo(conn, user_id);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

	public int modify(String id, Member member) {

		int res = -1;
		Connection conn = jdt.getConnection();

		try {
			res = mdao.modify(conn, id, member);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}


	public Map<String, Object> myNoticeList(String nickname, int currentPage, int cntPerPage) {
		// 마이페이지에 내가 등록한 게시글
		System.out.println("myNoticeList");
		Map<String, Object> res = new HashMap<>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> myNoticeList = null;

		try {
			p = new Paging(bdao.uContentCnt(conn), currentPage, cntPerPage);
			myNoticeList = mdao.myNoticeList(conn, p, nickname);
			res.put("paging", p);
			res.put("myNoticeList", myNoticeList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}
	
	public Map<String, Object> myRcList(String nickname, int currentPage, int cntPerPage) {
		// 마이페이지에 내가 댓글단 게시글
		System.out.println("myRcList");
		Map<String, Object> res = new HashMap<>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> myRcList = null;

		try {
			p = new Paging(bdao.uContentCnt(conn), currentPage, cntPerPage);
			myRcList = mdao.myRcList(conn, p, nickname);
			res.put("paging", p);
			res.put("myRcList", myRcList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public Map<String, Object> myUcList(String user_id, int currentPage, int cntPerPage) {
		// 마이페이지에 내가 댓글 보기
		System.out.println("myUcList");
		Map<String, Object> res = new HashMap<>();

		Connection conn = jdt.getConnection();
		Paging p = null;
		List<Board> myUcList = null;

		try {
			p = new Paging(bdao.uContentCnt(conn), currentPage, cntPerPage);
			myUcList = mdao.myUcList(conn, p, user_id);
			res.put("paging", p);
			res.put("myUcList", myUcList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}


}
