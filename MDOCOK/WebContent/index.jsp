<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="stylesheet/style.css" />
<title>Insert title here</title>
</head>
<body>
	<h1>Bonjour, veuillez vous authentifier</h1>
				<form method="post" action="LoginServlet"\>
					<div class="box">
						
								<label><span>Name : </span><input type="text" name="name" id="name"  class="input_text"/> </label>
								<label ><span>Password : </span><input type="password" name="password" id="password"  class="input_text"/></label> 
						
								<label class=" validate"><input type="submit" value="Submit" class="button"/>
								<input type="reset" value="Reset" class="button"/></label>
						
					</div>
				</form>
</body>
</html>