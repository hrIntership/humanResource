<%@page import="org.springframework.web.bind.annotation.RequestMethod"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.cme.hr.model.Person"%>
<%@page import="com.cme.hr.controller.PersonController"%>
<%@page import="com.cme.hr.controller.BackgroundController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add Work Experience</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="background"
		action="${pageContext.request.contextPath}/background/edit/${person.idPerson}.html">

		<div class="row">
			<div class="col-lg-4">
				<form:label path="company">Company *</form:label>
				<form:input class="form-control" path="company" />

				<form:label path="jobTitle">Job Title *</form:label>
				<form:input class="form-control" path="jobTitle" />

				<form:label path="dateFrom">From</form:label>
				<form:input class="form-control" path="dateFrom" value="1970-01-01"
					type="date" />

				<form:label path="dateTo">To</form:label>
				<form:input class="form-control" path="dateTo" value="1970-01-01"
					type="date" />

				<form:label path="comment">Comment</form:label>
				<form:textarea class="form-control" path="comment" />

			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
		</div>
		<input class="btn btn-default" type="submit" value="save" id="save"
			name="save" />
		<input class="btn btn-default" type="submit" value="add" id="add"
			name="saveandcont" />

	</form:form>
</div>
<!-- /.container-fluid -->

</html>