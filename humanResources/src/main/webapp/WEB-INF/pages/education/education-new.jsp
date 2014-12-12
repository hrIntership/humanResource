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
			<h1 class="page-header">Add Education Experience</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="education"
		action="${pageContext.request.contextPath}/education/create.html">


		<form:input type="hidden" path="idPerson" value='<%=sessionIdPerson%>' />

		<div class="row">
			<div class="col-lg-4">
				<form:label path="level">Level *</form:label>
				<select class="form-control" name="level" required="required">
					<option value="" selected="selected">- select -</option>
					<c:forEach var="itemEdu" items="${eduList}">
						<option value="<c:out value='${itemEdu}' />"
							<c:if test="${education.level==itemEdu}"> selected </c:if>>
							<c:out value="${itemEdu}" />
						</option>
					</c:forEach>
				</select>

				<form:label path="major">Major/Specialization</form:label>
				<form:input class="form-control" path="major" />

				<form:label path="year">Year</form:label>
				<form:input class="form-control" path="year" />

				<form:label path="score">GPA/Score</form:label>
				<form:input class="form-control" path="score" />

				<form:label path="institute">Institute</form:label>
				<form:input class="form-control" path="institute" />

				<form:label path="startDate">Start Date</form:label>
				<form:input class="form-control" path="startDate" value="1970-01-01"
					type="date" />

				<form:label path="endDate">End Date</form:label>
				<form:input class="form-control" path="endDate" value="1970-01-01"
					type="date" />

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
