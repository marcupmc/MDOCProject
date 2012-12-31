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
		long idFriend = (Long)request.getAttribute("idFriend");
		String firstname = (String)request.getAttribute("firstname");
		String lastname =(String)request.getAttribute("lastname"); 
	%>

	<jsp:include page="menu_gauche.jsp" />


	<div class="container">
		<div class="hero-unit">
			<p>
			<h2>Add In Groups</h2>
			
			</p>

			<p>Add <%=firstname %> <%=lastname %> in this following groups</p>
			<form method="post" action="AddContactToGroupsServlet">
			<input type="hidden" name="nb" value="<%=lcontact.size() %>"/>
			<input type="hidden" name="idFriend" value="<%=idFriend %>"/>
			<table class="table table-hover">
				<tr>
					
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
					
					<td><%=c.getGroupName()%></td>
					<td><%=c.getContacts().size()%></td>

					<td><input type="checkbox" id="<%=i%>" name="<%=i%>"/></td>
					<input type="hidden" name="G<%=i %>" value="<%=c.getGroupId() %>">
				</tr>
					<%
						}
					%>
				
			</table>
			
			<input type="submit" class="btn btn-primary" value="Add To Groups"/>
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>