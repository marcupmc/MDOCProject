<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="NewContactServlet">
		Id : <input type="text" name="id" />
		Nom : <input type="text" name="nom" />
		Prenom : <input type="text" name="prenom"/>
		email : <input type="email" name="email"/>
		<input type = "Submit" />
	</form>
</body>
</html>