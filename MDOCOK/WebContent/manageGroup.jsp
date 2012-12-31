<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<jsp:include page="common_lib.jsp" />
<title>Find your Contact</title>

</head>
<body>

	<%@page import="domain.Contact"%>
	<%@page import="domain.ContactGroup"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.Iterator"%>
	<%
		ContactGroup groupe = (ContactGroup) request.getAttribute("groupe");
		ArrayList<Contact> friends = (ArrayList<Contact>) request
				.getAttribute("friends");
	%>
	<jsp:include page="menu_gauche.jsp" />

	<div class="container">
		<div class="hero-unit">
			<h2>
				Group :
				<%=groupe.getGroupName()%></h2>
			<table class="table table-hover">
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>

					<th></th>

				</tr>
				<%
					Iterator<Contact> iterator = groupe.getContacts().iterator();
					while (iterator.hasNext()) {
						Contact c = iterator.next();
				%>
				<tr>
					<td><%=c.getFirstName()%></td>
					<td><%=c.getLastName()%></td>
					<td><%=c.getEmail()%></td>

					<td><a class="btn btn-danger" href="DeleteContactFromAGroupServlet?idC=<%=c.getId()%>&idG=<%=groupe.getGroupId()%>"><i class="icon-remove icon-white"></i></a></td>

				</tr>
				<%
					}
				%>
				<tr>
					<td><a href="#myModal4" data-toggle="modal"
						class="btn btn-primary" type="button">Add Contacts</a></td>
					<td></td>
					<td></td>
					<td><a href="" class="btn btn-danger" type="button">Delete
							This Group</a></td>
				</tr>

			</table>

		</div>
	</div>

	<!-- 	Modal ajout contact -->
	<!-- Modal -->
	<div id="myModal4" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form method="post" action="AddContactToAGroupServlet"
			id="addContactForm">
			<input type="hidden" name="nbFriend" value="<%=friends.size()%>" />
			<input type="hidden" name="groupeId" value="<%=groupe.getGroupId()%>" />
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>
					Add Contact to
					<%=groupe.getGroupName()%>'s group
				</h3>
			</div>


			<div class="modal-body">
				<table class="table table-hover">
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
						<th></th>
					</tr>

					<%
						int i = 0;
						for (Contact friend : friends) {
					%>
					<tr>
						<td><%=friend.getFirstName()%></td>
						<td><%=friend.getLastName()%></td>
						<td><%=friend.getEmail()%></td>
						<td><input type="checkbox" id="<%=i%>" name="<%=i%>"/></td>
						<input type="hidden" name="F<%=i %>" value="<%=friend.getId() %>">

					</tr>

					<%
						i++;
						}
					%>
				</table>
			</div>

			<div class="modal-footer">

				<input type="submit" class="btn btn-primary"
					value="Add to <%=groupe.getGroupName()%>" /> <a class="btn"
					data-dismiss="modal" aria-hidden="true">Close</a>



			</div>



		</form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>