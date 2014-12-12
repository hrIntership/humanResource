<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>

<!DOCTYPE html>


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
			<h1 class="page-header">Add Employee</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="person" id="person"
		action="${pageContext.request.contextPath}/person/create.html">
		<div id="person">

			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Full name</label>

					<form:input type="text" class="form-control" name="firstName"
						placeholder="First name" path="firstname" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The first name is required and cannot be empty" />

				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Middle name</label>

					<form:input type="text" class="form-control" name="middlename"
						placeholder="First name" path="middlename" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
						data-bv-notempty="true"
						data-bv-notempty-message="The first name is required and cannot be empty" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">* Last Name</label>
					<form:input type="text" class="form-control" name="lastname"
						placeholder="First name" path="lastname" data-bv-regexp="true"
						data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
						data-bv-regexp-message="The username can only consist of alphabetical"
						data-bv-notempty="true"
						data-bv-notempty-message="The first name is required and cannot be empty" />
				</div>
			</div>




			<div class="row"></div>
			<div class="row">
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="idType">ID Type</form:label>

						<select class="form-control select2-select" name="idType"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemIdType" items="${idTypeList}">
								<option value="<c:out value='${itemIdType}' />"
									<c:if test="${person.idType==itemIdType}"> selected </c:if>>
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
							data-bv-regexp-message="The username can only consist of number"
							data-bv-notempty="true"
							data-bv-notempty-message="The first name is required and cannot be empty" />
						<form:errors path="idNumber" cssStyle="color: red;" />
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="cuil">CUIL</form:label>
						<form:input class="form-control" path="cuil" data-bv-regexp="true"
							data-bv-regexp-regexp="^[0-9,-]+$"
							data-bv-regexp-message="The username can only consist of number"
							data-bv-notempty="true"
							data-bv-notempty-message="The first name is required and cannot be empty" />
						<form:errors path="cuil" cssStyle="color: red;" />
					</div>
				</div>
			</div>
			<div class="row"></div>
			<div class="row">
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="gender">Gender</form:label>
						<div>
							<form:label class="radio-inline" path="gender">
								<form:radiobutton path="gender" name="optionsRadiosInline"
									value="Male" data-bv-notempty="true"
									data-bv-notempty-message="The gender is required" />Male
                                </form:label>
							<form:label class="radio-inline" path="gender">
								<form:radiobutton path="gender" name="optionsRadiosInline"
									value="Female" />Female
                                </form:label>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="maritalStatus">Marital Status</form:label>
						<select class="form-control select2-select" name="maritalStatus"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemMS" items="${msList}">
								<option value="<c:out value='${itemMS}' />"
									<c:if test="${person.maritalStatus==itemMS}"> selected </c:if>>
									<c:out value="${itemMS}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="photograph">Photograph</form:label>
						<form:input class="form-control" path="photograph" type="file" />
					</div>
				</div>
			</div>
			<div class="row"></div>
			<div class="row">
				<div class="col-lg-4">
					<div class="form-group">
						<form:label path="nationality">Nationality</form:label>
						<select class="form-control select2-select" name="nationality"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemCountry" items="${countryList}">
								<option value="<c:out value='${itemCountry.idCountry}' />"
									<c:if test="${person.nationality==itemCountry.idCountry}"> selected </c:if>>
									<c:out value="${itemCountry.name}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<form:label path="birthdate">Date of Birth</form:label>
					<form:input class="form-control" path="birthdate"
						value="1970-01-01" type="date" />
					<form:errors path="birthdate" cssStyle="color: red;" />
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Personal Details</h1>
				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-4">
					<form:label path="address1">Address Street 1</form:label>
					<form:input class="form-control" path="address1" />

					<form:label path="address2">Address Street 2</form:label>
					<form:input class="form-control" path="address2" />

					<form:label path="city">City</form:label>
					<select class="form-control" name="city">
						<option value="" selected="selected">- select -</option>
						<c:forEach var="itemCity" items="${cityList}">
							<option value="<c:out value='${itemCity.idCity}' />"
								<c:if test="${person.city==itemCity.idCity}"> selected </c:if>>
								<c:out value="${itemCity.name}" />
							</option>
						</c:forEach>
					</select>

					<form:label path="province">State/Province</form:label>
					<select class="form-control" name="province">
						<option value="" selected="selected">- select -</option>
						<c:forEach var="itemProvince" items="${provinceList}">
							<option value="<c:out value='${itemProvince.idProvince}' />"
								<c:if test="${person.province==itemProvince.idProvince}"> selected </c:if>>
								<c:out value="${itemProvince.name}" />
							</option>
						</c:forEach>
					</select>

					<form:label path="zipCode">Zip/Postal Code</form:label>
					<form:input class="form-control" path="zipCode" />

					<form:label path="country">Country</form:label>
					<select class="form-control" name="country" id="country">
						<option value="" selected="selected">- select -</option>
						<c:forEach var="itemCountry" items="${countryList}">
							<option value="<c:out value='${itemCountry.idCountry}' />"
								<c:if test="${person.country==itemCountry.idCountry}"> selected </c:if>>
								<c:out value="${itemCountry.name}" />
							</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-4">
					<form:label path="phone">Home Telephone</form:label>
					<form:input class="form-control" path="phone" />
					<form:label path="movile">Movile</form:label>
					<form:input class="form-control" path="movile" />
					<form:label path="workphone">Work Telephone</form:label>
					<form:input class="form-control" path="workphone" />
				</div>
			</div>


			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>
			<div class="row">
				<div class="form-group">

					<div class="col-lg-4">
						<form:label path="workemail">Work Email</form:label>
						<form:input class="form-control" path="workemail" type="email"
							value="example@domain.com" placeholder="Email address" />
						<form:label path="email">Other Email</form:label>
						<form:input class="form-control" path="email" type="email"
							value="example@domain.com" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-4">
					<form:label path="state">State:</form:label>

					<select class="form-control" name="state" required="required">
						<option value="" selected="selected">- select -</option>
						<c:forEach var="itemState" items="${stateList}">
							<option value="<c:out value='${itemState}' />"
								<c:if test="${person.state==itemState}"> selected </c:if>>
								<c:out value="${itemState}" />
							</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>

			<input class="btn btn-default" type="submit" value="Save" />

		</div>


	</form:form>

	<script>
		$(document).ready(function() {
			$('#person').bootstrapValidator();
		});
	</script>
</div>

<!--  -</html>-->