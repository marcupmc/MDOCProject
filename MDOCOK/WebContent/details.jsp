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
	<%@page import="domain.PhoneNumber"%>
	<%@page import="domain.ContactGroup"%>
	<%@page import="java.util.ArrayList"%>
	<%
	Contact contact  = (Contact) request.getAttribute("contact");
	 ArrayList<ContactGroup> lgroup = (ArrayList<ContactGroup>)request.getAttribute("liste");
	
		
	%>
	<jsp:include page="menu_gauche.jsp" />

	<div class="container">
		<div class="hero-unit">
			<h2>About  <%= contact.getFirstName()  %>  <%= contact.getLastName()  %></h2>
			
			<!-- 			+ Ajouter un formulaire pour la recherche multi-critere (Requete by example) -->


			
			<table class="table">
				<tr>
					<td>
						<ul class="unstyled">
							<li><strong>Firstname :</strong> <%= contact.getFirstName()  %></li>
							<li><strong>Lastname :</strong> <%= contact.getLastName()  %></li>
							<li><strong>Email :</strong> <%= contact.getEmail()  %></li>
							<li><strong>Street :</strong> <%= contact.getAdd().getStreet()  %></li>
							<li><strong>City :</strong> <%= contact.getAdd().getCity()  %></li>
							<li><strong>Zip :</strong> <%= contact.getAdd().getZip()  %></li>
							<li><strong>Country :</strong> <%= contact.getAdd().getCountry()  %></li>
							<%for(PhoneNumber p : contact.getPhones()){
								%>
								<li><strong><%=p.getPhoneKind() %> :</strong> <%= p.getPhoneNumber()  %></li>
							<%} %>
						</ul>
					</td>
					<td>
					<ul class="unstyled">
							<li><strong>Number of Contacts : </strong><%= contact.getFriends().size()  %></li>
							<li><strong>Number of Contact Groups : </strong><%=lgroup.size() %></li>
							
						</ul>
					</td>
				</tr>
				
				
			</table>
			
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>