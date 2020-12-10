<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan Information Page</title>
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

	<h1>All Plans</h1>
	<a href="/ies/addPlan">++Add new Plan</a>

	<table border="1">
		<tr>
			<td>Plan_Name</td>
			<td>Plan_Description</td>
			<td>Plan_Start-Date</td>
			<td>Plan_End-Date</td>
			<td>Action</td>
		</tr>

		
			<c:forEach items="${plans}" var="i" >
			<tr>
				<td><c:out value="${i.planName}" /></td>
				<td><c:out value="${i.planDesp}" /></td>
				<td><c:out value="${i.planStartDate}" /></td>
				<td><c:out value="${i.planEndDate}" /></td>
				<td>
				<a href="/ies/editPlan?id=${i.pid}" onclick="return ! ${i.deleted}" >edit</a> 
				<a href="/ies/delPlan?id=${i.pid}" onclick="return confirmdel()" >delete</a>
				</td>
			</tr>	
			</c:forEach>
			
	</table>

</div>

</body>
</html>