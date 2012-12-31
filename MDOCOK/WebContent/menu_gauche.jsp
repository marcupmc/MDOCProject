<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="menu.jsp">Welcome <%=request.getSession().getAttribute("login")%> !
			</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="menu.jsp">Home</a></li>
					<li><a href="DeconnexionServlet"> Log out </a></li>

				</ul>
			</div>
		</div>
	</div>
</div>

<div class="contenu">
	<div class="span3">
		<div class="well sidebar-nav">
			<ul class="nav nav-list">
				<li class="nav-header"><a href="menu.jsp">Menu</a></li>
				<li><a href="MyProfileServlet"><i class="icon-pencil"></i> My
						Profile</a></li>
				<li><a href="PrintAllContactsServlet"><i class="icon-user"></i>
						My Contacts</a></li>
				<li><a href="findContact.jsp"><i class="icon-search"></i>
						Find Contact</a></li>


				<li><a href="PrintAllGroupsServlet"><i class="icon-book"></i>
						Contact Groups</a></li>

			</ul>

		</div>
		<!--/.well -->
	</div>
	<!--/span-->

	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form method="post" action="NewContactServlet" id="addContactForm">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>Add a new Contact</h3>
			</div>

			<table id="formulaire_contact">
				<div class="modal-body">
					<tr>
						<td>
							<div class="control-group">
								<label class="checkbox"> Enterprise <input
									type="checkbox" onclick="addEnterprise()">
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

				<input type="submit" class="btn btn-primary" value="Add Contact" />
				</td> <a class="btn" data-dismiss="modal" aria-hidden="true">Close</a>
				</td>


			</div>

			</table>

		</form>
	</div>