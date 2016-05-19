<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mt" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">

        Please authorise yourself:<br>

        <c:if test="${msg ne null}">

            <div class="alert alert-danger fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Warning!</strong> ${msg}

            </div>
        </c:if>
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


    </div>
    <div class="col-sm-1"></div>
</div>

<mt:copyright name="HAV" year="2016"/>
</body>
</html>
