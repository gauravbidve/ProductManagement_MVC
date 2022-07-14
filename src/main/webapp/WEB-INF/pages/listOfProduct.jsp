
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
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Price</th>
      <th scope="col">Product Expiry Date</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${products}" var="product">
      <tr>
        <td><c:out value="${product.productId}"></c:out></td>
        <td><c:out value="${product.productName}"></c:out></td>
        <td><c:out value="${product.productPrice}"></c:out></td>
        <td><c:out value="${product.productExpiryDate}"></c:out></td>
        <td>
          <a href="editProduct?productId=${product.productId}">Edit</a> |
          <a href="deleteProduct?productId=${product.productId}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>

</body>

</html>