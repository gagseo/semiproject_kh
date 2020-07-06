<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.5.0.js"
	integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
	crossorigin="anonymous"></script>
<script async src="//client.uchat.io/uchat.js" charset="utf-8"></script>

<script async src="//client.uchat.io/uchat.js"></script>
<c:if test="${sessionScope.loginInfo != null }">
<u-chat room='smwMarket'
	user_data='nick ${sessionScope.loginInfo.user_name}|level 2|id ${sessionScope.loginInfo.user_id}'
	style="display:inline-block; width:400px; height:500px;"></u-chat>
</c:if>
<c:if test="${sessionScope.loginInfo == null }">	
	<div style="display:inline-block; width:400px; height:500px; text-align:center;">로그인 후 채팅기능을 이용하실 수 있습니다.</div>
</c:if>