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

							<th>Company</th>
							<th>Job Title</th>
							<th>From</th>
							<th>To</th>
							<th>Comment</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="background" items="${backgroundListId}">
							<tr>

								<td>${background.company}</td>
								<td>${background.jobTitle}</td>
								<td>${background.dateFrom}</td>
								<td>${background.dateTo}</td>
								<td>${background.comment}</td>
								<td><a
									href="${pageContext.request.contextPath}/background/edit/${background.idBackground}.html">Edit</a><br />
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