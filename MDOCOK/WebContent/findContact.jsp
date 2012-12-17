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
	<%@page import="java.util.ArrayList"%>
	<%
		ArrayList<Contact> lcontact = new ArrayList<Contact>();
		if(request.getAttribute("liste") == null){
		
		}else{
			 lcontact = (ArrayList<Contact>) request.getAttribute("liste");
		}
	%>
	<jsp:include page="menu_gauche.jsp" />

	<div class="span9">
		<div class="hero-unit">
			<h2>Find your Contact</h2>
			<form method="get" action="FindContactServlet" class="form-search">
				<input name="search" type="text" class="input-medium search-query">
				
				
				<button type="submit" class="btn">Search</button>
			</form>
			<!-- 			+ Ajouter un formulaire pour la recherche multi-critere (Requete by example) -->


			<% if(lcontact.size()>0){ %>
			<table class="table table-hover">
				<tr>
					<th>ID</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th></th>
				</tr>
				<% for(int i =0; i<lcontact.size();i++)
					{
					Contact c = lcontact.get(i);
					%>
				<tr>
					<td><%= c.getId() %></td>
					<td><%= c.getFirstName() %></td>
					<td><%= c.getLastName() %></td>
					<td><%= c.getEmail() %></td>
					<td><button class="btn btn-info" type="button">Update</button></td>
				<tr>
					<% 
					
					}%>
				
			</table>
			<% } %>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>