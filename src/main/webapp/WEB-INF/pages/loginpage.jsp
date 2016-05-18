<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
<html>
  <head>
    <title>Login Page</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>

  Please authorise yourself:<br>
  <p style="color:Red">${msg}</p>
  <form action="login" method="post">
    <table border="0">
      <tr>
        <td>
          <label>Login:</label>
        </td>
        <td>
          <input type="text" name="login" required>
        </td>
      </tr>
      <tr>
        <td>
          <label>Password:</label>
        </td>
        <td>
          <input type="password" name="password" required>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Login" name="command" class="btn btn-success">
        </td>
      </tr>
    </table>
  </form>


  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
