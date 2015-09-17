<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="true"%>

<div id="div_title">
	Laxmi Finance
</div>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<br/>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<span style="float: left; font-size: 20px;"><b>Welcome : ${pageContext.request.userPrincipal.name}</b></span> 
	<span style="float: right;"><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></span>  
</c:if>
<br/>
<div id="finance_menu_bar"> 
	<ul>
		<li><a href="${contextPath}/receipt">New Receipt</a></li>
		<li><a href="${contextPath}/search/receipt">Search Receipt</a></li>
		<li><a href="#">Cancel Receipt</a></li>
		<li><a href="${contextPath}/search/customer">View Customer</a></li>
	</ul>
</div>