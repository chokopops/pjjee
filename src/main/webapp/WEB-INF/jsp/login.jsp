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
</head>
<body>
    <form name="loginFormIndex" method="post" action="Controller">
        <h1>Hello welcome, please sign in !</h1><br>

        <label> Login : </label> <input type="text" name="loginForm"/><br/>
        <label> Password : </label> <input type="text" name="passForm"/> <br/>

        <input type="submit" name="submit" value="Submit"/>
    </form>
</body>
</html>
