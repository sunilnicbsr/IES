<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
<%@ include file="common/header.jsp"%>

</head>
<body>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 

	<%@ include file="nav.jsp"%>
	
	<br><br/><br></br>
	
	<div align="center">
	
		<font color="purple">${editmsg }</font>
		<font color="red">${err}</font> 
		<font color="green">${succ}</font>

		<h1>Account Registration</h1>

		<f:form name="form" action="/ies/accountRegistration" method="post"
			modelAttribute="formdata">
			<table style="with: 50%">
				<tr>
				      <f:hidden path="accId"/>
					<td>First Name</td>
					<td><f:input type="text" path="fname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><f:input type="text" path="lname" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><f:input type="text" path="phno" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><f:input type="text" path="email" id="userEmail" /><span
						id="errMsg"></span></td>
				</tr>
				<tr>

					<td>Date Of Birth</td>
					<td><f:input type="date" path="dob" /></td>
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
					<td>Select Role:</td>
					<td><f:select path="role" id="role">
							<f:option value="">-Select-</f:option>
							<f:option value="Case Worker">Case Worker</f:option>
							<f:option value="Admin">Admin</f:option>

						</f:select></td>
				</tr>

			</table>

			<input type="submit" value="Register" id="submitBtn" />
			<input type="Reset" value="Reset" />

		</f:form>

		<br> <br /><a href="/ies/displayAccounts">
			view All Accounts</a>

	</div>
	
	<script>
/* 	$(function() {
		$("#datepicker").datepicker();
	}); */

	$(document).ready(function() {
		$("#userEmail").blur(function() {
			$("#errMsg").text("");
			$.ajax({
				type : "GET",
				url : "uniqueMailCheck?email=" + $("#userEmail").val(),
				success : function(data) {
					if (data == "Email Already Exists") {
						$("#errMsg").text("Duplicate Email");
						$("#submitBtn").prop("disabled", true);
					} else {
						$("#submitBtn").prop("disabled", false);
					}
				}
			});

		}

		);

	});
	
</script>
</body>
</html>