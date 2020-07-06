--시장 정보 추가하는 쿼리문
CREATE TABLE LOCAL_CURRENCY (
NAME_CITY VARCHAR2(30) 
,NAME_BRAND VARCHAR2(100) 
,NAME_BUSINESS VARCHAR2(100) 
,ADDRESS_ROAD VARCHAR2(1000) 
,ADDRESS_NUMBER VARCHAR2(1000) 
,TELL VARCHAR2(30) 
,ZIPCODE VARCHAR2(30) 
,LATITUDE VARCHAR2(30) 
,LONGITUDE VARCHAR2(30)
,DATA_UPDATE DATE
);





--수정할 때 여기부터 실행
--DB 갱신할 때 이걸로 테이블 지워주시고 다시 해주세요.
DROP TABLE SMW_USER CASCADE CONSTRAINTS;
DROP SEQUENCE USER_NO;
DROP TABLE SMW_NOTE CASCADE CONSTRAINTS;
DROP SEQUENCE NOTE_NO;
DROP TABLE BD_REVIEW CASCADE CONSTRAINTS;
DROP SEQUENCE REVIEW_NO;
DROP TABLE REVIEW_COMMENT;
DROP SEQUENCE RVCOM_NO;
DROP TABLE BD_USED;
DROP SEQUENCE USED_NO;
DROP TABLE BD_NOTICE;
DROP SEQUENCE NOTICE_NO;
DROP TABLE USED_COMMENT;




--DB 처음 만들 경우 여기부터 실행

--유저 테이블 생성
CREATE TABLE SMW_USER (
USER_NO NUMBER(30) UNIQUE NOT NULL
,USER_NAME VARCHAR2(30) NOT NULL
,USER_ID VARCHAR2(20) UNIQUE NOT NULL
,USER_PWD VARCHAR2(40) NOT NULL
,NICKNAME VARCHAR2(30) UNIQUE NOT NULL
,USER_TELL1 VARCHAR2(20) NOT NULL
,USER_TELL2 VARCHAR2(20) NOT NULL
,USER_TELL3 VARCHAR2(20) NOT NULL
,BIRTHDAY_YY VARCHAR2(20) NOT NULL
,BIRTHDAY_MM VARCHAR2(20) NOT NULL
,BIRTHDAY_DD VARCHAR2(20) NOT NULL
,ZIPCODE VARCHAR2(20) NOT NULL
,ADDRESS VARCHAR2(50) NOT NULL
,ADDRESS_ETC VARCHAR2(50) NOT NULL
,JOINDATE DATE DEFAULT SYSDATE NOT NULL
--유저 점수. 회원가입 시 30점으로 시작, 30점 미만 부터 불량유저
--0점 도달시 BAN! 30점 이상 시 우수회원
,USER_SCORE NUMBER(3) DEFAULT 30 NOT NULL
,USER_EMAIL VARCHAR2(100)
,USER_EMAIL2 VARCHAR2(100)
,IS_EXIT CHAR(1) DEFAULT 'N'
,EXIT_DATE DATE DEFAULT NULL
,CONSTRAINT USER_PK PRIMARY KEY (USER_NO,NICKNAME) );

--유저 넘버 시퀀스 생성
CREATE SEQUENCE USER_NO
START WITH 10001
INCREMENT BY 1
MAXVALUE 9999999999
MINVALUE 10000
NOCYCLE;



select * from smw_user;

SELECT BD_REVIEW.REVIEW_TITLE,BD_REVIEW.REVIEW_WRITER,BD_REVIEW.REVIEW_TIME,BD_REVIEW.REVIEW_VIEWED,
				BD_USED.USED_TITLE,BD_USED.USED_WRITER,BD_USED.USED_TIME,BD_USED.USED_VIEWED
				 FROM SMW_USER,BD_REVIEW,REVIEW_COMMENT,BD_USED,USED_COMMENT WHERE NICKNAME = 'sss'
				AND NICKNAME = RVCOM_WRITER(+)
				AND NICKNAME = UDCOM_WRITER(+);

SELECT REVIEW_COMMENT.RVCOM_CONTENT, REVIEW_COMMENT.RVCOM_DATE,
USED_COMMENT.UDCOM_CONTENT, USED_COMMENT.UDCOM_DATE
FROM SMW_USER,REVIEW_COMMENT,USED_COMMENT
WHERE NICKNAME = 'sss'
AND NICKNAME = REVIEW_COMMENT.RVCOM_WRITER(+)
AND NICKNAME = USED_COMMENT.UDCOM_WRITER(+);





SELECT --등록한 게시글용
BD_REVIEW.REVIEW_TITLE,BD_REVIEW.REVIEW_WRITER,BD_REVIEW.REVIEW_TIME,BD_REVIEW.REVIEW_VIEWED
,BD_USED.USED_TITLE,BD_USED.USED_WRITER,BD_USED.USED_TIME,BD_USED.USED_VIEWED
FROM
SMW_USER,BD_REVIEW,BD_USED
WHERE NICKNAME = 'sss'
AND NICKNAME = REVIEW_WRITER(+)
AND NICKNAME = USED_WRITER(+);



SELECT --댓글 단 게시글용 쿼리문 얘가 안되네
BD_REVIEW.REVIEW_TITLE,BD_REVIEW.REVIEW_WRITER,BD_REVIEW.REVIEW_TIME,BD_REVIEW.REVIEW_VIEWED
,BD_USED.USED_TITLE,BD_USED.USED_WRITER,BD_USED.USED_TIME,BD_USED.USED_VIEWED
FROM
SMW_USER,BD_REVIEW,REVIEW_COMMENT,BD_USED,USED_COMMENT
WHERE SMW_USER.NICKNAME = 'sss'
AND NICKNAME = RVCOM_WRITER(+)
AND NICKNAME = UDCOM_WRITER(+);

SELECT 
BD_REVIEW.REVIEW_TITLE,BD_REVIEW.REVIEW_WRITER,BD_REVIEW.REVIEW_TIME,BD_REVIEW.REVIEW_VIEWED
FROM
SMW_USER,BD_REVIEW,REVIEW_COMMENT
WHERE SMW_USER.NICKNAME = 'sss'
AND SMW_USER.NICKNAME = RVCOM_WRITER(+);

SELECT 
BD_USED.USED_TITLE,BD_USED.USED_WRITER,BD_USED.USED_TIME,BD_USED.USED_VIEWED
FROM
SMW_USER,BD_USED,USED_COMMENT
WHERE SMW_USER.NICKNAME = 'sss'
AND SMW_USER.NICKNAME = UDCOM_WRITER(+);



SELECT * FROM review_comment;


select * from review_comment;

SELECT --등록한 댓글용 쿼리문
REVIEW_COMMENT.RVCOM_CONTENT, REVIEW_COMMENT.RVCOM_DATE
,USED_COMMENT.UDCOM_CONTENT, USED_COMMENT.UDCOM_DATE
FROM
SMW_USER,REVIEW_COMMENT,USED_COMMENT
WHERE SMW_USER.NICKNAME = REVIEW_COMMENT.RVCOM_WRITER(+)
AND SMW_USER.USER_ID = USED_COMMENT.UDCOM_WRITER(+);





--쪽지 테이블 생성
CREATE TABLE SMW_NOTE (
NOTE_NO NUMBER(6) PRIMARY KEY NOT NULL
,SEND_USER VARCHAR2(30) NOT NULL
,RECEIVE_USER VARCHAR2(30) NOT NULL
,RECEIVE_DATE DATE DEFAULT SYSDATE NOT NULL
,NOTE_TITLE NVARCHAR2(60) NOT NULL
,NOTE_CONTENT NVARCHAR2(2000) NOT NULL
,IS_READ VARCHAR2(1) DEFAULT 'N' NOT NULL --쪽지를 확인하면 Y로 변경
,IS_SENDDELETE VARCHAR2(1) DEFAULT 'N' NOT NULL --받은 사람이 받은쪽지를 지울 때 Y로 변경
,IS_RECEIVEDELETE VARCHAR2(1) DEFAULT 'N' NOT NULL  --보낸 사람이 보낸쪽지를 지울 때 Y로 변경
);





--쪽지 넘버링 시퀀스 생성
CREATE SEQUENCE NOTE_NO
START WITH 10001
INCREMENT BY 1
MAXVALUE 999999
MINVALUE 10000
NOCYCLE;



--쪽지 조회 여부 프로시저 
CREATE OR REPLACE PROCEDURE EX_NOTE(V_NO IN SMW_NOTE.NOTE_NO%TYPE)
IS
BEGIN 
	UPDATE SMW_NOTE SET IS_READ = 'Y' WHERE NOTE_NO = V_NO;
	COMMIT;
END;
/

EXEC EX_NOTE(10002);








--리뷰 게시판 테이블 생성
CREATE TABLE BD_REVIEW (
REVIEW_NO NUMBER(9) PRIMARY KEY NOT NULL
,REVIEW_TITLE NVARCHAR2(60) NOT NULL
,REVIEW_WRITER VARCHAR2(15) NOT NULL
,REVIEW_TIME DATE DEFAULT SYSDATE NOT NULL
,REVIEW_VIEWED NUMBER(7) DEFAULT 0 NOT NULL
,REVIEW_ORIFILE VARCHAR2(500)
,REVIEW_REFILE VARCHAR2(500)
,REVIEW_CONTENT VARCHAR2(4000) NOT NULL
,IS_PUBLISHED CHAR(1) DEFAULT 1 -- 0 == NULL, FALSE & 1 == TRUE
,IS_DELETE CHAR(1) DEFAULT 'N' NOT NULL
);



--리뷰 게시판 넘버 시퀀스 생성
CREATE SEQUENCE REVIEW_NO
START WITH 10000000
INCREMENT BY 1
MAXVALUE 999999999
MINVALUE 10000000
NOCYCLE;

--리뷰 게시판 댓글 테이블 생성
CREATE TABLE REVIEW_COMMENT (
RVCOM_NO NUMBER(10) PRIMARY KEY NOT NULL
,REVIEW_NO NUMBER(9) NOT NULL
,RVCOM_WRITER VARCHAR2(15) NOT NULL
,RVCOM_CONTENT VARCHAR2(500) NOT NULL
,RVCOM_DATE DATE DEFAULT SYSDATE NOT NULL
,IS_DELETE CHAR(1) DEFAULT 'N' NOT NULL
);


--리뷰 게시판 댓글 넘버 시퀀스 생성
CREATE SEQUENCE RVCOM_NO
START WITH 10000000
INCREMENT BY 1
MAXVALUE 999999999
MINVALUE 10000000
NOCYCLE;

select * from bd_review;

update bd_review set is_delete = 'N' where review_no = 10000001;
update bd_review set is_delete = 'Y' where review_no = 10000021;


--리뷰 게시판 조회수 증가 프로시저
CREATE OR REPLACE PROCEDURE EX_REVIEW
(V_NO IN BD_REVIEW.REVIEW_NO%TYPE)
IS
BEGIN
UPDATE BD_REVIEW SET REVIEW_VIEWED = REVIEW_VIEWED + 1 WHERE REVIEW_NO = V_NO;
COMMIT;
END;
/











--중고 게시판 테이블 생성
CREATE TABLE BD_USED (
USED_NO NUMBER(9) PRIMARY KEY NOT NULL
,USED_TITLE NVARCHAR2(60) NOT NULL
,USED_WRITER VARCHAR2(15) NOT NULL
,SELL_PRICE VARCHAR2(100) NOT NULL
,USED_TIME DATE DEFAULT SYSDATE NOT NULL
,USED_VIEWED NUMBER(7) DEFAULT 0 NOT NULL
,USED_ORIFILE VARCHAR2(500)
,USED_REFILE VARCHAR2(500)
,USED_CONTENT VARCHAR2(4000) NOT NULL
,IS_PUBLISHED CHAR(1) DEFAULT 1 -- 0 == NULL, FALSE & 1 == TRUE
,IS_DELETE CHAR(1) DEFAULT 'N' NOT NULL
);



--중고 게시판 넘버 시퀀스 생성
CREATE SEQUENCE USED_NO
START WITH 10000001
INCREMENT BY 1
MAXVALUE 999999999
MINVALUE 10000000
NOCYCLE;

--중고 게시판 댓글 테이블 생성
CREATE TABLE USED_COMMENT (
UDCOM_NO NUMBER(10) PRIMARY KEY NOT NULL
,USED_NO NUMBER(9) NOT NULL
,UDCOM_WRITER VARCHAR2(15) NOT NULL
,UDCOM_CONTENT VARCHAR2(500) NOT NULL
,UDCOM_DATE DATE DEFAULT SYSDATE NOT NULL
,IS_DELETE CHAR(1) DEFAULT 'N' NOT NULL
);

select * from used_comment where used_no = 10000004;

--중고 게시판 댓글 넘버 시퀀스 생성
CREATE SEQUENCE UDCOM_NO
START WITH 10000001
INCREMENT BY 1
MAXVALUE 999999999
MINVALUE 10000000
NOCYCLE;

--중고 게시판 조회수 증가 프로시저
CREATE OR REPLACE PROCEDURE EX_USED
(V_NO IN BD_USED.USED_NO%TYPE)
IS
BEGIN
UPDATE BD_USED SET USED_VIEWED = USED_VIEWED + 1 WHERE USED_NO = V_NO;
COMMIT;
END;
/







--공지 게시판 테이블 생성
CREATE TABLE BD_NOTICE (
NOTICE_NO NUMBER(9) PRIMARY KEY NOT NULL
,NOTICE_TITLE NVARCHAR2(60) NOT NULL
,NOTICE_WRITER VARCHAR2(15) NOT NULL
,NOTICE_TIME DATE DEFAULT SYSDATE NOT NULL
,NOTICE_VIEWED NUMBER(7) DEFAULT 0 NOT NULL
,NOTICE_ORIFILE VARCHAR2(500)
,NOTICE_REFILE VARCHAR2(500)
,NOTICE_CONTENT VARCHAR2(4000) NOT NULL);





--공지 게시판 넘버링 시퀀스 생성
CREATE SEQUENCE NOTICE_NO
START WITH 10000001
INCREMENT BY 1
MAXVALUE 999999999
MINVALUE 10000001
NOCYCLE;


--게시판 조회수 시퀀스 생성
CREATE SEQUENCE NOTICE_VIEWED
START WITH 0
INCREMENT BY 1
MAXVALUE 9999999
MINVALUE 0
NOCYCLE;


--공지 게시판 조회수 증가 프로시저
CREATE OR REPLACE PROCEDURE EX_NOTICE
(V_NO IN BD_NOTICE.NOTICE_NO%TYPE)    --게시판번호를 매개변수로 받음
IS
BEGIN
	UPDATE BD_NOTICE 
	SET NOTICE_VIEWED = NOTICE_VIEWED + 1 --조회수 1식 증가
	WHERE NOTICE_NO = V_NO;  --매개변수로 받은 게시판번호와 바꿀 게시판 번호가 같다면 쿼리 실행
	
	COMMIT;
END;
/

COMMIT;
