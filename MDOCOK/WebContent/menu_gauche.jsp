<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="menu.jsp">Welcome <%=request.getSession().getAttribute("login")%>!
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

				<li><a href="#myModal" data-toggle="modal"><i
						class="icon-user"></i> Add Contact</a></li>
				<li><a href="findContact.jsp"><i class="icon-search"></i>
						Find Contact</a></li>
				<li><a href="PrintAllContactsServlet?action=update"><i
						class="icon-download"></i> Update Contact</a></li>
				<li><a href="PrintAllContactsServlet?action=remove"><i
						class="icon-trash"></i> Delete Contact</a></li>

			</ul>
		</div>
		<!--/.well -->
	</div>
	<!--/span-->



	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="hero-unit">
			<form method="post" action="NewContactServlet">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">Add a new Contact</h3>
				</div>
				<div class="modal-body">
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
						<label class="control-label" for="street">Street</label>
						<div class="controls">
							<input type="text" id="street" name="street" placeholder="Street">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="city">City</label>
						<div class="controls">
							<input type="text" id="city" name="city" placeholder="City">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="zip">Zip</label>
						<div class="controls">
							<input type="text" id="zip" name="zip" placeholder="Zip">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="country">Country</label>
						<div class="controls">
							<input type="text" id="country" name="country"
								placeholder="Country">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="phoneNumber">Phone
							Number</label>
						<div class="controls">
							<input type="text" id="phoneNumber" name="phoneNumber"
								placeholder="Phone Number">
						</div>
						<select name="type">
							<option value="home">Home</option>
							<option value="work">Work</option>
							<option value="mobile">Mobile Phone</option>
						</select>
					</div>
					<div class="control-group">
						<label class="control-label" for="groupName">Group</label>
						<div class="controls">
							<input type="text" id="groupName" name="groupName"
								placeholder="Group">
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn">Add Contact</button>
							<button type="reset" value="Reset" class="btn">Reset</button>

						</div>
					</div>
				</div>

			</form>
		</div>
	</div>