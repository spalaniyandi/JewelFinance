<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd”>
<html>
	<head>
		<title>Finance Application - Search Receipt</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/receipt.css" />" />
		<%@ page isELIgnored="false" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div id="div_body">
	<%@ include file="header.jsp" %>
		<div id="div_data">
			<form:form method="POST" action="${contextPath}/customer" commandName="customerQuery">
				<fieldset id ="customer_query_form">
					<br/>
					<form:label class="finQueryLabel" path="firstName">First Name</form:label>
					<form:input class="finQueryField" path="firstName"/>
					<br/>
					<form:label class="finQueryLabel" path="lastName">Last Name</form:label>
					<form:input class="finQueryField" path="lastName"/>
					<br/>
					<form:label class="finQueryLabel" path="guardianName">Guardian Name</form:label>
					<form:input class="finQueryField" path="guardianName"/>
					<br/>
					<form:label class="finQueryLabel" path="address.street">Street Line</form:label>
					<form:input class="finQueryField" path="address.street"/>
					<br/>
					<form:label class="finQueryLabel" path="address.street2">Street Line 2</form:label>
					<form:input class="finQueryField" path="address.street2"/>
					<br/>
					<form:label class="finQueryLabel" path="address.city">City</form:label>
					<form:input class="finQueryField" path="address.city"/>
					<br/>
					<form:label class="finQueryLabel" path="address.state">State</form:label>
					<form:input class="finQueryField" path="address.state"/>
					<br/>
					<form:label class="finQueryLabel" path="address.pincode">Pincode</form:label>
					<form:input class="finQueryField" path="address.pincode"/>
					<br/>
					<form:label class="finQueryLabel" path="address.country">Country</form:label>
					<form:input class="finQueryField" path="address.country"/>
					<input type="submit">
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>