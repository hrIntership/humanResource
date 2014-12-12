<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>

<!DOCTYPE html>


<!--  <html lang="en">-->
<%
	HttpSession ses = request.getSession();
	Integer sessionIdPerson = (Integer) ses.getAttribute("id_Person");
%>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add Family Member</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="familyMember" id="familyMember"
		action="${pageContext.request.contextPath}/familyMember/create.html">
		<div id="familyMember">
	<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Full name</label>

					<form:input type="text" class="form-control" name="fullName"
						placeholder="Full name" path="fullName" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The full name can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The full name is required and cannot be empty" />

				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-4">
					<div class="form-group">
						<form:label path="nationality">Nationality</form:label>
						<select class="form-control select2-select" name="nationality"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemCountry" items="${countryList}">
								<option value="<c:out value='${itemCountry.idCountry}' />"
									<c:if test="${familyMember.nationality==itemCountry.idCountry}"> selected </c:if>>
									<c:out value="${itemCountry.name}" />
								</option>
							</c:forEach>
						</select>
					</div>
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

			<div class="row">
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="idType">ID Type</form:label>

						<select class="form-control select2-select" name="idType"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemIdType" items="${idTypeList}">
								<option value="<c:out value='${itemIdType}' />"
									<c:if test="${familyMember.idType==itemIdType}"> selected </c:if>>
									<c:out value="${itemIdType}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="idNumber">ID number</form:label>
						<form:input class="form-control" path="idNumber"
							data-bv-regexp="true" data-bv-regexp-regexp="^[0-9]+$"
							data-bv-regexp-message="The ID Number can only consist of number"
							data-bv-notempty="true"
							data-bv-notempty-message="The ID Number is required and cannot be empty" />
						<form:errors path="idNumber" cssStyle="color: red;" />
					</div>
				</div>

				<div class="col-lg-4">
					<form:label path="birthdate">Date of Birth</form:label>
					<form:input class="form-control" path="birthdate"
						value="1970-01-01" type="date" />
					<form:errors path="birthdate" cssStyle="color: red;" />
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
		</div>
	</form:form>

	<script>
		$(document).ready(function() {
			$('#familyMember').bootstrapValidator();
		});
	</script>
</div>

<!--  -</html>-->