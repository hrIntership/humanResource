<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>

<!DOCTYPE html>
<%
	HttpSession ses = request.getSession();
	Integer sessionIdPerson = (Integer) ses.getAttribute("id_Person");
%>


<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add emergency contacts</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="emergencyContacts"
		id="emergencyContacts"
		action="${pageContext.request.contextPath}/emergencyContacts/create.html">
		<div id="emergencyContacts">

			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Full name</label>

					<form:input type="text" class="form-control" name="fullName"
						placeholder="Full name" path="fullname" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The full name can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The full name is required and cannot be empty" />

				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Relationship</label>

					<form:input type="text" class="form-control" name="relationship"
						placeholder="Relationship" path="relationship"
						data-bv-regexp="true" data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The relationship can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The relationship is required and cannot be empty" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Movile</label>
					<form:input type="text" class="form-control" name="movile"
						placeholder="Movile" path="movile" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The movile can only consist of alphabetical"
						data-bv-notempty="true"
						data-bv-notempty-message="The movile is required and cannot be empty" />
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>

			<input class="btn btn-default" type="submit" value="save" id="save"
				name="save" /> <input class="btn btn-default" type="submit"
				value="add" id="add" name="add" />

		</div>


	</form:form>

	<script>
		$(document).ready(function() {
			$('#emergencyContacts').bootstrapValidator();
		});
	</script>
</div>

<!--  -</html>-->