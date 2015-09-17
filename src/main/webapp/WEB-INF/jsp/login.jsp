<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ page isELIgnored="false" %>
	<title>Finance Application - Login</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/receipt.css" />" type="text/css" />
</head>
<body>
	<div id="div_body">
		<div id="div_title">
			Laxmi Finance
		</div>
		<div id="div_data">
		<br/><br/>
		<div id="div_form_title">Please login</div>
		<br/>
		<div style="width: 300px; margin: auto;">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		<form action="<c:url value='j_spring_security_check' />" method="POST">
			<table id="loginForm">
				<tr>
					<td>User id:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password"  name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
		</div>
		</div>
	</div>
</body>
</html>