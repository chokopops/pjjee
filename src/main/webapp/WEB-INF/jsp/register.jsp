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
<c:if test="${!empty loginFormIndex.resultat}"><p> <c:out value="${loginFormIndex.resultat}"/></p></c:if>
<form name="loginFormIndex" method="post" action="Controller">
    <p>Select your profile:</p>

    <div>
        <input type="radio" id="tutor" name="profile" value="tutor">
        <label for="tutor">Tutor</label>
    </div>
    <div>
        <input type="radio" id="student" name="profile" value="student" checked>
        <label for="student">Student</label>
    </div>
    <div>
        <input type="radio" id="admin" name="profile" value="admin">
        <label for="admin">Admin</label>
    </div>

    <h1>Hello welcome, please register !</h1><br>
    <label> Email : </label> <input type="text" name="emailForm" required/><br/>
    <label> First name : </label> <input type="text" name="firstnameForm" required/><br/>
    <label> Last name : </label> <input type="text" name="lastnameForm" required/><br/>
    <label> Password : </label> <input type="password" name="passForm" required/> <br/>

    <input type="submit" name="submit" value="Submit"/>
</form>
</body>
</html>
