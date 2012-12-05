<%@page import="domain.ContactGroup"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<jsp:include page="common_lib.jsp" />
<title>Add a Contact</title>

</head>
<body>
	<%@page import="domain.Contact"%>
	<%@page import="java.util.ArrayList"%>
	<%
		Contact contact =  (Contact)request.getAttribute("Contact");
	%>

	<jsp:include page="menu_gauche.jsp"/>

	<div class="span9">
	
	<div class="hero-unit">
	

		<form  method="get" action="UpdateContactServlet">
			<h2 class="form-signin-heading">Update a Contact</h2>
			<input type="hidden" name="id" value="<%=contact.getId() %>">
			<div class="control-group">
				<label class="control-label" for="prenom">Firstname</label>
				<div class="controls">
					<input type="text" id="prenom" name="prenom"
						placeholder="<%= contact.getFirstName() %>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="nom">Lastname</label>
				<div class="controls">
					<input type="text" id="nom" name="nom" placeholder="<%= contact.getLastName() %>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
					<input type="email" id="email" name="email" placeholder="<%= contact.getEmail() %>"/>
				</div>
			</div>
			<% for(ContactGroup group : contact.getBooks() ){
				
				
				}%>
			
			
			<div class="control-group">
				<div class="controls">

					<button type="submit" class="btn">Update Contact</button>
					<button type="reset" value="Reset" class="btn">Reset</button>

				</div>
			</div>
		</form>
		</div>
		</div>
		 <jsp:include page="footer.jsp"/>
</body>
</html>