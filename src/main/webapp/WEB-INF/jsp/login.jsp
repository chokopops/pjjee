<%--
  Created by IntelliJ IDEA.
  User: nicol
  Date: 23/10/2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div class="row" id="rowlogin">
    <div class="col-3"></div>
    <div class="col-6">
        <div id="authentification_title">
            <h1>Authentification</h1>
            <br>
        </div>
        <form name="loginFormIndex" method="post" id="form_container" action="Login">
            <div class="form-group">
                <label> Login : </label> <input type="text" name="loginForm" required/><br/>
            </div>
            <div class="form-group">
                <label> Password : </label> <input type="password" name="passForm" required/> <br/>
            </div>
            <input type="submit" name="submit" value="Submit"/>
        </form>
        <a href="/Controller"><button type="button" class="btn" >Register</button></a>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>
