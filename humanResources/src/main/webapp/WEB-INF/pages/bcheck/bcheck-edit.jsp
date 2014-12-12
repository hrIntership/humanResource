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
			<h1 class="page-header">Edit background</h1>
		</div>
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-6">

			<form:form method="POST" commandName="background"
				action="${pageContext.request.contextPath}/background/edit/${person.idPerson}.html">
				<div class="table-responsive">
					<table class="table">
						<tbody>


							<tr>
								<td>Company:</td>
								<td><form:input path="company" /></td>
							</tr>
							<tr>
								<td>Position:</td>
								<td><form:input path="position" /></td>
							</tr>
							<tr>
								<td>Since:</td>
								<td><form:input path="dateSince" value="1970-01-01"
										type="date" /></td>
							</tr>
							<tr>
								<td>To:</td>
								<td><form:input path="dateTo" value="1970-01-01"
										type="date" /></td>
							</tr>
							<tr>
								<td>Tasks:</td>
								<td><form:textarea path="tasks" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Save" /></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>

			</form:form>
			<a href="${pageContext.request.contextPath}/">Home page</a>

		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->

</html>
