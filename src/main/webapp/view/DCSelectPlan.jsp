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

		<h1>Choose Plan</h1>

		<font color="red">${err }</font>

		<f:form action="/ies/selectedplan" method="post" modelAttribute="plandata">

			<table>

				<tr>
					<f:hidden path="selectedPlanId" />
					<td>Case Id</td>
					<td><f:input type="text" path="caseId" readonly="true" /></td>
				</tr>

				<tr>
					<td>First Name</td>
					<td><f:input type="text" path="fname" readonly="true" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><f:input type="text" path="lname" readonly="true" /></td>
				</tr>
				<tr>
					<td>Select Plan:</td>
					<td><f:select path="plan">
							<f:option value="">-Select-</f:option>
							<f:options items="${plans}"></f:options>
						</f:select></td>
				</tr>

				<tr>
					<td><input type="submit" value="NEXT" /></td>
				</tr>
			</table>

		</f:form>

	</div>
</body>
</html>