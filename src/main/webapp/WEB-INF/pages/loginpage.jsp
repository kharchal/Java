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
  <form action="login" method="post" class="form-inline" role="form">
    <div class="form-group"></div>
    <div class="form-group">
      <label for="email">Login:</label>
      <input type="text" name="login" required class="form-control" id="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" name="password" required class="form-control" id="pwd">
    </div>


    <input type="submit" value="Login" name="command" class="btn btn-success">


  </form>


  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
