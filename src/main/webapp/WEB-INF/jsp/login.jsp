<%--
  Created by IntelliJ IDEA.
  User: nicol
  Date: 23/10/2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<!-- header contains every data we need to use the framework bootstrap -->
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/login.css">
    <link href="//db.onlinewebfonts.com/c/c38f2cc711985becf7550d75271b1175?family=Neo+Sans+Pro" rel="stylesheet" type="text/css"/>
</head>
<body>
    <!-- we use a ontainer to size the page and control our positionning -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12" style="padding: 0px; margin: 0px; margin-bottom: -16px;">
                <!-- display an alert when you failed your log and automatically close after 2 seconds -->
                <c:if test="${Log==false}">
                    <div class="alert alert-danger" id="success-alert">
                        Failed to connect. Please try again.
                    </div>
                </c:if>
                <c:if test="${Log==true}"><c:out value="You are log"></c:out> </c:if>
            </div>
        </div>
        <div class="row" id="rowlogin">
            <div class="col-3"></div>
            <div class="col-6">
                <form name="loginFormIndex" method="post" class="shadow" id="form_container" action="Login">
                    <div class="form-row" id="authentification_title">
                        <div class="form-group col-md-4">
                            <img src="/images/efrei.jpg">
                        </div>
                        <div class="form-group col-md-2">
                            <h2>Authentification</h2>
                        </div>
                        <div class="col-md-6"></div>
                    </div>
                    <div class="form-group">
                        <label> Login : </label>
                        <!-- if nothing was entered, the field will appear empty -->
                        <c:if test="${log==null}"><input type="text" class="form-control" name="loginForm" placeholder="Enter your login" required/></c:if>
                        <!-- if something was entered in the field, it will be displayed again -->
                        <c:if test="${log!=null}"><input type="text" class="form-control" name="loginForm" value="${log}" required/></c:if>
                    </div>
                    <div class="form-group">
                        <label> Password : </label>
                        <input type="password" class="form-control" name="passForm" placeholder="Enter your password" required/>
                    </div>
                    <div class="form-group">
                        <center><input type="submit" name="submit" class="btn btn-primary" id="btn_submit" value="Submit"/></center>
                    </div>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>

<!-- script for the alert slide up -->

<script>
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
        $("#success-alert").slideUp(500);
    });
</script>

