<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common/reset.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common/style.css" />
<!-- HTLM5shiv ie6~8 -->
<!-- 익스플로워 9버전 이하일 경우 나타나는 창  -->
<!--[if lt IE 9] 
        <script src="<%=request.getContextPath()%>/resources/js/html5shiv.min.js"></script>
        <script type="text/javascript">
            alert("현재 당신이 보는 브라우저는 지원하지 않습니다. 최신 브라우저로 업데이트해주세요!");
        </script>
[endif] -->
</head>
<body>
	<div id="wrap">
		<!-- header 시작 -->
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<!-- header 끝 -->

		<!-- nav 시작  -->
		<%@ include file="/WEB-INF/views/include/nav.jsp"%>
		<!-- nav 끝  -->

		<main>
		<!-- 회원가입 성공 페이지 -->

		<!--
ryan
 - Parameter 값으로 memberjoin에서 받아오는것 보다, 
 Model and View 에 object를 올려서 받아온 member 객체를 el-jstl로 사용하면 간단하게 키값만 가지고 사용할 수 있다.
  -->
		<%-- 	<!-- memberjoin.jsp에서 입력한 정보를 넘겨 받아 처리한다. -->
	<%
		request.setCharacterEncoding("utf-8");

		String user_name = request.getParameter("USER_NAME");
		String user_id = request.getParameter("USER_ID");
		String user_pwd = request.getParameter("USER_PWD");
		String nickname = request.getParameter("NICKNAME");
		String user_tell1 = request.getParameter("USER_TELL1");
		String user_tell2 = request.getParameter("USER_TELL2");
		String user_tell3 = request.getParameter("USER_TELL3");
		String birthday = request.getParameter("BIRTHDAY");
		String address = request.getParameter("ADDRESS");
		String address_etc = request.getParameter("ADDRESS_ETC");
		String user_mail = request.getParameter("USER_MAIL");
		String[] user_mail2 = request.getParameterValues("USER_MAIL2");
	%> --%>

		<div id="wrap">
			<br> <br> <b><font size="5" color="gray">회원가입
					정보를 확인하세요.</font></b> <br> <br> <font color="blue">${data.memberInfo.user_name}</font>
			님 가입을 축하드립니다. <br> <br>
			<table border="1">
				<tr>
					<td id="title">이름</td>
					<td>${data.memberInfo.user_name}</td>
				</tr>
				<tr>
					<td id="title">아이디</td>
					<td>${data.memberInfo.user_id }</td>
				</tr>

				<tr>
					<td id="title">비밀번호</td>
					<td>${data.memberInfo.user_pwd }</td>
				</tr>
				<tr>
					<td id="title">닉네임</td>
					<td>${data.memberInfo.nickname }</td>
				</tr>
				<tr>
					<td id="title">휴대전화</td>
					<td>${data.memberInfo.user_tell1 }-${data.memberInfo.user_tell2 }-${data.memberInfo.user_tell3 }</td>
				</tr>
				<tr>
					<td id="title">생일</td>
					<td>${data.memberInfo.birthday_yy }년 ${data.memberInfo.birthday_mm}년  ${data.memberInfo.birthday_dd }일</td>
				</tr>
				<tr>
					<td id="title">주소</td>
					<td>${data.memberInfo.address }<br>
						${data.memberInfo.address_etc }
					</td>
				</tr>

				<tr>
					<td id="title">이메일</td>
					<td>${data.memberInfo.user_mail}@${data.memberInfo.user_mail2 }</td>
				</tr>

			</table>
			<br> <input type="button" value="확인" onclick="loginPage()">
		</div>
		</main>
		
		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- footer 끝 -->
	</div>

	<!-- JavaScript -->
	<script type="text/javascript">
//확인 클릭시 로그인페이지로 이동
	function loginPage() { 
	location.href = '<%=request.getContextPath()%>/member/memberlogin.do'; 
	}
	</script>

</body>



</html>