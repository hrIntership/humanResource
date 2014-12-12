<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<%
	HttpSession ses = request.getSession();
	Integer sessionIdPerson = (Integer) ses.getAttribute("id_Person");
%>



<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add Work Experience</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="background"
		action="${pageContext.request.contextPath}/bcheck/create.html">


		<form:input type="hidden" path="idPerson" value='<%=sessionIdPerson%>' />


		<div class="row">
			<div class="col-lg-4">
				<form:label path="bcra">Background Check Release Authorization</form:label>
				<form:input class="form-control" path="bcra" type="file" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<form:label path="cca">CME Confidentiality Agreement</form:label>
				<form:input class="form-control" path="cca" type="file" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<form:label path="addressv">Address Verification</form:label>
				<form:input class="form-control" path="addressv" type="file" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<form:label path="criminalv">Criminal Verification</form:label>
				<form:input class="form-control" path="criminalv" type="file" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<form:label path="ssnt">SSN Trace</form:label>
				<form:input class="form-control" path="ssnt" type="file" />
			</div>
		</div>


		<div class="row">
			<div class="col-lg-4">
				<form:label path="cev">Company/Employment Verification</form:label>
				<form:input class="form-control" path="cev" type="file" />
			</div>
		</div>


		<div class="row">
			<div class="col-lg-4">
				<form:label path="academicv">Academic Verification</form:label>
				<form:input class="form-control" path="photograph" type="file" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<form:label path="financialc">Financial Check</form:label>
				<form:input class="form-control" path="financialc" type="file" />
			</div>
		</div>


		<div class="row">
			<div class="col-lg-4">
				<form:label path="hipaaa">HIPAA Agreement</form:label>
				<form:input class="form-control" path="hipaaa" type="file" />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
		</div>
		<input class="btn btn-default" type="submit" value="save" id="save"
			name="save" />
	</form:form>
</div>
<!-- /.container-fluid -->

</html>
