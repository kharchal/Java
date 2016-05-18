<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
<html>
  <head>
    <title>Page Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>

  Make your choice:
    <form method="post" action="login">
      <input type="submit" value="Register" class="btn btn-primary btn-md">
      <input type="hidden" name="command" value="ShowRegPage">
    </form>
  <form method="post" action="login">
    <input type="submit" value="Login" class="btn btn-success btn-md">
    <input type="hidden" name="command" value="ShowLoginPage">
  </form>

  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
