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
<c:if test="${!empty loginFormIndex.resultat}"><p> <c:out value="${loginFormIndex.resultat}"/></p></c:if>
<c:if test="${ !empty sessionScope.login }">
    <p>login : ${ sessionScope.login }!</p>
</c:if>
<c:out value="${ login }" />
<c:out value="${ profile }" />

    <form name="loginFormIndex" method="post" action="Login">

        <h1>Hello welcome, please sign in !</h1><br>

        <label> Login : </label> <input type="text" name="loginForm" required/><br/>
        <label> Password : </label> <input type="password" name="passForm" required/> <br/>

        <input type="submit" name="submit" value="Submit"/>
    </form>
<a href="/pjjee_war/Controller"><button class="Register" type="button" >Register</button></a>
</body>
</html>
