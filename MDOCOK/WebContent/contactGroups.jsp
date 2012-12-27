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
			<h2>Your Contact Groups</h2>
			<!-- 			Formulaire de recherche  -->
			<form method="get" action="FindContactGroupServlet"
				class="form-search">
				<input name="search" id="search" type="text"
					class="input-medium search-query">
					 <input type="submit" class="btn" value="Search" />
			</form>

			<table class="table table-hover">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Number of Members</th>

					<th></th>
				</tr>
				<% for(int i =0; i<lcontact.size();i++)
					{
					ContactGroup c = lcontact.get(i);
					%>
				<tr>
					<td><%= c.getGroupId() %></td>
					<td><%= c.getGroupName() %></td>
					<td><%= c.getContacts().size() %></td>

					<td><a class="btn btn-info" type="submit">Update</a></td>
				<tr>
					<% 
					
					}%>
				
			</table>
		</div>
	</div>



	<jsp:include page="footer.jsp" />
</body>
</html>