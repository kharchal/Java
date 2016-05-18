
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
<html>
  <head>
    <title>Page Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>
  <form action="action" method="post">
    <input type="submit" name="command" value="Logout" class="btn btn-info">
  </form>

  Users quantity is ${userscount}:<br>
  <table border="1" class="table table-striped">
    <tr>
      <th>id</th>
      <th>login</th>
      <th>password</th>
      <th>name</th>
      <th>surname</th>
      <th>role</th>
      <th>command</th>
    </tr>
  <c:forEach var="v" items="${users}">
    <tr>
      <td>
        ${v.id}
      </td>
      <td>
        ${v.login}
      </td>
      <td>
        ${v.password}
      </td>
      <td>
        ${v.name}
      </td>
      <td>
        ${v.surname}
      </td>
      <td>
        ${v.role.role}
      </td>
      <td>
        <form action="action" method="post">
          <input type="submit" name="command" value="EditUser" class="btn btn-primary">
          <input type="submit" name="command" value="DeleteUser" class="btn btn-danger">
          <input type="hidden" name="id" value="${v.id}">
        </form>

      </td>
    </tr>
  </c:forEach>
  </table>
  <hr>

  Expressions quantity is: ${exprcount}<br>
  <table border="1" class="table table-striped">
    <tr>
      <th>ID</th>
      <th>Expression</th>
      <th>Result</th>
      <th>User login</th>
      <th>Timestamp</th>
    </tr>
    <c:forEach var="ex" items="${exprs}">
      <tr>
        <td>${ex.id}</td>
        <td>${ex.expression}</td>
        <td>${ex.result}</td>
        <td>${ex.user.login}</td>
        <td>${ex.timestamp}</td>
      </tr>
    </c:forEach>
  </table>

  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
