<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset='utf-8'>
<title>管理画面</title>
</head>
<body>
	<h3>登录成功 ！</h3>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>欢迎：${pageContext.request.userPrincipal.name}</h2>
	</c:if>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<input type="submit" value="退出">
	</form>
</body>
</html>
