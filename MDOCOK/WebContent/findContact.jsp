<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="FindContactServlet"\>
		<div class="box">
			<p>
				<label for="recherche">Quel est le critère de votre recherche ?</label> 
				<select name="recherche" id="recheche">
					<option value="id">Par ID</option>
					<option value="nom">Par nom</option>
					<option value=prenom">Par prenom</option>
					<option value="mail">Par Email</option>
				</select>
			</p>
			<input type="text" name="id" id="id" class="input_text" /> <label
				class=" validate"><input type="submit" value="Submit"
				class="button" /> <input type="reset" value="Reset" class="button" /></label>
		</div>
	</form>
</body>
</html>