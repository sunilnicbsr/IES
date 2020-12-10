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

		<h1>Welcome to Data Collection Module</h1>

		<font color="red">${errmsg }</font>
		<font color="red">${err }</font>

		<form action="/ies/createcase" method="post">
			<table>
				<tr>
					<td><h3>Enter Application Number:-</h3></td>
					<td><input type="text" name="appno"></input></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></input></td>
				</tr>

			</table>
		</form>


	</div>

</body>
</html>