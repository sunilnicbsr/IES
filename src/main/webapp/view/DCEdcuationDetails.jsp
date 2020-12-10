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

		<h1>Enter Education Details for KT-WORKS</h1>

		<font color="red">${err }</font>
		<font color="green">${succ }</font>

		<f:form action="/ies/ktplan" method="post" modelAttribute="plandata">

			<table>

				<tr>
					<f:hidden path="ktPlanId" />
					<td>Case Id</td>
					<td><f:input type="text" path="caseId" readonly="true" /></td>
				</tr>

				<tr>
					<td>Plan Name</td>
					<td><f:input type="text" path="planName" readonly="true" /></td>
				</tr>
				
				<tr>
					<td>Individual's Name</td>
					<td><f:input type="text" path="name" readonly="true" /></td>
				</tr>
				
				<tr>
					<td>Highest Qualification</td>
					<td><f:select path="qual">
							<f:option value="">-Enter Highest Qualification -</f:option>
							<f:options items="${qualifications}"></f:options>
						</f:select></td>
				</tr>
				<tr>
					<td>Completed Year</td>
					<td><f:input type="text" path="year"
							placeholder="Enter year of completion " /></td>
				</tr>

				<tr>
					<td>Grade</td>
					<td><f:select path="grade">
							<f:option value="">-Enter Grade Secured -</f:option>
							<f:options items="${grades}"></f:options>
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