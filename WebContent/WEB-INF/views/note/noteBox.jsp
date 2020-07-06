<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지함</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>

<body id="note_bg" data-gr-c-s-loaded="true">

	<!-- 변경필요 일단 쪽지함 보기위해서 구현해놨습니다. -->
	<!-- contents_section01 -->
	<div id="notePg">
		<div class="noteSub">
			<div id="noteBox01">
				<div id="noteList">
					<ul id="notTab">
						<li><a href="#" title="tab1">받은 쪽지</a></li>
						<li><a href="#" title="tab2">보낸 쪽지</a></li>
						<li><a href="#" title="tab3">쪽지 보관</a></li>
					</ul>
				</div>
				<div id="subTab">
					<div id="tab1">
						받은쪽지
						<table border="1">
							<tr>
								<th>제목</th>
								<th>보낸사람</th>
								<th>날짜</th>
							</tr>
							<tr>
								<td>title</td>
								<td>spendUser</td>
								<td>00.00.00</td>
							</tr>
						</table>

						<div id="tabnext1">
							<ul>
								<li><a href="#"><</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">></a></li>
							</ul>
						</div>
					</div>
					<div id="tab2">
						보낸쪽지
						<table border="1">
							<tr>
								<th>제목</th>
								<th>받는사람</th>
								<th>날짜</th>
							</tr>
							<tr>
								<td>title</td>
								<td>User</td>
								<td>00.00.00</td>
							</tr>
						</table>
						
						<div id="tabnext2">
							<ul>
								<li><a href="#"><</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">></a></li>
							</ul>
						</div>
					</div>
					<div id="tab3">
						쪽지보관
						<table border="1">
							<tr>
								<th>제목</th>
								<th>보낸사람</th>
								<th>날짜</th>
							</tr>
							<tr>
								<td>title</td>
								<td>spendUser</td>
								<td>00.00.00</td>
							</tr>
						</table>
						<div id="tabnext3">
							<ul>
								<li><a href="#"><</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 검색창 -->
		<div id="searchBar">
			<select name="search_type" style="height: 21px;">
				<option value="sub_memo">제목+본문</option>
				<option value="subject">제목만</option>
				<option value="name">이름으로</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
		</div>

	</div>


	<%-- <!--note_title-->
			<div id="note_tile">
				<p>
					<span>안읽은 쪽지</span> <span>받은쪽지 </span>
				</p>
			</div>
			<!--//note_title-->

			<!-- note_section -->
			<div class="note_section01">

				<!-- 선택된 메모가 있을때;; -->

				<!-- tab -->
				<div class="tab">
					<ul class="tabs">
						<li class="tabMenu1"><a href="" class="current"><span>받은쪽지</span></a></li>
						<li class="tabMenu2"><a href=""><span>보낸쪽지</span></a></li>
						<li class="tabMenu3"><a href=""><span>쪽지보관</span></a></li>
					</ul>
					<!-- //tabs -->

					<!-- text_info -->
					<div id="text_info">
						<!-- panes -->
						<div class="panes">

							<!--받은 쪽지-->
							<!-- tabCon -->
							<div class="tabCon">
								<!-- table_accordion -->
								<div class="table_accordion01">
									<table summary="" border="1">
										<colgroup>
											<col width="20px">
											<col width="">
											<col width="120px">
											<col width="34px">
										</colgroup>
										<thead>
											<tr>
												<th scope="col"><input type="checkbox"
													onclick="reverse();"></th>
												<th scope="col" class="sub_title">제목</th>
												<th scope="col" class="sub_title">보낸사람</th>
												<th scope="col" class="sub_title">날짜</th>
											</tr>
										</thead>
										<form name="memolist" id="memolist" method="post" action=""></form>
										<input type="hidden" name="exec" value="del_all">
										<input type="hidden" name="memo_type" value="inbox">
										<input type="hidden" name="search_type" value="">
										<input type="hidden" name="keyword" value="">
										<input type="hidden" name="page" value="1">
										<input type="hidden" name="slave" value="">
										<input type="hidden" name="move_no" value="">
									</table>
								</div>
								<!-- //table_accordion -->


								<div class="note_msg">

									<div class="btns">
										<a href="#" onclick="move_save(); return false;"
											class="btn_keep"> <span><img src="" alt="보관"></span></a>
										<a href="" class="btn_keep"> <span><img src=""
												alt="삭제"></span></a>
									</div>

									<!--page-->
									<div id="page_list">
										
									</div>
									<!--//page-->
								</div>

								<!-- search_box -->
								<div class="search_box01">
									<form method="get" name="search" action="">
										<input type="hidden" name="memo_type" value="inbox">
										<table border="0" cellspacing="0" cellpadding="0">
											<tbody>
												<tr>
													<td style="width: 150px; text-align: right;"><nobr>

															<select name="search_type" style="height: 21px;">
																<option value="sub_memo">제목+본문</option>
																<option value="subject">제목만</option>
																<option value="name">이름으로</option>
															</select>
														</nobr></td>
													<td class="search-input"><span class="default">
															<input type="text" name="keyword" id="keyword" value=""
															size="15" class="input"> <input type="submit"
															onfocus="blur()" value=""
															style="background-color: #ffffff">
													</span></td>
												</tr>
											</tbody>
										</table>
									</form>
								</div>
								<!-- search_box -->
							</div>
							<!-- //tabCon -->
							<!--//받은 쪽지-->
						</div>
						<!-- panes -->
					</div>
					<!-- text_info -->
				</div>
				<!-- //tab -->
			</div>
			<!-- //note_section -->

		</div>
		<!-- contents_section01 --> --%>

	<!-- 스크립트 부분  -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#subTab div").hide();
			$("#notTab li:first").attr("id", "current");
			$("#subTab div:first").fadeIn();

			/* intTab의 메뉴를 클릭했을 때 선택된 목록의 div를 제외하고 안보이게 처리  */
			$('#notTab a').click(function(e) {
				e.preventDefault();
				$("#subTab div").hide();
				$("notTab li").attr("id", "");
				$(this).parent().attr("id", "current");
				$('#' + $(this).attr('title')).fadeIn();
			});
		});
	</script>



	<script language="JavaScript" src="/js/default.js"
		type="text/JavaScript"></script>
	<script src="/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/js/jquery.tools.min.js"></script>
	<script type="text/javascript"
		src="/thickbox/thickbox.patch.20100708.js"></script>


	<script type="text/javascript">
		function doDeleteMemo() {
			if (!confirm('삭제하시겠습니까?'))
				return;
			$('#memolist').submit();
		}

		function move_save(no) {
			if (confirm('선택된 쪽지를 보관함에 추가하겠습니까?')) {
				document.memolist.exec.value = 'move_save';
				document.memolist.slave.value = 'off';
				document.memolist.move_no.value = no;
				document.memolist.submit();
			}
			return;
		}
		function reverse() {
			var i, chked = 0;
			for (i = 0; i < document.memolist.length; i++) {
				if (document.memolist[i].type == 'checkbox') {
					if (document.memolist[i].checked) {
						document.memolist[i].checked = false;
					} else {
						document.memolist[i].checked = true;
					}
				}
			}
		}

		$(document).ready(function() {
		});
	</script>
</body>
</html>