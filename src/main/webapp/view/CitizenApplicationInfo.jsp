<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Registration Page</title>
<%@ include file="common/header.jsp"%>
</head>
<body>


	<script type="text/javascript">
		function confirmdeactivate() {
			return confirm("Are you sure to Deactivate?????");

		}

		function confirmactivate() {
			return confirm("Are you sure to Activate?????");

		}
	</script>

	<%@ include file="nav.jsp"%>

	<br></br>

	<br></br>

	<div align="center">

		<font color="green">${msg }</font> 
		<br/>
		
		<h1>All Applications</h1>

		<a href="/ies/addApplicant"> ++ Register new Application</a>

		<table border="1">
			<tr>
				<td>Application no</td>
				<td>First_Name</td>
				<td>Last_Name</td>
				<td>Date Of Birth</td>
				<td>SSN_number</td>
				<td>Is Deactivated</td>

				<td>Action</td>
			</tr>


			<c:forEach items="${applicants}" var="i">
				<tr>
					<td><c:out value="${i.appId}" /></td>
					<td><c:out value="${i.fname}" /></td>
					<td><c:out value="${i.lname}" /></td>
					<td><c:out value="${i.dob}" /></td>
					<td><c:out value="${i.ssn}" /></td>
					<td><c:out value="${i.deleted}" /></td>

					<td>
					   <a href="/ies/editApplicant?id=${i.appId}" onclick=" return ! ${i.deleted}">edit</a> 
					   <%--  <a href="/ies/delApplicant?id=${i.CId}" onclick="return confirmdel()">delete</a>
					    <a href="/ies/delApplicant?id=${i.CId}" onclick="return confirmdel()">delete</a> --%>
					    
					    <c:if test="${i.deleted==true}"> 
					    <a href="/ies/delApplicant?id=${i.appId}" onclick="return confirmactivate()">Activate</a>
					    </c:if>
					    
					   <c:if test="${i.deleted==false}"> 
					   <a href="/ies/delApplicant?id=${i.appId}" onclick="return confirmdeactivate()">Deactivate</a>
					   </c:if>
					</td>
				</tr>
			</c:forEach>

		</table>

	</div>

</body>
</html>