<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="true"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ page isELIgnored="false" %>
	<title>Finance Application - Create Receipt</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/receipt.css" />" type="text/css" />
</head>
<body>
	<div id="div_body">
	<%@ include file="header.jsp" %>
	 
	<div id="div_data">
	<div id="div_form_title">${receiptTitle}</div>
	<c:if test="${not empty errorMessage}">
		<p class="error_message"><strong>${errorMessage}</strong></p>
	</c:if>
	<c:if test="${not empty receipt}">
	<div id="div_form">
		<form:form method="POST" action="receipt" commandName="receipt">
		<table class="receipt_form_table">
			<tr>
				<td class="td_label">Loan Amount</td><td class="td_seperator">:</td>
				<td><form:input path="loanAmount"/></td>
				<td><form:errors path="loanAmount" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">Load Date</td><td class="td_seperator">:</td>
				<td><form:input path="loanDate"/></td>
				<td><form:errors path="loanDate" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">First Name</td><td class="td_seperator">:</td>
				<td><form:input path="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">Last Name</td><td class="td_seperator">:</td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">Guardian Name</td><td class="td_seperator">:</td>
				<td><form:input path="guardianName"/></td>
				<td><form:errors path="guardianName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">Address :</td>
			</tr>
			<tr>
				<td class="td_label">Street No 1</td><td class="td_seperator">:</td>
				<td><form:input path="address.street"/></td>
				<td><form:errors path="address.street" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Street No 2</td><td class="td_seperator">:</td>
				<td><form:input path="address.street2"/></td>
				<td><form:errors path="address.street2" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">City</td><td class="td_seperator">:</td>
				<td><form:input path="address.city"/></td>
				<td><form:errors path="address.city" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">State</td><td class="td_seperator">:</td>
				<td><form:input path="address.state"/></td>
				<td><form:errors path="address.state" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Pincode</td><td class="td_seperator">:</td>
				<td><form:input path="address.pincode"/></td>
				<td><form:errors path="address.pincode" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Country</td><td class="td_seperator">:</td>
				<td><form:input path="address.country"/></td>
				<td><form:errors path="address.country" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Phone Type :</td>
			</tr>
			<tr>
				<td class="td_label">
					<form:select path="phone.phoneTypes">
						<form:options/>
					</form:select>
				</td><td class="td_seperator">:</td>
				<td><form:input path="phone.phoneNumber"/></td>
				<td><form:errors path="phone.phoneNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Item Description :</td>
			</tr>
			<tr>
					<c:forEach items="${receipt.items}" varStatus="itemRow">
					<tr>
						<td class="td_label">Item Name</td><td class="td_seperator">:</td>
						<td>
							<c:out value="${status.expression}"/>
							<spring:bind path="items[${itemRow.index}].itemName">
								<input type="text" name="<c:out value="${status.expression}"/>"
									id="<c:out value="${status.expression}"/>"
									value="<c:out value="${status.value}"/>" />
							</spring:bind>
							<c:out value="${status.value}"/>
						</td>
						<td class="td_label">Item Quantity</td><td class="td_seperator">:</td>
						<td>
							<c:out value="${status.expression}"/>
							<spring:bind path="items[${itemRow.index}].itemQty">
								<input type="text" name="<c:out value="${status.expression}"/>"
									id="<c:out value="${status.expression}"/>"
									value="<c:out value="${status.value}"/>" />
							</spring:bind>
							<c:out value="${status.value}"/>
						</td>
					</tr>
					</c:forEach>
			</tr>
			<tr>
				<td class="td_label">Total Item Qty</td><td class="td_seperator">:</td>
				<td><form:input path="totalQty"/></td>
				<td><form:errors path="totalQty" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Weight :</td>
			</tr>
			<tr>
				<td class="td_label">Kilogram</td><td class="td_seperator">:</td>
				<td><form:input path="weight.kilogram"/></td>
				<td><form:errors path="weight.kilogram" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">gram</td><td class="td_seperator">:</td>
				<td><form:input path="weight.gram"/></td>
				<td><form:errors path="weight.gram" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">milligram</td><td class="td_seperator">:</td>
				<td><form:input path="weight.milligram"/></td>
				<td><form:errors path="weight.milligram" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="td_label">Return Date</td><td class="td_seperator">:</td>
				<td><form:input path="returnDate"/></td>
				<td><form:errors path="returnDate" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="td_label">ID Card Type :</td>
			</tr>
			<tr>
				<td class="td_label">
				<form:select path="idCard.idTypes">
					<form:options/>
				</form:select>
				</td><td class="td_seperator">:</td>
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
