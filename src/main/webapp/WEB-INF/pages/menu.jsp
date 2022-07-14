<html>
<head>

<%
String username = (String)session.getAttribute("username");
if(username==null){
	request.setAttribute("msg", "Please Login First");
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
}
%>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="homePage">Product</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="homePage">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <%
      String role = (String)session.getAttribute("role");
      if(role.equals("Admin")){
    	  %>
      <li class="nav-item">
        <a class="nav-link" href="addUserPage">Add User</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="importUserPage">Import User</a>
      </li>    	  
    	  <%
      }else{
    	  %>
        <li class="nav-item">
          <a class="nav-link" href="addProductPage">Add Product</a>
        </li>     	  
    	  <% 	  
      }
      %>
      

      <li class="nav-item">
        <a class="nav-link" href="listOfUser">List Of User</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listOfProduct">List Of Product</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="profile?username=<%= username%>"><%=username %></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="logout?username=<%= username %>&role=<%=role %>">Logout</a>
      </li>
    </ul>
  </div>
</nav>

</body>


</html>