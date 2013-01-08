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
	<%@page import="domain.PhoneNumber"%>
	<%@page import="java.util.ArrayList"%>
	<%
		Contact contact = (Contact) request.getAttribute("Contact");
	%>

	<jsp:include page="menu_gauche.jsp" />

	<div class="container">

		<div class="hero-unit">


			<form name="formulaire" method="get" action="UpdateContactServlet"
				onsubmit="return valider ();">
				<h2 class="form-signin-heading">Update a Contact</h2>
				<input type="hidden" name="id" value="<%=contact.getId()%>">
				<input type="hidden" name="idAddress"
					value="<%=contact.getAdd().getId()%>"> <input
					type="hidden" name="nbPhones"
					value="<%=contact.getPhones().size()%>"> <input
					type="hidden" name="version" value="<%=contact.getVersion()%>">
				<div class="control-group">
					<label class="control-label" for="prenom">Firstname</label>
					<div class="controls">
						<input type="text" id="prenom" name="prenom"
							value="<%=contact.getFirstName()%>" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="nom">Lastname</label>
					<div class="controls">
						<input type="text" id="nom" name="nom"
							value="<%=contact.getLastName()%>" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">Email</label>
					<div class="controls">
						<input type="email" id="email" name="email"
							value="<%=contact.getEmail()%>" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="street">Street</label>
					<div class="controls">
						<input type="text" id="street" name="street"
							value="<%=contact.getAdd().getStreet()%>" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="city">City</label>
					<div class="controls">
						<input type="text" id="city" name="city"
							value="<%=contact.getAdd().getCity()%>" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="zip">ZIP</label>
					<div class="controls">
						<input type="text" id="zip" name="zip"
							value="<%=contact.getAdd().getZip()%>" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="country">Country</label>
					<div class="controls">
						<input type="text" id="country" name="country"
							value="<%=contact.getAdd().getCountry()%>" />
					</div>
				</div>

				<input type="hidden" id="nbTel" name="nbTel"
					value="<%=contact.getPhones().size()%>" />
				<%
					int i = 0;
					for (PhoneNumber p : contact.getPhones()) {
				%>
				<div class="control-group">
					<label class="control-label" for="country"><%=p.getPhoneKind()%></label>
					<div class="controls">
						<input type="text" id="tel<%=i%>" name="tel<%=i%>"
							value="<%=p.getPhoneNumber()%>" />
					</div>
				</div>

				<%
					i++;
					}
				%>


				<div class="control-group">
					<div class="controls">

						<button type="submit" class="btn">Update Contact</button>
						<button type="reset" value="Reset" class="btn">Reset</button>

					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>

<script  type="text/javascript">
function valider ( )
{
	if(document.formulaire.prenom.value == ""){
		   alert ( "Veuillez entrer votre prénom !" );
		    return false;
	}
	if(document.formulaire.prenom.value.match(/[1-9]/g).length > 0){
		   alert ( "Un prenom ne peut pas contenir de nombre !" );
		    return false;
	}
	if(document.formulaire.nom.value == ""){
		   alert ( "Veuillez entrer votre nom !" );
		    return false;
	}
	if(document.formulaire.nom.value.match(/[1-9]/g).length > 0){
		   alert ( "Un nom ne peut pas contenir de nombre !" );
		    return false;
	}
	if(document.formulaire.email.value == ""){
		   alert ( "Veuillez entrer votre email !" );
		    return false;
	}
	if(document.formulaire.nom.value.match(/.+@.+/g).length > 0){
		   alert ( "Le format de votre email est incorrect !" );
		    return false;
	}
	if(document.formulaire.street.value == ""){
		   alert ( "Veuillez entrer une adresse !" );
		    return false;
	}
	if(document.formulaire.city.value == ""){
		   alert ( "Veuillez entrer une ville !" );
		    return false;
	}
	if(document.formulaire.city.value.match(/[1-9]/g).length > 0){
		   alert ( "Une ville ne peut pas contenir de nombre !" );
		    return false;
	}
	if(document.formulaire.zip.value == ""){
		   alert ( "Veuillez entrer votre zip !" );
		    return false;
	}
	if(document.formulaire.zip.value.match(/[a-zA-Z]/g).length > 0){
		   alert ( "Un zip ne peut pas contenir de lettres !" );
		    return false;
	}
	if(document.formulaire.country.value == ""){
		   alert ( "Veuillez entrer votre pays !" );
		    return false;
	}
	if(document.formulaire.country.value.match(/[1-9]/g).length > 0){
		   alert ( "Un pays ne peut pas contenir de nombre !" );
		    return false;
	}
	return true;
    
}
</script>