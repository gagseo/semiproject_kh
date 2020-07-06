<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myPage</title>
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

		<main> <!-- 회원정보 수정 페이지 -->
		<section id="memberRevise">
			<div class="container">
				<div class="row">
					<article class="mberSet">
						<div class="mbRevise">
							<h2>회원정보 수정</h2>
							<div class="mbRevisesub">
								<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
								<!-- 값(파라미터) 전송은 POST 방식 -->
								<form method="post"
									action="<%=request.getContextPath()%>/member/modify.do"
									name="userInfo" onsubmit="return checkValue()">

									<table>
										<tr>
											<th class="title">아이디</th>
											<td class="title">${loginInfo.user_id}</td>
										</tr>
										<tr>
											<th class="title">이름</th>
											<td class="title">${loginInfo.user_name}</td>
										</tr>
										<tr>
											<th class="title">닉네임</th>
											<td class="title">${loginInfo.nickname}</td>
										</tr>
										<tr>
											<th class="join-text">비밀번호</th>
											<td><input type="password" name="USER_PWD" id="USER_PWD"
												value="" class="inputText" class="pw" maxlength="30" /> <span
												id="pwdMake">영문자, 숫자, 기호문자의 조합으로 8글자 이상 작성해주세요.</span></td>
										</tr>
										<tr>
											<th class="join-text">비밀번호 확인</th>
											<td><input type="password" name="PWD_CHECK"
												id="PWD_CHECK" value="" class="inputText" maxlength="30" />
												<span id="same">비밀번호가 일치합니다.</span> <span id="different">비밀번호가
													일치하지 않습니다.</span></td>
										</tr>
										<tr>
											<th class="join-text">휴대전화</th>
											<td><select name="USER_TELL1" id="USER_TELL1"
												class="inputText">
													<option value="${sessionScope.loginInfo.user_tell1 }"
														selected>${sessionScope.loginInfo.user_tell1 }</option>
													<option value="010">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="017">017</option>
													<option value="019">019</option>
											</select> -&nbsp; <input type="text" name="USER_TELL2" id="USER_TELL2"
												size="5" value="${sessionScope.loginInfo.user_tell2 }"
												maxlength="4" class="inputText" /> -&nbsp; <input
												type="text" value="${sessionScope.loginInfo.user_tell3 }"
												name="USER_TELL3" id="USER_TELL3" size="5" maxlength="4"
												class="inputText" /></td>
										</tr>
										<tr>
											<th class="join-text">주소</th>
											<td>
												<!-- 신주소 우편번호 --> <input id="ZIPCODE" name="ZIPCODE"
												class="inputText" type="text" placeholder="우편번호"
												value="${sessionScope.loginInfo.zipcode }"
												style="width: 100px;" readonly /> &nbsp; <!-- 우편주소찾기 버튼 -->
												<input id="addrFind" type="button"
												onclick="openDaumZipAddress()" value="주소 찾기" /><br /> <!-- 기본주소 -->
												<input type="text" id="ADDRESS" name="ADDRESS"
												value="${sessionScope.loginInfo.address }"
												placeholder="기본주소" class="inputText" style="width: 240px;"
												readonly /><br /> <!-- 나머지 주소 --> <input type="text"
												id="ADDRESS_ETC" name="ADDRESS_ETC" placeholder="나머지 주소"
												class="inputText"
												value="${sessionScope.loginInfo.address_etc }"
												style="width: 240px;" />
											</td>
										</tr>
									</table>
									<div id="subbutton">
										<input type="button" value="취소" id="myCancel"
											onclick="cancel()"> <input type="submit" value="수정"
											id="myModify" /> <input type="button" value="탈퇴"
											id="myLeave" />
									</div>
								</form>
								<div id="leave" style="display: none;">
									<strong>탈퇴를 진행하시려면 비밀번호를 다시한번 확인해주세요.</strong><br> <input
										type="password" id="exit_user_pwd" name="exit_user_pwd"><br>
									<strong>한번 탈퇴하면 30일 이후 재가입이 가능하며, 기존의 아이디는 사용할 수 없습니다.</strong><br>
									<button id="exitConfirm" type="submit">확인</button>
									<button id="exitCancel" onclick="exitCancel()">취소</button>
								</div>
							</div>

							<!-- 등록된 게시물과 댓글 -->
							<div id="mbBoard">
								<form method="post" id="mynoticelist"
									action="<%=request.getContextPath()%>/member/mypage.do">
									<div id="boardSub1">
										<ul id="mbTab">
											<li><a
												href="<%=request.getContextPath()%>/member/mynoticelist.do"
												title="tab1"><input type="hidden" name="mynoticelist"
													value="mynoticelist">게시글</a></li>
											<li><a
												href="<%=request.getContextPath()%>/member/myrclist.do"
												title="tab2"><input type="hidden" name="myrclist"
													value="myrclist">댓글 단 게시글</a></li>
											<li><a
												href="<%=request.getContextPath()%>/member/myuclist.do"
												title="tab3"><input type="hidden" name="myuclist"
													value="myuclist">등록한 댓글</a></li>
										</ul>

									</div>
								</form>
								<div id="boardSub2">
									<div id="tab1">
										<table>
											<tr>
												<th>제목</th>
												<th>작성자</th>
												<th>작성일</th>
												<th>조회수</th>
											</tr>

											<!-- 받아줄 값 -->
											<!-- 	<tr>
									<td>제목입니다.</td>
									<td>작성자</td>
									<td>20.05.08</td>
									<td>1</td>
								</tr> -->
											<tr class="reply">
												<c:forEach items="${data.bData }" var="board">
													<c:if test="${board.reviewTitle ne null }">
														<td class="title"><a
															href="/smwMarket/board/reviewdetail.do?reviewNo=${board.reviewNo }">
																${board.reviewTitle }</a></td>
														<td class="nickName">${board.reviewWriter }</td>
														<td class="date">${board.reviewDate }</td>
														<td class="viewNo">${board.reviewViewed }</td>
													</c:if>
												</c:forEach>
												<c:forEach items="${data.bData }" var="board">
													<c:if test="${board.usedTitle ne null }">
														<td class="title"><a
															href="/smwMarket/board/usedmarket.do?usedNo=${board.usedNo }">
																${board.usedTitle }</a></td>
														<td class="nickName">${board.usedWriter }</td>
														<td class="date">${board.usedDate }</td>
														<td class="viewNo">${board.usedViewed }</td>
													</c:if>
												</c:forEach>
											</tr>
										</table>
									</div>
									<div id="tab2">
										<table>
											<tr>
												<th>제목</th>
												<th>작성자</th>
												<th>작성일</th>
												<th>조회수</th>
											</tr>
											<!-- 받아줄 값 -->
											<tr class="reply">
												<c:forEach items="${data.bData }" var="board">
													<c:if test="${board.reviewTitle ne null }">
														<td class="title"><a
															href="/smwMarket/board/reviewdetail.do?reviewNo=${board.reviewNo }">
																${board.reviewTitle }</a></td>
														<td class="nickName">${board.reviewWriter }</td>
														<td class="date">${board.reviewDate }</td>
														<td class="viewNo">${board.reviewViewed }</td>
													</c:if>
												</c:forEach>
												<c:forEach items="${data.bData }" var="board">
													<c:if test="${board.usedTitle ne null }">
														<td class="title"><a
															href="/smwMarket/board/usedmarket.do?usedNo=${board.usedNo }">
																${board.usedTitle }</a></td>
														<td class="nickName">${board.usedWriter }</td>
														<td class="date">${board.usedDate }</td>
														<td class="viewNo">${board.usedViewed }</td>
													</c:if>
												</c:forEach>
											</tr>
										</table>
									</div>
									<div id="tab3">
										<table>
											<tr>
												<th>댓글</th>
												<th>작성일</th>
												<th>조회수</th>
											</tr>

											<!-- 받아줄 값 -->
											<tr>
												<!-- 	<td>댓글값</td>
									<td>20.05.08</td>
									<td>1</td> -->
												<c:forEach items="${data.bData }" var="board">
													<c:if test="${board.rc_content ne null }">
														<td class="content">${board.rc_content }</td>
														<td class="date">${board.rc_date }</td>
														<td class="viewNo">${board.reviewViewed }</td>
													</c:if>
												</c:forEach>
												<c:forEach items="${data.bData }" var="board">
													<c:if test="${board.uc_content ne null }">
														<td class="content">${board.uc_content }</td>
														<td class="date">${board.uc_date }</td>
														<td class="viewNo">${board.usedViewed }</td>
													</c:if>
												</c:forEach>
											</tr>
										</table>
									</div>
								</div>
							</div>
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
	<!-- 게시글/댓글 부분 -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.4.1.js"></script>
	<script type="text/JavaScript">
	
	$(document).ready(function(){
		$("#boardSub2 div").hide();
		$("#mbTab li:first").attr("id","current");
		$("#boardSub2 div:first").fadeIn();
		
		/* intTab의 메뉴를 클릭했을 때 선택된 목록의 div를 제외하고 안보이게 처리  */
		$('#mbTab a').click(function(e){
			e.preventDefault();
			$("#boardSub2 div").hide();
			$("#mbTab li").attr("id","");
			$(this).parent().attr("id","current");
			$('#'+$(this).attr('title')).fadeIn();
		});
	});
	
	</script>
	<!----------------------------------------------------------------->

	<!-- 회원정보 수정 부분 스크립트 -->
	<script type="text/JavaScript"
		src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

	<script src="https://code.jquery.com/jquery-3.5.0.js"
		integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
		crossorigin="anonymous"></script>

	<script type="text/javascript">

	//비밀번호 입력확인
		function checkValue() {
		var pw = document.getElementById('USER_PWD');
		var regExpPw = /(?=.*\d{1,50})(?=.*[~!@#$%\^&*()_+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}/;

		var originalPw = "${sessionScope.loginInfo.user_pwd}";
		
		if(pw.value == ""){
			pw.value = originalPw;
			return true;
		}		
		function chk(re, e, msg) {
			if (re.test(e.value)) {
				return true;
			} else {
				alert(msg);
				e.value = "";
				//e.focus();
				return false;
			}
		}
         var pw = document.getElementById('USER_PWD');
			var regExpPw = /(?=.*\d{1,50})(?=.*[~!@#$%\^&*()_+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}/;

			function chk(re, e, msg) {
				if (re.test(e.value)) {
					return true;
				} else {
					alert(msg);
					e.value = "";
					//e.focus();
					return false;
				}
			}
		/* 	//공백 금지
			var blank_pattern = /[\s]/g;
			if (blank_pattern.test(str.value) == true) {
				alert(' 공백은 사용할 수 없습니다. ');
				return false;
			} */

			//비밀번호 검사
			//암호는 영문자 숫자 기호문자의 조합으로 8글자 이상 작성해주세요.
			if (!chk(regExpPw, pw, '암호는 영문자 숫자 기호문자의 조합으로 8글자 이상 작성해주세요.')) {
				return false;
			}
			
			  var pwcheck = document.form.USER_PWD.value;
	            if("${sessionScope.loginInfo.user_pwd}" != pwcheck){
	            	alert("비밀번호를 확인해주세요.");
	                return false;
	            }

			return true;
    	 };
     
  	 	//비밀번호 일치 체크
		$('#PWD_CHECK').bind("keyup", function() {
			var pwd1 = $("#USER_PWD").val();
			var pwd2 = $("#PWD_CHECK").val();

			if (pwd1 != '' && pwd2 == '') {
				null;
			} else if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#same").css('display', 'block');
					$("#different").css('display', 'none');
					$("#PWD_CHECK").css("background-color", "white");
				} else {
					$("#same").css('display', 'none');
					$("#different").css('display', 'block');
					$("#PWD_CHECK").css("background-color", "red");
				}
			}
		});
   
   	
     
	 	//취소 누르면 index페이지로
		 function cancel() {
		 location.href = '<%=request.getContextPath()%>/index/index.do';
		}

		 // 탈퇴 확인 버튼 클릭시
		 function exitConfirm() {
		 //비밀번호 확인
		 var pwcheck = document.form.exit_user_pwd.value;
         if("${sessionScope.loginInfo.user_pwd}" != pwcheck){
         	alert("비밀번호를 확인해주세요.");
             return false;
         }
     	return true;
		}
		 //탈퇴 취소 버튼 클릭시
		function exitCancel() {
		location.href = '<%=request.getContextPath()%>/index/index.do';
		}
	 

		$("#exitConfirm").bind("click",function() {
			if ($("#exit_user_pwd").val() != "${sessionScope.loginInfo.user_pwd}") {
				alert("비밀번호가 틀렸습니다.");
			} else {
				location.href = "<%=request.getContextPath()%>
		/member/deleteinfo.do";
							}
						});

		$("#exitCancel").bind("click", function() {
			$("#exit_user_pwd").val();
			$("#leave").css("display", "none");
			$("#myLeave").css("display", "inline-block");
			$("#myModify").css("display", "inline-block");
			$("#myCancel").css("display", "inline-block");
		});

		$("#myLeave").bind("click", function() {
			$("#leave").css("display", "block");
			$("#myLeave").css("display", "none");
			$("#myModify").css("display", "none");
			$("#myCancel").css("display", "none");
		});

		// 핸드폰 입력란에 숫자만 

		$("#USER_TELL2").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});

		$("#USER_TELL3").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});

		// 다음 주소 불러오기
		function openDaumZipAddress() {

			new daum.Postcode({

				oncomplete : function(data) {

					$("#ZIPCODE").val(data.zonecode);
					$("#ADDRESS").val(data.address);
					$("#ADDRESS_ETC").focus();

					console.log(data);
				}
			}).open();
		}
	</script>
	<!----------------------------------------------------------------->
</body>
</html>