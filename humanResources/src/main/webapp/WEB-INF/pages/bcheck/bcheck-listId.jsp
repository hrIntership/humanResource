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

							<th>bcra</th>
							<th>cca</th>
							<th>addressv</th>
							<th>criminalv</th>
							<th>ssnt</th>
							<th>cev</th>
							<th>academicv</th>
							<th>financialc</th>
							<th>hipaaa</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="bCheck" items="${bCheckListId}">
							<tr>

								<td>${bCheck.bcra}</td>
								<td>${bCheck.cca}</td>
								<td>${bCheck.addressv}</td>
								<td>${bCheck.criminalv}</td>
								<td>${bCheck.ssnt}</td>
								<td>${bCheck.cev}</td>
								<td>${bCheck.academicv}</td>
								<td>${bCheck.financialc}</td>
								<td>${bCheck.hipaaa}</td>
								<td><a
									href="${pageContext.request.contextPath}/background/edit/1.html">Edit</a><br />
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