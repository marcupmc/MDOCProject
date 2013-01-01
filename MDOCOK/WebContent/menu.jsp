<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>Menu</title>
</head>
<body>
	
	
	<jsp:include page="menu_gauche.jsp"/>
		
		<div class="container">
          <div class="hero-unit">
            <h2>Your Contact Manager</h2>
            <p>Keep in touch with all your friends !</p>
            
            <div class="row-fluid">
            <ul class="thumbnails">
              <li class="span4">
                <div class="thumbnail">
                  <img data-src="holder.js/300x200" alt="">
                  <div class="caption">
                    <h3>Edit Your Profil</h3>
                    <p>Everyone can see your profil on this network, so make sure the information you give are ok !</p>
                    <p align="center"><a href="MyProfileServlet" class="btn btn-large btn-primary">Edit Your Profil</a> </p>
                  </div>
                </div>
              </li>
              <li class="span4">
                <div class="thumbnail">
                  <img data-src="holder.js/300x200" alt="">
                  <div class="caption">
                    <h3>Find Contact</h3>
                    <p>There is many poeple in Contact Manager. Find people you know, and them in your Contact's list.</p>
                   	<p align="center"><a href="findContact.jsp" class="btn btn-large btn-success">Find Contacts</a> </p>
                  </div>
                </div>
              </li>
              <li class="span4">
                <div class="thumbnail">
                  
                  <div class="caption">
                    <h3>Contact Group</h3>
                    <p>You can organise your contacts by group. Create and customize your contacts group</p>
                    <p align="center"><a href="PrintAllGroupsServlet" class="btn btn-large btn-info">Create Contacts Group</a> </p>
                    
                  </div>
                </div>
              </li>
            </ul>
          </div>
            
            
            
          </div>
          
          </div>
       
         <jsp:include page="footer.jsp"/>
</body>
</html>