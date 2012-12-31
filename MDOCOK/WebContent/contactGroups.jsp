<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>Your Contact Groups</title>
</head>
<body>
	<%@page import="domain.ContactGroup"%>
	<%@page import="java.util.ArrayList"%>
	<%
		ArrayList<ContactGroup> lcontact = (ArrayList<ContactGroup>) request.getAttribute("liste");
	%>

	<jsp:include page="menu_gauche.jsp" />


	<div class="container">
		<div class="hero-unit">
			<p>
			<h2>Your Contact Groups</h2>
			<a href="#myModal2" data-toggle="modal"
				class="btn btn-large btn-primary" type="button">Create a Group</a>
			</p>

			<table class="table table-hover">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Number of Members</th>

					<th></th>
					<th></th>
				</tr>
				<%
					for (int i = 0; i < lcontact.size(); i++) {
						ContactGroup c = lcontact.get(i);
				%>
				<tr>
					<td><%=c.getGroupId()%></td>
					<td><%=c.getGroupName()%></td>
					<td><%=c.getContacts().size()%></td>

					<td><a href="ManageContactGroupServlet?id=<%=c.getGroupId()%>" class="btn btn-info" type="submit">Manage</a></td>
					
				</tr>
					<%
						}
					%>
				
			</table>
		</div>
	</div>



	<!-- Modal -->
	<div id="myModal2" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form method="post" action="NewContactGroupServlet"
			id="addContactForm">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>New Contact Group</h3>
			</div>


			<div class="modal-body">
				<tr>
					<div class="control-group">
						<label class="control-label" for="name">Name</label>
						<div class="controls">
							<input type="text" id="name" name="name"
								placeholder="Name of the group">
						</div>
					</div>

				</tr>
			</div>
			</table>
			<div class="modal-footer">

				<input type="submit" class="btn btn-primary" value="Add Group Contact" />
				<a class="btn" data-dismiss="modal" aria-hidden="true">Close</a>



			</div>



		</form>
	</div>



	<jsp:include page="footer.jsp" />
</body>
</html>