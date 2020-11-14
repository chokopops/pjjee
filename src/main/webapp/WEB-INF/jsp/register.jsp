<%--
  Created by IntelliJ IDEA.
  User: etienne
  Date: 11/11/2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<form name="loginFormIndex" method="post" action="Controller">


    <h1>Hello welcome, please register !</h1><br>
    <label> Login : </label> <input type="text" name="loginForm" required/><br/>
    <label> First name : </label> <input type="text" name="firstnameForm" required/><br/>
    <label> Last name : </label> <input type="text" name="lastnameForm" required/><br/>
    <label> Password : </label> <input type="password" name="passForm" required/> <br/>

    <input type="submit" name="submit" value="Submit"/>
</form>
<a href="/Login"><button class="Login" type="button" >Login</button></a>
</body>
</html>
