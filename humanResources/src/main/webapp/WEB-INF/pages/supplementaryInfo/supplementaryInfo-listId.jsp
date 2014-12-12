<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List Supplementary Information</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>

							<th>Operation</th>
							<th>Amount</th>
							<th>Causes</th>
							<th>Allergy</th>
							<th>Pre existing Diseases</th>
							<th>Blood Type</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="supplementaryInfo" items="${supplementaryInfoListId}">
							<tr>

								<td>${supplementaryInfo.operation}</td>
								<td>${supplementaryInfo.opAmount}</td>
								<td>${supplementaryInfo.opCauses}</td>
								<td>${supplementaryInfo.allergy}</td>
								<td>${supplementaryInfo.preexDiseases}</td>
								<td>${supplementaryInfo.bloodType}</td>
					
					
								<td><a
									href="${pageContext.request.contextPath}/supplementaryInfo/edit/1.html">Edit</a><br />
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