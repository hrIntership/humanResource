<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List Background</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>

							<th>From</th>
							<th>To</th>
							<th>Salary</th>
							<th>Tasks</th>
							<th>Workspace</th>
							<th>Agreement</th>
							<th>Category</th>
							<th>Health Insurance</th>
							<th>Actions</th>	

						</tr>
					</thead>
					<tbody>
						<c:forEach var="staff" items="${staffListId}">
							<tr>

								<td>${staff.dateFrom}</td>
								<td>${staff.dateTo}</td>
								<td>${staff.salary}</td>
								<td>${staff.tasks}</td>
								<td>${staff.workspace}</td>
								<td>${staff.agreement}</td>
								<td>${staff.category}</td>
								<td>${staff.healthInsurance}</td>
								<td><a
									href="${pageContext.request.contextPath}/staff/edit/${staff.idStaff}.html">Edit</a><br />
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