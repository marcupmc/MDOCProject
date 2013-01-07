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
	<%@page import="domain.PhoneNumber"%>
	<%
		Contact contact = (Contact) request.getAttribute("contact");
		ArrayList<ContactGroup> lgroup = (ArrayList<ContactGroup>) request
				.getAttribute("liste");
	%>
	<jsp:include page="menu_gauche.jsp" />

	<div class="container">
		<div class="hero-unit">
			<%
				if(request.getAttribute("numSiret") == null){
			%>
			<h2>My Informations</h2>
						<%
				} else {
			%>
			<h2>My Enterprise's Informations</h2>
			<%
				}
			%>
			<p>
				<a class="btn btn-large btn-primary"
					href="InitUpdateServlet?id=<%=contact.getId()%>" type="button">Update</a>
			</p>
			<table class="table">
				<tr>
					<td>
						<div>

							<img src="<%=contact.getImagePerso()%>" class="img-rounded"><br />
							<form method="post" action="" enctype="multipart/form-data">
								<input type="file" name="file" required="required" /><br /> <input
									type="submit" class="btn btn-info" value="Change Picture" />
							</form>
						</div>
						<ul class="unstyled">
							<li><strong>Number of Contacts : </strong><%=contact.getFriends().size()%></li>
							<li><strong>Number of Contact Groups : </strong><%=lgroup.size()%></li>

						</ul>
						<button href="#myModal7" data-toggle="modal"
							class="btn btn-danger">Delete my account</button>
					</td>
					<td>
						<ul class="unstyled">
							<%
								
								if(request.getAttribute("numSiret") != null){
									Integer numSiret = (Integer) request.getAttribute("numSiret");
							%>
							<li><strong>NumSiret :</strong> <%=numSiret%></li>

							<%
								}
							%>
							<li><strong>Firstname :</strong> <%=contact.getFirstName()%></li>
							<li><strong>Lastname :</strong> <%=contact.getLastName()%></li>
							<li><strong>Email :</strong> <%=contact.getEmail()%></li>
							<li><strong>Street :</strong> <%=contact.getAdd().getStreet()%></li>
							<li><strong>City :</strong> <%=contact.getAdd().getCity()%></li>
							<li><strong>Zip :</strong> <%=contact.getAdd().getZip()%></li>
							<li><strong>Country :</strong> <%=contact.getAdd().getCountry()%></li>
							<li><strong>Phone Numbers :</strong>
								<ul>
									<%
										for (PhoneNumber p : contact.getPhones()) {
									%>
									<li><strong><%=p.getPhoneKind()%> : </strong><%=p.getPhoneNumber()%><a
										href="DeletePhoneServlet?id=<%=p.getId() %>"
										class="btn btn-mini btn-danger"><i
											class="icon-remove icon-white"></i></a></li>

									<%
										}
									%>
								</ul></li>
							<a href="#myModal6" data-toggle="modal" class="btn btn-success">Add
								Phone Number</a>
						</ul>
					</td>
				</tr>


			</table>

		</div>
	</div>

	<!-- Modal -->
	<div id="myModal6" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form method="post" action="AddNewPhoneServlet" id="addContactForm">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>Add a Phone Number</h3>
			</div>


			<div class="modal-body">
				<tr>
					<div class="control-group">
						<label class="control-label" for="name">Phone number</label>
						<div class="controls">
							<input type="tel" id="phone" name="phone"
								placeholder="Telephone Number">
						</div>
						<select name="type">
							<option value="Home">Home</option>
							<option value="Work">Work</option>
							<option value="Mobile">Mobile Phone</option>
						</select>
					</div>

				</tr>
			</div>
			</table>
			<div class="modal-footer">

				<input type="submit" class="btn btn-primary"
					value="Add Phone Number" /> <a class="btn" data-dismiss="modal"
					aria-hidden="true">Close</a>



			</div>



		</form>
	</div>

	<!-- Modal -->
	<div id="myModal7" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="alert alert-error">
			<form method="post" action="DeleteAccountServlet">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3>Do you want to delete your account ?</h3>
				</div>

				<div class="control-group">
					<input type="submit" class="btn btn-danger"
						value="Delete my account" /> <a class="btn" data-dismiss="modal"
						aria-hidden="true">Close</a>
				</div>
			</form>
		</div>
	</div>


	<jsp:include page="footer.jsp" />
</body>
</html>