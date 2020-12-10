+<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<h1>Enter Childrean's Details for CCAP</h1>

		<font color="red">${err }</font> <font color="green">${succ }</font> <font
			color="voilet">${edit }</font>

		<f:form name="Form1" method="post" modelAttribute="plandata">

			<table>

				<tr>
					<f:hidden path="ccapPlanId" />
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
					<td>No of Childrens</td>
					<td><f:input type="text" path="Childrens"  /></td>
				</tr>

				<tr>
					<td>Child's Name</td>
					<td><f:input type="text" path="childName" /></td>
				</tr>

				<tr>
					<td>Child's Gender:</td>
					<td>Male: <f:radiobutton path="childGender" value="Male" /> <br />
						Female: <f:radiobutton path="childGender" value="Female" />
					</td>
				</tr>

				<tr>

					<td>Date Of Birth</td>
					<td><f:input type="date" path="childDob" /></td>
				</tr>

				<tr>
					<td>SSN</td>
					<td><f:input type="text" path="childSsn" /></td>
				</tr>


				<tr>
					<td><INPUT type="button" value="ADD" name=button1
						onclick="return OnButton1();"></td>
				</tr>
			</table>




			<table border="1">
				<tr>
					<td>S.No</td>
					<td>Child_ID</td>
					<td>Child's_Name</td>
					<td>Child's Date Of Birth</td>
					<td>Child's Gender</td>
					<td>Child's SSN</td>
					<td>Action</td>
				</tr>

				<c:set var="iterator" value="1" />
				<c:forEach items="${childDetails}" var="i">
					<tr>
						<td><c:out value="${iterator}" /></td>
						<td><c:out value="${i.ccapPlanId}" /></td>
						<td><c:out value="${i.childName}" /></td>
						<td><c:out value="${i.childDob}" /></td>
						<td><c:out value="${i.childGender}" /></td>
						<td><c:out value="${i.childSsn}" /></td>
						<td><a href="/ies/editchilddetails?id=${i.ccapPlanId}">edit</a>
							<a href="/ies/delchilddetails?id=${i.ccapPlanId}"
							onclick="return confirmdel()">delete</a></td>
					</tr>
					<c:set var="iterator" value="${iterator+1}" />
				</c:forEach>

			</table>
			<INPUT type="button" value="next" name=button2
				onclick="return OnButton2();">


		</f:form>


		<script>
			function confirmdel() {
				return confirm("Are you sure to delete child Details?????");

			}

			function OnButton1() {
				document.Form1.action = "/ies/ccap"
				/* document.Form1.target = "_blank";    // Open in a new window */
				document.Form1.submit(); // Submit the page
				return true;
			}

			function OnButton2() {
				document.Form1.action = "/ies/ccapplan"
				/* document.Form1.target = "_blank";    // Open in a new window */
				document.Form1.submit(); // Submit the page
				return true;
			}
		</script>

	</div>
</body>
</html>