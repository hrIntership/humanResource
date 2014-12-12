<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List Emergency Contacts</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>

							<th>Full Name</th>
							<th>Relationship</th>
							<th>Movile</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emergencyContacts" items="${emergencyContactsListId}">
							<tr>

								<td>${emergencyContacts.fullName}</td>
								<td>${emergencyContacts.relationship}</td>
								<td>${emergencyContacts.movile}</td>
								<td><a
									href="${pageContext.request.contextPath}/emergencyContacts/edit/1.html">Edit</a><br />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->

</html>