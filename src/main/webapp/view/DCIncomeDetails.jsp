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

		<h1>Enter Income Details</h1>

		<font color="red">${err }</font> <font color="green">${succ }</font>

		<f:form action="/ies/snapplan" method="post" modelAttribute="plandata">

			<table>

				<tr>
					<td>Case Id</td>
					<td><f:input type="text" path="caseId" readonly="true" /></td>
				</tr>

				<tr>
					<td>Plan Name</td>
					<td><f:input type="text" path="planName" readonly="true" /></td>
				</tr>

				<tr>
					<td>Name</td>
					<td><f:input type="text" path="name" readonly="true" /></td>
				</tr>
				<tr>
					<td>Is Working Employee:</td>
					<td><f:radiobutton path="workingEmp" value="Y" />
						Working <br>
					<br /> <f:radiobutton path="workingEmp" value="N" /> Not
						Working</td>
				</tr>
				<tr>
					<td>Other Sources Of Income:-</td>
					<td>$<f:input type="text" path="otherIncome" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="NEXT" /></td>
				</tr>
			</table>

		</f:form>

	</div>
</body>
</html>