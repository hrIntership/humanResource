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
			<h1 class="page-header">Add Staff</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="staff"
		action="${pageContext.request.contextPath}/staff/create.html">


		<form:input type="hidden" path="idPerson" value='<%=sessionIdPerson%>' />

		<div class="row">
						<form:label path="dateFrom">date From</form:label>
				<form:input class="form-control" path="dateFrom" value="1970-01-01"
					type="date" />
		
						<form:label path="dateTo">date To</form:label>
				<form:input class="form-control" path="dateTo" value="1970-01-01"
					type="date" />

				<form:label path="salary">salary</form:label>
				<form:input class="form-control" path="salary" />

				<form:label path="tasks">tasks</form:label>
				<form:input class="form-control" path="tasks" />

				<form:label path="workspace">workspace</form:label>
				<form:input class="form-control" path="workspace" />

				<form:label path="agreement">agreement</form:label>
				<form:input class="form-control" path="agreement" />
				
				<form:label path="category">category</form:label>
				<form:input class="form-control" path="category" />

				<form:label path="healthInsurance">healthInsurance</form:label>
				<form:input class="form-control" path="healthInsurance" />
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
