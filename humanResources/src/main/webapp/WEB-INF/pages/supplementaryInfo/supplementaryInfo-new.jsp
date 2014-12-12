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


<!--  <html lang="en">-->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael.min.js"></script>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add Supplementary Information</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="supplementaryinfo"
		id="supplementaryinfo"
		action="${pageContext.request.contextPath}/supplementaryinfo/create.html">
		<div id="supplementaryinfo">

			<div class="form-group">
				<label class="col-sm-3 control-label">Operation</label>
				<div class="col-sm-5">
					<form:label class="radio-inline" path="operation">
						<form:radiobutton path="operation" name="optionsRadiosInline"
							value="yes" data-bv-notempty="true"
							data-bv-notempty-message="The operation is required" />Yes
                                </form:label>
					<form:label class="radio-inline" path="operation">
						<form:radiobutton path="operation" name="optionsRadiosInline"
							value="no" data-bv-notempty="true"
							data-bv-notempty-message="The operation is required" />Yes
                                </form:label>
				</div>

				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Amount</label>

					<form:input type="checkbox" class="form-control" name="opAmount"
						placeholder="Full name" path="fullname" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The full name is required and cannot be empty" />

				</div>

				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Causes</label>

					<form:input type="checkbox" class="form-control" name="opAmount"
						placeholder="Full name" path="fullname" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The full name is required and cannot be empty" />

				</div>
			</div>


			<div class="row">
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="nationality">Are you allergic to anything?</form:label>
						<form:input type="text" class="form-control" name="fullName"
							placeholder="Full name" path="fullname" data-bv-regexp="true"
							data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
							data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
							data-bv-notempty="true"
							data-bv-notempty-message="The full name is required and cannot be empty" />

					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="nationality">A que?</form:label>
						<form:input type="text" class="form-control" name="fullName"
							placeholder="Full name" path="fullname" data-bv-regexp="true"
							data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
							data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
							data-bv-notempty="true"
							data-bv-notempty-message="The full name is required and cannot be empty" />

					</div>
				</div>


			</div>

			<div class="row">

				<div class="form-group">
					<div class="col-sm-4">
						<label class="col-lg-4 control-label">Do you have pre
							existing diseases?</label>

						<form:input type="text" class="form-control" name="middlename"
							placeholder="First name" path="middlename" data-bv-regexp="true"
							data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
							data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
							data-bv-notempty="true"
							data-bv-notempty-message="The first name is required and cannot be empty" />
					</div>
				</div>

				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="idType">which</form:label>

						<select class="form-control select2-select" name="idType"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemIdType" items="${idTypeList}">
								<option value="<c:out value='${itemIdType}' />"
									<c:if test="${supplementaryinfo.idType==itemIdType}"> selected </c:if>>
									<c:out value="${itemIdType}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

			</div>

			<div class="col-lg-4">
				<form:label path="birthdate">Blood Types</form:label>
				<select class="form-control select2-select" name="idType"
					required="required">
					<option value="" selected="selected">- select -</option>
					<c:forEach var="itemBloodType" items="${bloodTypeList}">
						<option value="<c:out value='${itemBloodType}' />"
							<c:if test="${familyMember.bloodType==itemBloodType}"> selected </c:if>>
							<c:out value="${itemBloodType}" />
						</option>
					</c:forEach>
				</select>
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
			$('#supplementaryinfo').bootstrapValidator();
		});
	</script>
</div>

<!--  -</html>-->