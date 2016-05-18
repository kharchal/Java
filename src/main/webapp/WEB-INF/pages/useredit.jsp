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

  Enter your personal data:<br>
  <p style="color:Red">${msg}</p>
  <form action="action" method="post">
    <table border="0">
      <tr>
        <td>
          <label>Id:</label>
        </td>
        <td>
          <input type="text" name="id" value="${user.id}" readonly>
        </td>
      </tr>
      <tr>
        <td>
          <label>Login:</label>
        </td>
        <td>
          <input type="text" name="login" value="${user.login}" readonly>
        </td>
      </tr>
      <tr>
        <td>
          <label>Password:</label>
        </td>
        <td>
          <input type="text" name="password" pattern="^[a-z0-9_-]{4,16}$" required value="${user.password}">
        </td>
      </tr>
      <tr>
        <td>
          <label>Name:</label>
        </td>
        <td>
          <input type="text" name="name" required value="${user.name}">
        </td>
      </tr>
      <tr>
        <td>
          <label>Surname:</label>
        </td>
        <td>
          <input type="text" name="surname" required value="${user.surname}">
        </td>
      </tr>
      <tr>
        <td>
          <label>Role:</label>
        </td>
        <td>
          <select name="role">
            <option value="admin">admin</option>
            <option value="user" selected>user</option>
          </select>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Update" class="btn btn-success">
        </td>
      </tr>
        <input type="hidden" name="command" value="UpdateUser">
    </table>
  </form>


  <mt:copyright name="HAV" year="2016"/>
  </body>
</html>
