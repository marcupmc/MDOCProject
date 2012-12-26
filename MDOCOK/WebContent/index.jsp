<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>Contact Manager</title>
</head>
<body>
	<div class ="row" id="global_index">
		<div class="contenu">
			<div class="span4 offset1" id="welcome">
				<h4>Welcome to Contact Manager.</h4>
				<p>
					This application allows you to manage your contact and make groups.<br />
					Keep in touch with everyone !
				</p>
			</div>
			<div class="span4 offset2">
				<form class="form-signin" method="post" action="LoginServlet">
					<h2 class="form-signin-heading">Please sign in</h2>
					<div class="control-group">
						<label class="control-label" for="Name">Name</label>
						<div class="controls">
							<input type="text" id="name" name="name" placeholder="Name">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="password" name="password"
								placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">

							<button type="submit" class="btn">Sign in</button>
							<button type="reset" value="Reset" class="btn">Reset</button>

						</div>
					</div>
				</form>
			</div>
				
		</div>
		</div>
<!-- 		<div id="footer_index"><img alt="" id="footer_index" src="http://storiesof.us/bcmedia/01%20BC%20Logos/BC%20building%20logo%20+%20building%20art/classrooms%20signs/quadcities/chicago%20city.png"></div>	 -->
 			<div id="footer_index"></div> 
		


</body>
</html>