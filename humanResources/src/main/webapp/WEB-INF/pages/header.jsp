<!DOCTYPE html>
<html lang="en">
<div class="header">



	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}">RH
				Admin</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i> Admin <b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
					<li><a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a></li>
					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
							Out</a></li>
				</ul></li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li class="active"><a href="${pageContext.request.contextPath}"><i
						class="fa fa-fw fa-dashboard"></i> HOME</a></li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> PERSON
						<i class="fa fa-fw fa-caret-down"></i></a>
					<ul id="demo" class="collapse">
						<li><a
							href="${pageContext.request.contextPath}/person/create.html">New
								Person</a></li>
						<li><a
							href="${pageContext.request.contextPath}/person/list.html">List
								Person</a></li>
								<li><a
							href="${pageContext.request.contextPath}/staff/list/1.html">Background check</a></li>
						<li><a
							href="${pageContext.request.contextPath}/bCheck/list/1.html">Background check</a></li>
						<li><a
							href="${pageContext.request.contextPath}/emergencyContacts/list/1.html">Emergency
								Contacts</a></li>
						<li><a
							href="${pageContext.request.contextPath}/familyMember/list/1.html">Family
								Member</a></li>
						<li><a
							href="${pageContext.request.contextPath}/supplementaryInfo/list/1.html">Supplementary
								Info</a></li>
					</ul></li>

			</ul>
		</div>

	</nav>



</div>
</html>
