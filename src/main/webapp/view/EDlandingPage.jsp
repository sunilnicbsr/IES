<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ED Module</title>
<%@ include file="common/header.jsp"%>
</head>
<body>

	<%@ include file="nav.jsp"%>

	<br>
	<br />
	<br></br>
	<div align="center">

		<h1>Welcome to ED Module</h1>


		<font color="red">${err}</font> <font color="Green">${succ}</font>

		<h1>Determine Eligibility from here</h1>

		<form action="/ies/edcall" method="post">
			<table>
				<tr>
					<td><h3>Enter Case ID:-</h3></td>
					<td><input type="text" name="caseNumber"></input></td>
				</tr>

				<tr>
					<td><input type="submit" value="Check Eligibility" /></td>
				</tr>
			</table>
		</form>



	</div>


</body>
</html>
