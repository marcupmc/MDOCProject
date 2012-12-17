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
				<li class="nav-header"><a href="menu.jsp">Contacts</a></li>

				<li><a href="addContact.jsp" ><i
						class="icon-user"></i> Add Contact</a></li>
				<li><a href="findContact.jsp"><i class="icon-search"></i>
						Find Contact</a></li>
				<li><a href="PrintAllContactsServlet?action=update"><i
						class="icon-download"></i> Update Contact</a></li>
				<li><a href="PrintAllContactsServlet?action=remove"><i
						class="icon-trash"></i> Delete Contact</a></li>

			</ul>
			<ul class="nav nav-list">
				<li class="nav-header"><a href="menu.jsp">Groups</a></li>
				<li><a href="PrintAllGroupsServlet"><i class="icon-book"></i>Contact Group</a></li>
				
			</ul>
			
		</div>
		<!--/.well -->
	</div>
	<!--/span-->



	
	
	
	