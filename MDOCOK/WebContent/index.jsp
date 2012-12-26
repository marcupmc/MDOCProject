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

							<button type="submit" class="btn btn-primary">Log In</button>
							<a href="#myModal" data-toggle="modal" value="Reset" class="btn btn-success">Sign in</a>

						</div>
					</div>
				</form>
			</div>
				
		</div>
		</div>
		
		<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form method="post" action="NewContactServlet" id="addContactForm">

			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>Add a new Contact</h3>
			</div>

			<table id="formulaire_contact">
				<div class="modal-body">
				<tr>
					<td>
						<div class="control-group">
							<label class="checkbox"> Enterprise <input type="checkbox" onclick="addEnterprise()" >
							</label>
							<p id="siret"></p>
						</div>
					</td>
					<td>
						<div class="control-group">
							<label class="control-label" for="street">Street</label>
							<div class="controls">
								<input type="text" id="street" name="street"
									placeholder="Street">
							</div>
						</div>
					</td>

				</tr>
				<tr>
					<td>
						<div class="control-group">
							<label class="control-label" for="prenom">Firstname</label>
							<div class="controls">
								<input type="text" id="prenom" name="prenom"
									placeholder="FirstName">
							</div>
						</div>
					</td>
					<td>
						<div class="control-group">
							<label class="control-label" for="city">City</label>
							<div class="controls">
								<input type="text" id="city" name="city" placeholder="City">
							</div>
						</div>
					</td>

				</tr>

				<tr>
					<td>
						<div class="control-group">
							<label class="control-label" for="nom">Lastname</label>
							<div class="controls">
								<input type="text" id="nom" name="nom" placeholder="nom">
							</div>
						</div>
					</td>
					<td>
						<div class="control-group">
							<label class="control-label" for="zip">Zip</label>
							<div class="controls">
								<input type="text" id="zip" name="zip" placeholder="Zip">
							</div>
						</div>
					</td>

				</tr>
				<tr>
					<td>
						<div class="control-group">
							<label class="control-label" for="email">Email</label>
							<div class="controls">
								<input type="email" id="email" name="email" placeholder="email">
							</div>
						</div>
					</td>
					<td>
						<div class="control-group">
							<label class="control-label" for="country">Country</label>
							<div class="controls">
								<input type="text" id="country" name="country"
									placeholder="Country">
							</div>
						</div>
					</td>

				</tr>
				<tr>
					<td>
						<div class="control-group" id="telContact">
							<div id="t0">
								<label class="control-label" for="phoneNumber">Phone
									Number</label>
								<div class="controls">
									<input type="text" id="phoneNumber0" name="phoneNumber0"
										placeholder="Phone Number"> <i class="icon-plus"
										onclick="addTel()"></i>
								</div>
								<select name="type">
									<option value="home">Home</option>
									<option value="work">Work</option>
									<option value="mobile">Mobile Phone</option>
								</select>
							</div>
						</div>
					</td>
					<td>
						<div class="control-group" id="groupContact">
							<div id="g0">
								<label class="control-label" for="groupName">Group</label>
								<div class="controls">
									<input type="text" id="groupName0" name="groupName0"
										placeholder="Group"> <i class="icon-plus"
										onclick="addGroupe()"></i>
								</div>
							</div>
						</div>
					</td>

				</tr>
				</div>
				</table>
				<div class="modal-footer">
				
							<input type="submit" class="btn btn-primary" value="Add Contact"/></td>
							<a class="btn" data-dismiss="modal" aria-hidden="true">Close</a></td>
						
				
				</div>

			</table>

		</form>
	</div>
		
<!-- 		<div id="footer_index"><img alt="" id="footer_index" src="http://storiesof.us/bcmedia/01%20BC%20Logos/BC%20building%20logo%20+%20building%20art/classrooms%20signs/quadcities/chicago%20city.png"></div>	 -->
 			<div id="footer_index"></div> 
		

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/myscripts.js"></script>
</body>

</html>