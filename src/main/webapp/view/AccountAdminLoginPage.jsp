<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IES Login Page</title>
<%@ include file="common/header.jsp"%>
</head>
<body>

	<%@ include file="nav.jsp"%>
	
	<br><br/><br></br>
	<div align="center">

		<h1>Welcome to IES APPLICATION</h1>
		
	
        <font color="red">${err}</font>
        
		<h1>SIGN IN HERE</h1>

		<form action="/ies/signin" method="post">
			<table>
				<tr>
					<td><h3>EMAIL:-</h3></td>
					<td><input type="text" name="email"></input></td>
				</tr>
				<tr>
					<td><h3>PASSWORD:-</h3></td>
					<td><input type="password" name="pwd"></input></td>
				</tr>

				<tr>
					<td align="center">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="Login"></input></td>
				   </tr>

			</table>
		</form>
		<br /> <br />
		<table>
			<tr>
				<td><a href="/ies/forgotPwd">FORGOT PASSWORD</a></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><a href="/ies/register">SIGN UP</a></td>
			</tr>

		</table>


	</div>


</body>
</html>
