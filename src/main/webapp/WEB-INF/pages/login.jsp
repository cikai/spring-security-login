<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset='utf-8'>
<title>用户登录</title>
</head>
<body>
	<div class="login">
		<h3>登录</h3>

		<c:if test="${not empty error}">
			<div style="color: red;">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div style="color: blue;">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type='text' name='username' value="root" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type='password' name='password' value="123456" /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="登录" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
