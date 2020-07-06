<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myPage password</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
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

		<main> <!-- 마이페이지 입장전 비밀번호 받는 페이지 -->
		<section id="mypageSet">
			<div class="container">
				<div class="row">
					<article class="mypageSub">
						<div class="myImport">
							<h2>회원 비밀번호 확인</h2>
							<form name="form" method="post"
								action="<%=request.getContextPath()%>/member/mypage.do"
								onsubmit="return checkValue()">
								<div class="myPg">
									<ul>
										<li id="myPgsub"><p>비밀번호</p></li>
										<li><input type="password" name="USER_PWD" id="USER_PWD"
											maxlength="50"></li>
										<li><input id="pass" type="submit" value="확인"></li>
										<li><input id="false" type="button" value="취소"
											onclick="cancel()"></li>
									</ul>
								</div>
							</form>
						</div>
					</article>
				</div>
			</div>
		</section>
		</main>

		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- footer 끝 -->
	</div>

	<!-- JavaScript -->
	<script type="text/javascript">
        // 비밀번호 미입력시 경고창
        function checkValue(){
            if(!document.form.USER_PWD.value){
                alert("비밀번호를 입력하지 않았습니다.");
                return false;
            }
            
            //세션에 저장된 비밀번호와 입력된 비밀번호 비교
            var pw = document.form.USER_PWD.value;
            if("${sessionScope.loginInfo.user_pwd}" != pw){
            	alert("비밀번호를 확인해주세요.");
                return false;
            }
        }
             
        //취소버튼 클릭시 인덱스로
        function cancel(){
        	location.href = "<%=request.getContextPath()%>
		/index/index.do";
		}
	</script>

</body>
</html>