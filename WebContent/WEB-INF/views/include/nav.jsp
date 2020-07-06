<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav id="nav">
			<div class="container">
				<div class="row">
					<div class="nav">
						<ul>
							<li><a href="<%=request.getContextPath()%>/board/intro.do">지역화폐</a></li>
							<li><a href="<%=request.getContextPath()%>/board/notice.do">공지사항</a></li>
							<li><a href="<%=request.getContextPath()%>/board/searchmarket.do">전통시장검색</a></li>
							<li><a href="<%=request.getContextPath()%>/board/review.do">사용후기</a></li>
							<li><a href="<%=request.getContextPath()%>/board/usedmarket.do">중고장터</a></li>
							<li><a href="<%=request.getContextPath()%>/service/support.do">고객센터</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>