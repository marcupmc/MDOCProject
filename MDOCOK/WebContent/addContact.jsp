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

	<jsp:include page="menu_gauche.jsp" />

	<div class="span9">

		<div class="hero-unit">
			<form method="post" action="NewContactServlet">

				<h3>Add a new Contact</h3>

				<table id="formulaire_contact">
					<tr>
						<td>
							<div class="control-group">
								<label class="control-label" for="Name">Id</label>
								<div class="controls">
									<input type="text" id="id" name="id" placeholder="Id">
								</div>
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

					<tr>
						<div class="control-group">
							<div class="controls"></div>
							<td><button type="submit" class="btn">Add Contact</button></td>
							<td><button type="reset" value="Reset" class="btn">Reset</button></td>
					</tr>
				</table>

			</form>
		</div>
	</div>


	<jsp:include page="footer.jsp" />
</body>
</html>