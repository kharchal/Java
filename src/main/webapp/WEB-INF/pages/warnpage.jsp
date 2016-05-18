<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
      
<html>

<head>
<link rel="stylesheet" type="text/css" href="util/style.css" >
<meta charset="UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Warning Page</title>
</head>
<body>



<p style="color: red">"Sorry, something went wrong..."</p>


<form action="action" method="post">
   <input type="submit" value="To Login" name="command" class="btn btn-info">
</form>
<mt:copyright name="HAV" year="2016"/>
</body>
</html>