<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<%@page import="domain.Contact"%>
	<%@page import="java.util.ArrayList"%>
	<%
		ArrayList<Contact> lcontact = (ArrayList<Contact>) request.getAttribute("liste");
	%>

<jsp:include page="menu_gauche.jsp"/>


	<div class="container">
		<div class="hero-unit">
			<h2>Your Friends</h2>
			<table class="table table-hover">
				<tr>
					
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<% for(int i =0; i<lcontact.size();i++)
					{
					Contact c = lcontact.get(i);
					%>
					<tr>
						
						<td><%= c.getFirstName() %></td>
						<td><%= c.getLastName() %></td>
						<td><%= c.getEmail() %></td>
						<td><a href="DetailsFriendServlet?id=<%= c.getId() %>" class="btn btn-info" type="buttons">Details</a></td>
						<td><a href="InitUpdateServlet?id=<%= c.getId() %>" class="btn btn-primary" type="button">Add to Groups</a></td>
						<td><a href="DeleteContactServlet?id=<%= c.getId() %>" class="btn btn-danger" type="buttons">Delete</a></td>
						
					<tr>
					<% 
					
					}%>
			</table>
		</div>
	</div>
	
	
	
	 <jsp:include page="footer.jsp"/>
</body>
</html>