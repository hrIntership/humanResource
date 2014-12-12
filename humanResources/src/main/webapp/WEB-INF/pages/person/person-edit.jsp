<%@page import="org.springframework.web.bind.annotation.RequestMethod"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.cme.hr.model.Person"%>
<%@page import="com.cme.hr.controller.PersonController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html lang="en">


<%!Connection conn;
	Statement st;%>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Personal Details</h1>
		</div>
	</div>
	<!-- /.row -->


	<form:form method="POST" commandName="person"
		action="${pageContext.request.contextPath}/person/edit/${person.idPerson}.html">


		<div class="row">
			<div class="col-lg-4">
				<form:label path="firstname">* First Name</form:label>
				<form:input class="form-control" path="firstname" type="text"
					required="true"
					onkeypress="return inputLimiter(event,'NameCharacters')" />
				<form:errors path="firstname" cssStyle="color: red;" />
			</div>
			<div class="col-lg-4">
				<form:label path="middlename">Middle Name</form:label>
				<form:input class="form-control" path="middlename" type="text"
					onkeypress="return inputLimiter(event,'NameCharacters')" />
				<form:errors path="middlename" cssStyle="color: red;" />
			</div>
			<div class="col-lg-4">
				<form:label path="lastname">* Last Name</form:label>
				<form:input class="form-control" path="lastname" type="text"
					required="true"
					onkeypress="return inputLimiter(event,'NameCharacters')" />
				<form:errors path="lastname" cssStyle="color: red;" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<form:label path="photograph">Photograph</form:label>
				<form:input class="form-control" path="photograph" type="file" />
			</div>
		</div>


		<div class="row">
			<div class="col-lg-4">
				<form:label path="idType">ID Type</form:label>
				<select class="form-control" name="idType">
					<option value="" selected="selected">- select -</option>
					<c:forEach var="itemIdType" items="${idTypeList}">
						<option value="<c:out value='${itemIdType}' />"
							<c:if test="${person.idType==itemIdType}"> selected </c:if>>
							<c:out value="${itemIdType}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-lg-4">
				<form:label path="idNumber">ID number</form:label>
				<form:input class="form-control" path="idNumber"
					onkeypress="return inputLimiter(event,'Numbers')" />
				<form:errors path="idNumber" cssStyle="color: red;" />
			</div>
			<div class="col-lg-4">
				<form:label path="cuil">CUIL</form:label>
				<form:input class="form-control" path="cuil"
					onkeypress="return inputLimiter(event,'NumbersCharacters')" />
				<form:errors path="cuil" cssStyle="color: red;" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<form:label path="gender">Gender</form:label>
					<form:label class="radio-inline" path="gender">
						<form:radiobutton path="gender" name="optionsRadiosInline"
							value="Male" />Male
                                </form:label>
					<form:label class="radio-inline" path="gender">
						<form:radiobutton path="gender" name="optionsRadiosInline"
							value="Female" />Female
                                </form:label>
				</div>
			</div>
			<div class="col-lg-4">
				<form:label path="maritalStatus">Marital Status</form:label>
				<select class="form-control" name="maritalStatus"
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

		<div class="row">
			<div class="col-lg-4">
				<form:label path="nationality">Nationality</form:label>
				<select class="form-control" name="nationality">
					<option value="" selected="selected">- select -</option>
					<c:forEach var="itemCountry" items="${countryList}">
						<option value="<c:out value='${itemCountry.idCountry}' />"
							<c:if test="${person.nationality==itemCountry.idCountry}"> selected </c:if>>
							<c:out value="${itemCountry.name}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-lg-4">
				<form:label path="birthdate">Date of Birth</form:label>
				<form:input class="form-control" path="birthdate" value="1970-01-01"
					type="date" />
				<form:errors path="birthdate" cssStyle="color: red;" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Contact Details</h1>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-lg-4">

				<form:label path="country">Country</form:label>
				<select class="form-control" name="country"
					onblur="return validateC(this);">
					<option value="" selected="selected">- select -</option>

					<%
						Class.forName("com.mysql.jdbc.Driver").newInstance();
							conn = DriverManager.getConnection(
									"jdbc:mysql://localhost/hrms", "root", "");
							st = conn.createStatement();
							ResultSet rsc = st
									.executeQuery("SELECT idCountry,name FROM country");
							while (rsc.next()) {
					%>
					<option value="<%=rsc.getString("idCountry")%>">
						<%=rsc.getString("name")%>
					</option>
					<%
						}
					%>
				</select>

				<form:label path="province">State/Province</form:label>
				<select class="form-control" name="province"
					onblur="return validateP(this);">
					<option value="" selected="selected">- select -</option>

					<%
						Class.forName("com.mysql.jdbc.Driver").newInstance();
							conn = DriverManager.getConnection(
									"jdbc:mysql://localhost/hrms", "root", "");
							st = conn.createStatement();
							ResultSet rsp = st
									.executeQuery("SELECT idProvince,name FROM province WHERE idCountry='1'");
							while (rsp.next()) {
					%>
					<option value="<%=rsp.getString("idProvince")%>">
						<%=rsp.getString("name")%>
					</option>
					<%
						}
					%>
				</select>

				<form:label path="city">City</form:label>
				<select class="form-control" name="city"
					onblur="return validateP(this);">
					<option value="" selected="selected">- select -</option>

					<%
						Class.forName("com.mysql.jdbc.Driver").newInstance();
							conn = DriverManager.getConnection(
									"jdbc:mysql://localhost/hrms", "root", "");
							st = conn.createStatement();
							ResultSet rsci = st
									.executeQuery("SELECT idCity,name FROM city WHERE idProvince='10'");
							while (rsci.next()) {
					%>
					<option value="<%=rsci.getString("idCity")%>">
						<%=rsci.getString("name")%>
					</option>
					<%
						}
					%>
				</select>

				<form:label path="zipCode">Zip/Postal Code</form:label>
				<form:input class="form-control" path="zipCode" />

				<form:label path="address1">Address Street 1</form:label>
				<form:input class="form-control" path="address1" />

				<form:label path="address2">Address Street 2</form:label>
				<form:input class="form-control" path="address2" />

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
			<div class="col-lg-4">
				<form:label path="workemail">Work Email</form:label>
				<form:input class="form-control" path="workemail" type="email"
					value="example@domain.com" />
				<form:label path="email">Other Email</form:label>
				<form:input class="form-control" path="email" type="email"
					value="example@domain.com" />
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

	</form:form>
</div>


</body>

</html>
