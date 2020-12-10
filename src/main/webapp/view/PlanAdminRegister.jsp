<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan Display page</title>
<%@ include file="common/header.jsp"%>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<br>
	<br />
	<br></br>
	<div align="center">

		<h1>Welcome to Plan Registration</h1>

		<font color="green">${msg }</font> <font color="red">${errmsg }</font>
		<font color="purple">${editmsg }</font>




		<form:form action="/ies/savePlan" method="post"
			modelAttribute="formdata">

			<table>

				<tr>
					<form:hidden path="pid" />
					<td>Plan_Name</td>
					<td><form:input path="planName" /></td>

				</tr>

				<tr>
					<td>Plan_Description</td>
					<td><form:textarea path="planDesp" rows="5" cols="22" /></td>

				</tr>

				<tr>
					<td>Plan_Start-Date</td>
					<td><form:input path="planStartDate" type="text"  id="startdate" /></td>

				</tr>

				<tr>
					<td>Plan_End-Date</td>
					<td><form:input path="planEndDate" type="text"  id="enddate" /></td>

				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>



		</form:form>

		<a href="/ies/display"> view All Plans</a>

	</div>
	
	<script>


	
	
	$(document).ready(function(){
	    $("#startdate").datepicker({
	        numberOfMonths: 1,
	       onSelect: function(selected) {
	          $("#enddate").datepicker("option","minDate", selected)
	        } 
	    });
	    $("#enddate").datepicker({ 
	        numberOfMonths: 1,
	       onSelect: function(selected1) {
	           $("#startdate").datepicker("option","maxDate", selected1)
	        }
	    });  
	});
	
	</script>

</body>
</html>