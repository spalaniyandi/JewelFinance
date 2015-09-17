<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd”>
<html>
<head>
	<%@ page isELIgnored="false" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Finance Application - Search Receipt</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/receipt.css" />" type="text/css" />
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div id="div_body">
	<%@ include file="header.jsp" %>
		<div id="div_data">
			<div id="div_form_title">${receiptTitle}</div>
			<div id="div_form">
				<form:form method="GET" action="${contextPath}/receipt/search" commandName="receiptQuery">
					<fieldset>
						<br/>
						<form:label path="receiptId">Receipt No.</form:label>
						<form:input path="receiptId"/>
						&nbsp;&nbsp;&nbsp;
						<form:label path="loanAmount">Loan Amount</form:label>
						<form:input path="loanAmount"/>
						<br/><br/>
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName"/>
						&nbsp;&nbsp;&nbsp;
						<form:label path="lastName">Last Name</form:label>
						<form:input path="lastName"/>
						<br/><br/>
						<form:label path="loanDate">Loan Date</form:label>
						<form:input path="loanDate"/>
						<br/><br/>
						<form:label path="phone.phoneTypes">Phone Type</form:label>
						<form:select path="phone.phoneTypes">
							<form:options />
						</form:select>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<form:input path="phone.phoneNumber"/>
						<br/><br/>
						<form:label path="idCard.idTypes">ID Card</form:label>
						<form:select path="idCard.idTypes">
							<form:options/>
						</form:select>
						&nbsp;&nbsp;&nbsp;
						<form:input path="idCard.idNumber"/>
					</fieldset>
					<div style="margin: auto; width: 130px;">
						<p><input type="submit" style="height: 30px; width: 120px;" value="Submit"/></p>
					</div>
				</form:form>
			<c:if test="${not empty receipts }">			
				<table class="receipts_output">
					<thead>
						<tr>
							<th width="100">Receipt No.</th>
							<th width="150">Loan Amount</th>
							<th width="100">Loan Date</th>
							<th width="150">First Name</th>
							<th width="150">Last Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${receipts}" var="receipt">
						<tr>
							<td>${receipt.receiptId}</td>
							<td>${receipt.loanAmount}</td>
							<td>${receipt.loanDate}</td>
							<td>${receipt.firstName}</td>
							<td>${receipt.lastName}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			</div>
		</div>
	</div>
</body>
</html>