+<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DC Module</title>
<%@ include file="common/header.jsp"%>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<br>
	<br />
	<br></br>
	<div align="center">

		<h1>Create Case</h1>
		
		<font color="red">${err }</font>

		<f:form action="/ies/registercase" method="post" modelAttribute="formdata">

			<table>

				<tr>
					<td>Application Id</td>
					<td><f:input type="text" path="appId" readonly="true" /></td>
				</tr>

				<tr>
					<td>First Name</td>
					<td><f:input type="text" path="fname" readonly="true"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><f:input type="text" path="lname" readonly="true"/></td>
				</tr>


				<tr>

					<td>Date Of Birth</td>
					<td><f:input type="text" path="dob" readonly="true"/></td>
				</tr>

				<tr>
					<td>SSN</td>
					<td><f:input type="text" path="ssn" readonly="true"/></td>
				</tr>

				<tr>
					<td>Sex:</td>
					<td><f:input type="text" path="gender" readonly="true" /></td>
				</tr>

				<tr>
					<td>Contact No</td>
					<td><f:input type="text" path="phno" readonly="true" /></td>
				</tr>


				<tr>
					<td>Email</td>
					<td><f:input type="text" path="email" readonly="true"/>
				</tr>
				<tr>
					<td><input type="submit" value="Create Case" readonly="true" /></td>
				</tr>
			</table>

		</f:form>
		
		</div>
</body>
</html>