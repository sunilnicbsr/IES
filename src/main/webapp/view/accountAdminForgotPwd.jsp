<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORGOT-PASSWORD-PAGE</title>
<%@ include file="common/header.jsp"%>
</head>
<body>

<%@ include file="nav.jsp"%>
	
	<br><br/><br></br>

	<div align="center">

		<font color="red">${err}</font> <font color="green">${succ}</font>


		<form action="/forgotPwd" method="post">
			<table>
				<tr>
					<td><h3>EMAIL:-</h3></td>
					<td><input type="text" name="email"></input></td>
				</tr>
				<tr>
					<td><br /></td>
				<tr />
				<tr>
					<td><a href="/login">Go to Login Page</a></td>
				</tr>


			</table>
			<input type="submit" value="Enter"/>
		</form>

	</div>

</body>
</html>