<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ page isELIgnored="false" %>
	<title>Finance Application - Create Customer</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/receipt.css" />" type="text/css" />
</head>
<body>
	<div id="div_body">
	<%@ include file="header.jsp" %>
	 
	<div id="div_data">
	<div id="div_form_title">Add new customer</div>
	<c:if test="${not empty errorMessage}">
		<p class="error_message"><strong>${errorMessage}</strong></p>
	</c:if>
	<c:if test="${not empty customer}">
	<div id="div_form">
		<form:form method="POST" action="customer" commandName="customer">
		<table class="receipt_form_table">
			<tr>
				<td class="td_label">First Name</td>
				<td><form:input path="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">Last Name</td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">Guardian Name</td>
				<td><form:input path="guardianName"/></td>
				<td><form:errors path="guardianName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2">Permanent Address</td>
				<td colspan="2">Present Address</td>
			</tr>
			<tr>
				<td class="td_label">Street No 1</td>
				<td><form:input path="permenantAddress.street"/></td>
				<td><form:errors path="permenantAddress.street" cssClass="error" /></td>
				
				<td class="td_label">Street No 1</td>
				<td><form:input path="presentAddress.street"/></td>
				<td><form:errors path="presentAddress.street" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Street No 2</td>
				<td><form:input path="permenantAddress.street2"/></td>
				<td><form:errors path="permenantAddress.street2" cssClass="error" /></td>
				
				<td class="td_label">Street No 2</td>
				<td><form:input path="presentAddress.street2"/></td>
				<td><form:errors path="presentAddress.street2" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">City</td>
				<td><form:input path="permenantAddress.city"/></td>
				<td><form:errors path="permenantAddress.city" cssClass="error" /></td>
				
				<td class="td_label">City</td>
				<td><form:input path="presentAddress.city"/></td>
				<td><form:errors path="presentAddress.city" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">State</td>
				<td><form:input path="permenantAddress.state"/></td>
				<td><form:errors path="permenantAddress.state" cssClass="error" /></td>
				
				<td class="td_label">State</td>
				<td><form:input path="presentAddress.state"/></td>
				<td><form:errors path="presentAddress.state" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Pincode</td>
				<td><form:input path="permenantAddress.pincode"/></td>
				<td><form:errors path="permenantAddress.pincode" cssClass="error" /></td>
				
				<td class="td_label">Pincode</td>
				<td><form:input path="presentAddress.pincode"/></td>
				<td><form:errors path="presentAddress.pincode" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Country</td>
				<td><form:input path="permenantAddress.country"/></td>
				<td><form:errors path="permenantAddress.country" cssClass="error" /></td>
				
				<td class="td_label">Country</td>
				<td><form:input path="presentAddress.country"/></td>
				<td><form:errors path="presentAddress.country" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Phone Type :</td>
			</tr>
			<tr>
				<td class="td_label">${customer.phones[0].phoneTypes}</td>
				<td><form:input path="phones[0].phoneNumber" /></td>
			</tr>
			<tr>
				<td class="td_label">${customer.phones[1].phoneTypes}</td>
				<td><form:input path="phones[1].phoneNumber" /></td>
			</tr>
			<tr>
				<td class="td_label">${customer.phones[2].phoneTypes}</td>
				<td><form:input path="phones[2].phoneNumber" /></td>
			</tr>
			<tr>
				<td class="td_label">
					<form:select path="idCard.idTypes">
						<form:options/>
					</form:select>
				</td>
				<td><form:input path="idCard.idNumber"/></td>
				<td><form:errors path="idCard.idNumber" cssClass="error" /></td>
			</tr>
		</table>
		<div style="margin: auto; width: 130px;">
			<p><input type="submit" style="height: 30px; width: 120px;" value="Submit"/></p>
		</div>
		</form:form>
	</div>
	</c:if>
	</div>
	</div>
</body>
</html>