<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Account Information Page</title>
<%@ include file="common/header.jsp"%>
</head>
<body>

<script type="text/javascript">

function confirmdel()
{
return confirm("Are you sure to delete contact?????");

}


</script>

<%@ include file="nav.jsp"%>
	
	<br><br/><br></br>
	<div align="center">

	<h1>All Accounts</h1>
	<a href="/ies/addaccount">++Add new Account</a>

	<table border="1">
		<tr>
			<td>First_Name</td>
			<td>Last_Name</td>
			<td>Date Of Birth</td>
			<td>Contact_email</td>
			<td>Contact_number</td>
			<td>Role</td>
			<td>Action</td>
		</tr>

		
			<c:forEach items="${accounts}" var="i" >
			<tr>
				<td><c:out value="${i.fname}" /></td>
				<td><c:out value="${i.lname}" /></td>
				<td><c:out value="${i.dob}" /></td>
				<td><c:out value="${i.email}" /></td>
				<td><c:out value="${i.phno}" /></td>
				<td><c:out value="${i.role}" /></td>
			<td>
				<a href="/ies/editaccount?id=${i.accId}" onclick="return ! ${i.deleted}" >edit</a> 
				<a href="/ies/delaccount?id=${i.accId}" onclick="return confirmdel()" >delete</a>
				</td>
			</tr>	
			</c:forEach>
			
	</table>
</div>


</body>
</html>