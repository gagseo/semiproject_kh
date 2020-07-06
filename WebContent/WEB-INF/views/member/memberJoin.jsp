<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
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

		<main> <!-- 메인 -->
		<section id="join">
			<div class="container">
				<div class="row">
					<article class="jo_User">
						<h1>회원가입</h1>
						<%-- 본인인증 무료로 할 수 있는거 어떤게 있는 지 찾아서 사용할 것 정하기 --%>
						<!-- .do 확인하기 -->
						<div class="joinUs">
							<form
								action="<%=request.getContextPath()%>/member/joinemailcheck.do"
								method="post" name="joinForm" onsubmit="return validate();">
								<table>
									<tr>
										<td class="join-text">아이디</td>
										<td><input type="text" name="USER_ID" id="USER_ID"
											class="inputText" maxlength="20" onkeyup="noSpaceForm(this);"
											onchange="noSpaceForm(this);" />
											<button class="overlap" type="button" onclick="idCheck()">아이디
												중복체크</button> <span id="idCheckMsg"></span></td>
									</tr>
									<tr>
										<td class="join-text">비밀번호</td>
										<td><input type="password" name="USER_PWD"
											id="JOIN_USER_PWD" class="inputText" class="pw"
											maxlength="30" /> <span id="pwd-text">영문자 숫자 기호문자의
												조합으로 8글자 이상 작성해주세요.</span></td>
									</tr>
									<tr>
										<td class="join-text">비밀번호 확인</td>
										<td><input type="password" name="PWD_CHECK"
											id="JOIN_PWD_CHECK" class="inputText" maxlength="30" /> <span
											id="same" style="display: none;">비밀번호가 일치합니다.</span> <span
											id="different"
											style="display: none; color: #d92742; font-weight: bold;">비밀번호가
												일치하지 않습니다.</span></td>
									</tr>
									<tr>
										<td class="join-text">이름</td>
										<td><input type="text" name="USER_NAME" maxlength="30"
											class="inputText" /></td>
									</tr>
									<tr>
										<td class="join-text">닉네임</td>
										<td><input type="text" name="NICKNAME" id="NICKNAME"
											onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
											class="inputText" maxlength="15" />
											<button class="overlap" type="button" onclick="nickCheck()">닉네임
												중복체크</button> <br> <span id="nickCheckMsg"></span></td>
									</tr>
									<tr>
										<td class="join-text">생일</td>
										<td><select name="BIRTHDAY_YY" class="inputText">
												<option value="" selected disabled hidden>==</option>
												<option value="2001">2001</option>
												<option value="2000">2000</option>
												<option value="1999">1999</option>
												<option value="1998">1998</option>
												<option value="1997">1997</option>
												<option value="1996">1996</option>
												<option value="1995">1995</option>
												<option value="1994">1994</option>
												<option value="1993">1993</option>
												<option value="1992">1992</option>
												<option value="1991">1991</option>
												<option value="1990">1990</option>
												<option value="1989">1989</option>
												<option value="1988">1988</option>
												<option value="1987">1987</option>
												<option value="1986">1986</option>
												<option value="1985">1985</option>
												<option value="1984">1984</option>
												<option value="1983">1983</option>
												<option value="1982">1982</option>
												<option value="1981">1981</option>
												<option value="1980">1980</option>
												<option value="1979">1979</option>
												<option value="1978">1978</option>
												<option value="1977">1977</option>
												<option value="1976">1976</option>
												<option value="1975">1975</option>
												<option value="1974">1974</option>
												<option value="1973">1973</option>
												<option value="1972">1972</option>
												<option value="1971">1971</option>
												<option value="1970">1970</option>
										</select>&nbsp;년&nbsp; <select name="BIRTHDAY_MM" class="inputText">
												<option value="" selected disabled hidden>==</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
										</select> &nbsp;월&nbsp; <select name="BIRTHDAY_DD" class="inputText">
												<option value="" selected disabled hidden>==</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
												<option value="31">31</option>
										</select> &nbsp;일&nbsp;</td>
									</tr>
									<tr>
										<td class="join-text">휴대전화</td>
										<td><select name="USER_TELL1" id="USER_TELL1"
											class="inputText">
												<option value="" selected disabled hidden>==</option>
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
												<option value="019">019</option>
										</select> &nbsp;-&nbsp; <input type="text" name="USER_TELL2" size="5"
											maxlength="4" class="inputText" /> &nbsp;-&nbsp; <input
											type="text" name="USER_TELL3" size="5" maxlength="4"
											class="inputText" /></td>
									</tr>
									<tr>
										<td class="join-text">이메일</td>
										<td><input type="text" name="USER_MAIL" maxlength="50"
											class="inputText" />&nbsp;@&nbsp; <select name="USER_MAIL2"
											class="inputText" style="width: 200px">
												<option value="naver.com">naver.com</option>
												<option value="daum.net">daum.net</option>
												<option value="gmail.com">gmail.com</option>
												<option value="nate.com">nate.com</option>
										</select></td>
									</tr>
									<tr>
										<td class="join-text">주소</td>
										<td>
											<!-- 신주소 우편번호 --> 
											<input id="ZIPCODE" name="ZIPCODE" class="inputText" type="text" value="" placeholder="우편번호"
											style="width: 100px;" readonly /> &nbsp; <!-- 우편주소찾기 버튼 -->
											<input id="addrFind" type="button"
											onclick="openDaumZipAddress()" value="주소 찾기" /><br /> <!-- 기본주소 -->
											<input type="text" id="ADDRESS" name="ADDRESS"
											placeholder="기본주소" value="" class="inputText"
											style="width: 240px;" readonly /><br /> <!-- 나머지 주소 --> <input
											type="text" id="ADDRESS_ETC" name="ADDRESS_ETC"
											placeholder="나머지 주소" value="" class="inputText"
											style="width: 240px;" />
										</td>
									</tr>
								</table>
								<button id="joinButton" name="joinButton">가입하기</button>
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
	<script type="text/JavaScript"
		src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

	<script src="https://code.jquery.com/jquery-3.5.0.js"
		integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
		crossorigin="anonymous"></script>

	<script type="text/javascript">
	
	/*  input 창에서 onkeyup -> 키가 떨어질 때 체크,  onchange 변화가 일어날 때 체크.*/
		function noSpaceForm(obj) { 
		    var str_space = /\s/;  
		    if(str_space.exec(obj.value)) {
		        alert("공백입력은 금지되어 있습니다.");
		        obj.focus();
		        obj.value = obj.value.replace(' ','');
		        return false;
		    }
		}
	
	// 핸드폰 입력란에 숫자만 

		$("#USER_TELL2").on("keyup", function() {$(this).val($(this).val().replace(/[^0-9]/g,""));});
	
		$("#USER_TELL3").on("keyup", function() {$(this).val($(this).val().replace(/[^0-9]/g,""));});

		var idCheckFlag = false;
		var nickCheckFlag = false;

		<c:if test="${data.isSuccess == 'false'}">
		alert("회원가입에 실패하였습니다.");
		</c:if>

		//아이디 체크 온클릭
		function idCheck() {
			$.ajax({	
						url : '<%=request.getContextPath()%>/member/idcheck.do',
						type : 'get',
						data : $('#USER_ID').serialize(),
						success : function(data) {
							if (data != '') {
								document.querySelector('#idCheckMsg').textContent = '';
								document.querySelector('#idCheckMsg').textContent = ' 이미 존재하는 아이디 입니다.';
								$("#USER_ID").css("background-color","red");
								idCheckFlag = false;
							} else {
								document.querySelector('#idCheckMsg').textContent = '';
								document.querySelector('#idCheckMsg').textContent = ' 사용가능한 아이디 입니다.';
								$("#USER_ID").css("background-color","white");
								idCheckFlag = true;
							}
							if($("#USER_ID").val()==""){
								document.querySelector('#idCheckMsg').textContent = '';
								window.alert("아이디 입력란이 공백입니다.");
								idCheckFlag = false;
							}
						}
					});
			
		}

		//닉네임 체크
		function nickCheck() {
			$.ajax({
						url : '<%=request.getContextPath()%>/member/nickcheck.do',
						type : 'get',
						data : $('#NICKNAME').serialize(),
						success : function(data) {
							if (data != '') {
								$("#NICKNAME").css("background-color", "red");
								document.querySelector('#nickCheckMsg').textContent = '';
								document.querySelector('#nickCheckMsg').textContent = ' 이미 존재하는 닉네임 입니다.';
								nickCheckFlag = false;
							} else {
								$("#NICKNAME").css("background-color", "white");
								document.querySelector('#nickCheckMsg').textContent = '';
								document.querySelector('#nickCheckMsg').textContent = ' 사용가능한 닉네임 입니다.';
								nickCheckFlag = true;
							}
							if ($("#NICKNAME").val() == "") {
								document.querySelector('#nickCheckMsg').textContent = '';
								window.alert("닉네임 입력란이 공백입니다.");
								nickCheckFlag = false;
							}
						}
					});

		}

		/* 사용자 패스워드  */
		function validate() {
			var pw = document.getElementById('JOIN_USER_PWD');
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

			// 빈칸확인 체크
			var inputText = document.querySelectorAll(".inputText");
			for (var i = 0; i < inputText.length; i++) {
				if (inputText[i].value == "") {
					window.alert("빠진 항목이 있습니다.모든 항목을 입력해주세요.");
					/* $(inputText[i]).css("background-color", "red"); */
					return false;
				}
			}

			//공백 금지
			var blank_pattern = /[\s]/g;
			if (blank_pattern.test(str.value) == true) {
				alert(' 공백은 사용할 수 없습니다. ');
				return false;
			}
			//특수문자 사용금지
			var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
			if (special_pattern.test(str.value) == true) {
				alert('특수문자는 사용할 수 없습니다.');
				return false;
			}

			//공백 금지
			//var blank_pattern = /^\s+|\s+$/g;(/\s/g
			var blank_pattern1 = /[\s]/g;
			if (blank_pattern1.test(str1.value) == true) {
				alert(' 공백은 사용할 수 없습니다. ');
				return false;
			}
			//특수문자 사용금지
			var special_pattern1 = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
			if (special_pattern1.test(str1.value) == true) {
				alert('특수문자는 사용할 수 없습니다.');
				return false;
			}

			if (!idCheckFlag) {
				alert("아이디 중복검사를 해주세요.");
				return false;
			}

			if (!nickCheckFlag) {
				alert("닉네임 중복검사를 해주세요.");
				return false;
			}

			//비밀번호 검사
			//암호는 영문자 숫자 기호문자의 조합으로 8글자 이상 작성해주세요.
			if (!chk(regExpPw, pw, '암호는 영문자 숫자 기호문자의 조합으로 8글자 이상 작성해주세요.')) {
				return false;
			}

			return true;
		};

		//비밀번호 일치 체크
		$('#JOIN_PWD_CHECK').bind("keyup", function() {
			var pwd1 = $("#JOIN_USER_PWD").val();
			var pwd2 = $("#JOIN_PWD_CHECK").val();

			if (pwd1 != '' && pwd2 == '') {
				null;
			} else if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#same").css('display', 'block');
					$("#different").css('display', 'none');
					$("#JOIN_PWD_CHECK").css("background-color", "white");
				} else {
					$("#same").css('display', 'none');
					$("#different").css('display', 'block');
					$("#JOIN_PWD_CHECK").css("background-color", "red");
				}
			}
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
</body>
</html>