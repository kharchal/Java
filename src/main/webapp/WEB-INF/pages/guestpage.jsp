<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Guest Page Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>
  Welcome ${loggeduser.name}!
  You can enter your expression here:
  <p style="color:Red">${msg}</p>

        <form action="action" method="post">
          <input type="text" name="expr">
          <input type="submit" name="command" value="Evaluate" class="btn btn-success">
          <input type="submit" name="command" value="Logout" class="btn btn-info">
        </form>
<hr>
  Your prevoius expressions are:<br>
  <table border="1" class="table table-striped">
    <tr>
      <th>ID</th>
      <th>Expression</th>
      <th>Result</th>
      <th>Evaluated</th>
    </tr>
  <c:forEach var="ex" items="${exprs}">
    <tr>
      <td>${ex.id}</td>
      <td>${ex.expression}</td>
      <td>${ex.result}</td>
      <td>${ex.timestamp}</td>
    </tr>
  </c:forEach>
    </table>
  <%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
