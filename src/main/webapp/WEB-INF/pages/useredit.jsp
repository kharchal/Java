<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 14.05.2016
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
<html>
  <head>
    <title>User Edit Page</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>

  <div class="row">
    <div class="col-sm-1"> </div>
    <div class="col-sm-10">

  Enter data to change:<br>
  <p style="color:Red">${msg}</p>
  <form action="action" method="post" role="form" class="form-horizontal">
    <div class="form-group">
      <label class="control-label col-sm-2" for="id">Login:</label>
      <div class="col-sm-8">
        <input id="id" class="form-control" type="text" name="id" required value="${user.id}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="login">Login:</label>
      <div class="col-sm-8">
        <input id="login" class="form-control" type="text" name="login" pattern="^[a-zA-Z]{1}[a-z0-9_-]{3,16}$"
               required value="${user.login}" title="4 to 16 chars(letters, digits, '-', '_'), starts with a letter">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password:</label>
      <div class="col-sm-8">
        <input id="password" class="form-control" type="password" name="password" pattern="^[a-z0-9_-]{4,16}$"
               required value="${user.password}" title="4 to 16 chars(letters, digits, '-', '_')">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Name:</label>
      <div class="col-sm-8">
        <input id="name" class="form-control" type="text" name="name" required value="${user.name}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="surname">Surname:</label>
      <div class="col-sm-8">
        <input id="surname" class="form-control" type="text" name="surname" required value="${user.surname}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="role">Role:</label>
      <div class="col-sm-8">

          <select class="form-control" name="role" id="role">
            <option value="admin">admin</option>
            <option value="user" selected>user</option>
          </select>
      </div>
    </div>
          <input type="submit" value="Update" class="btn btn-success">

        <input type="hidden" name="command" value="UpdateUser">

  </form>


    </div>
    <div class="col-sm-1"> </div>
  </div>

  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
