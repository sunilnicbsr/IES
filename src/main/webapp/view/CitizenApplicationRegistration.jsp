<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Registration </title>
<%@ include file="common/header.jsp"%>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<br>
	<br />
	<br></br>
	<div align="center">

		<h1>Welcome to Application Registration Module</h1>

		<font color="green">${msg }</font> <font color="red">${errmsg }</font>
		<font color="purple">${editmsg }</font>




		<f:form action="/ies/saveCitizenAccount" method="post"
			modelAttribute="formdata">

			<table>

				<tr>
					<f:hidden path="appId" />

					<td>First Name</td>
					<td><f:input type="text" path="fname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><f:input type="text" path="lname" /></td>
				</tr>


				<tr>

					<td>Date Of Birth</td>
					<td><f:input type="text" path="dob" id="datepicker" /></td>
				</tr>

				<tr>
					<td>SSN</td>
					<td><f:input type="text" path="ssn" /></td>
				</tr>

				<tr>
					<td>Sex:</td>
					<td>Male: <f:radiobutton path="gender" value="Male" /> <br />
						Female: <f:radiobutton path="gender" value="Female" />
					</td>
				</tr>

				<tr>
					<td>Contact No</td>
					<td><f:input type="text" path="phno" /></td>
				</tr>


				<tr>
					<td>Email</td>
					<td><f:input type="text" path="email" />
				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>

		</f:form>

		<a href="/ies/displayCitizenAccounts"> view All Applications</a>

	</div>

	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>

</body>
</html>