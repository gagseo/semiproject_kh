package com.market.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {

	private static final long serialVersionUID = -7545537404777928207L;

	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private Date noticeDate;
	private int noticeViewed;
	private String noticeContent;

	private int reviewNo;
	private String reviewTitle;
	private String reviewWriter;
	private Date reviewDate;
	private int reviewViewed;
	private String reviewContent;
	private String review_orifile;
	private String review_refile;

	private int rc_no;
	private String rc_writer;
	private String rc_content;
	private Date rc_date;

	private int usedNo;
	private String usedTitle;
	private String usedWriter;
	private String sellPrice;
	private Date usedDate;
	private int usedViewed;
	private String usedContent;
	private String used_orifile;
	private String used_refile;

	private int uc_no;
	private String uc_writer;
	private String uc_content;
	private Date uc_date;

	private String isPublished;
	private String isDelete;

	public Board() {
		super();
	}

	public Board(int noticeNo, String noticeTitle, String noticeWriter, Date noticeDate, int noticeViewed,
			String noticeContent, int reviewNo, String reviewTitle, String reviewWriter, Date reviewDate,
			int reviewViewed, String reviewContent, String review_orifile, String review_refile, int rc_no,
			String rc_writer, String rc_content, Date rc_date, int usedNo, String usedTitle, String usedWriter,
			String sellPrice, Date usedDate, int usedViewed, String usedContent, String used_orifile,
			String used_refile, int uc_no, String uc_writer, String uc_content, Date uc_date, String isPublished,
			String isDelete) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeViewed = noticeViewed;
		this.noticeContent = noticeContent;
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
		this.reviewViewed = reviewViewed;
		this.reviewContent = reviewContent;
		this.review_orifile = review_orifile;
		this.review_refile = review_refile;
		this.rc_no = rc_no;
		this.rc_writer = rc_writer;
		this.rc_content = rc_content;
		this.rc_date = rc_date;
		this.usedNo = usedNo;
		this.usedTitle = usedTitle;
		this.usedWriter = usedWriter;
		this.sellPrice = sellPrice;
		this.usedDate = usedDate;
		this.usedViewed = usedViewed;
		this.usedContent = usedContent;
		this.used_orifile = used_orifile;
		this.used_refile = used_refile;
		this.uc_no = uc_no;
		this.uc_writer = uc_writer;
		this.uc_content = uc_content;
		this.uc_date = uc_date;
		this.isPublished = isPublished;
		this.isDelete = isDelete;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeViewed() {
		return noticeViewed;
	}

	public void setNoticeViewed(int noticeViewed) {
		this.noticeViewed = noticeViewed;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewViewed() {
		return reviewViewed;
	}

	public void setReviewViewed(int reviewViewed) {
		this.reviewViewed = reviewViewed;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReview_orifile() {
		return review_orifile;
	}

	public void setReview_orifile(String review_orifile) {
		this.review_orifile = review_orifile;
	}

	public String getReview_refile() {
		return review_refile;
	}

	public void setReview_refile(String review_refile) {
		this.review_refile = review_refile;
	}

	public int getRc_no() {
		return rc_no;
	}

	public void setRc_no(int rc_no) {
		this.rc_no = rc_no;
	}

	public String getRc_writer() {
		return rc_writer;
	}

	public void setRc_writer(String rc_writer) {
		this.rc_writer = rc_writer;
	}

	public String getRc_content() {
		return rc_content;
	}

	public void setRc_content(String rc_content) {
		this.rc_content = rc_content;
	}

	public Date getRc_date() {
		return rc_date;
	}

	public void setRc_date(Date rc_date) {
		this.rc_date = rc_date;
	}

	public int getUsedNo() {
		return usedNo;
	}

	public void setUsedNo(int usedNo) {
		this.usedNo = usedNo;
	}

	public String getUsedTitle() {
		return usedTitle;
	}

	public void setUsedTitle(String usedTitle) {
		this.usedTitle = usedTitle;
	}

	public String getUsedWriter() {
		return usedWriter;
	}

	public void setUsedWriter(String usedWriter) {
		this.usedWriter = usedWriter;
	}

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}

	public int getUsedViewed() {
		return usedViewed;
	}

	public void setUsedViewed(int usedViewed) {
		this.usedViewed = usedViewed;
	}

	public String getUsedContent() {
		return usedContent;
	}

	public void setUsedContent(String usedContent) {
		this.usedContent = usedContent;
	}

	public String getUsed_orifile() {
		return used_orifile;
	}

	public void setUsed_orifile(String used_orifile) {
		this.used_orifile = used_orifile;
	}

	public String getUsed_refile() {
		return used_refile;
	}

	public void setUsed_refile(String used_refile) {
		this.used_refile = used_refile;
	}

	public int getUc_no() {
		return uc_no;
	}

	public void setUc_no(int uc_no) {
		this.uc_no = uc_no;
	}

	public String getUc_writer() {
		return uc_writer;
	}

	public void setUc_writer(String uc_writer) {
		this.uc_writer = uc_writer;
	}

	public String getUc_content() {
		return uc_content;
	}

	public void setUc_content(String uc_content) {
		this.uc_content = uc_content;
	}

	public Date getUc_date() {
		return uc_date;
	}

	public void setUc_date(Date uc_date) {
		this.uc_date = uc_date;
	}

	public String getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

}
