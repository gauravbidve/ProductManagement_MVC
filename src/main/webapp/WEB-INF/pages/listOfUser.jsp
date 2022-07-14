<jsp:include page="menu.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>List of Users</title>
</head>

<body>
  <h3 style="color:red;">${msg}</h3>
<table class="table table-striped table-dark table-bordered">
  <thead>
    <tr>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">Role</th>
      <th scope="col">Gender</th>
      <th scope="col">Question</th>
      <th scope="col">Answer</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${userList}" var="user">
      <tr>
        <td><c:out value="${user.username}"></c:out></td>
        <td><c:out value="${user.password}"></c:out></td>
        <td><c:out value="${user.role}"></c:out></td>
        <td><c:out value="${user.gender}"></c:out></td>
        <td><c:out value="${user.question}"></c:out></td>
        <td><c:out value="${user.answer}"></c:out></td>
        <td>
          <a href="profile?username=${user.username}">Edit</a> |
          <a href="deleteUser?username=${user.username}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>

</body>

</html>