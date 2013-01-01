<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="menu.jsp">Welcome <%=request.getSession().getAttribute("login")%>
				!
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

<!-- test -->

	<div class="container" id="menu_bar">
	
			<div class="navbar">
			<div class="navbar-inner">
			<a class="brand" href="menu.jsp">Menu</a>
				<ul class="nav">
				
				<!-- 				<li class="nav-header"><a href="menu.jsp">Menu</a></li> -->
				
				<li ><a href="MyProfileServlet"><i class="icon-pencil"></i>
						My Profile</a></li>
				<li ><a href="PrintAllContactsServlet"><i class="icon-user"></i>
						My Contacts</a></li>
				<li ><a href="findContact.jsp"><i class="icon-search"></i>
						Find Contact</a></li>


				<li ><a href="PrintAllGroupsServlet"><i class="icon-book"></i>
						Contact Groups</a></li>
		</ul>
	</div>
	</div>
</div>

<!-- test -->


<div class="contenu">
	

<!--/.well -->



