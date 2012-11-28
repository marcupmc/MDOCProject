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

	<jsp:include page="menu_gauche.jsp"/>

	<div class="span9">
	
	<div class="hero-unit">
	

		<form  method="post" action="NewContactServlet">
			<h2 class="form-signin-heading">Add a new Contact</h2>
			<div class="control-group">
				<label class="control-label" for="Name">Id</label>
				<div class="controls">
					<input type="text" id="id" name="id" placeholder="Id">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="prenom">Firstname</label>
				<div class="controls">
					<input type="text" id="prenom" name="prenom"
						placeholder="FirstName">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="nom">Lastname</label>
				<div class="controls">
					<input type="text" id="nom" name="nom" placeholder="nom">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
					<input type="email" id="email" name="email" placeholder="email">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">

					<button type="submit" class="btn">Add Contact</button>
					<button type="reset" value="Reset" class="btn">Reset</button>

				</div>
			</div>
		</form>
		</div>
		</div>
</body>
</html>