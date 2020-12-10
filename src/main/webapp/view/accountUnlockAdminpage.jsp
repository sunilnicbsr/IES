<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock form</title>
<%@ include file="common/header.jsp"%>
</head>
<body>

	<script>
		function matchpwd() {
			var firstpassword = document.getElementsByName(nwPwd).value;
			var secondpassword = document.getElementsByName(cnfrmPwd).value;
			console.log("first",firstpassword);
			console.log("second",secondpassword);

			if (firstpassword == secondpassword) {
				return true;
			} else {
				alert("password must be same!");
				return false;
			}
		}
	</script>
	
	<%@ include file="nav.jsp"%>
	
	<br><br/><br></br>
	<div align="center">
		<font color="red">${err}</font> <font color="green">${succ}</font>

		<h1>Unlock Your Account Here!!!!</h1>

		<f:form action="unlockAcc?email=${unlockobj.email}"
			method="post" modelAttribute="unlockobj">
			<table style="with: 50%">
				<tr>
					<td><h3>${unlockobj.email}</h3></td>
				</tr>
				<tr>
					<td>Temporary Password:</td>
					<td><f:password path="tempPwd" /></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><f:password path="newPwd"/></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><f:password path="cnfrmPwd"/></td>
				</tr>

			</table>

			<input type="submit" value="Save" onclick="return matchpwd()" />
			<input type="Reset" value="Reset" />

		</f:form>
	</div>

</body>
</html>