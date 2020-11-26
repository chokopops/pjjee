<%--
  Created by IntelliJ IDEA.
  User: etienne
  Date: 12/11/2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Detail</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/pagedetail.css">
        <link href="//db.onlinewebfonts.com/c/c38f2cc711985becf7550d75271b1175?family=Neo+Sans+Pro" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#"><img id="efreinavbar" src="/images/efrei.jpg"></a>
                    </li>
                </ul>
            </div>
            <div class="mx-auto order-0">
                <h3 class="navbar-brand mx-auto">Fiche des details</h3>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item" style="margin-right: 10px;">
                        <c:if test="${ !empty sessionScope.idtutor}">
                            <p style="color: white;">${ sessionScope.LastNameTutor } ${ sessionScope.FirstNameTutor }    </p>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <form name="LogOut" method="post" action="Logout">
                            <td><input type="submit" class="btn btn-danger" name="detail" value="Log Out"/></td>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <br>
            <!-- table which will display the student related information -->
            <c:forEach items="${listEtudiant}" var="Etudiant">
                <div class="container" id="containertableaux">
                    <div class="row">
                        <table class="table table-striped shadow p-3 mb-5 bg-white rounded">
                            <thead>
                                <tr>
                                    <th>Details du stagiaire</th>
                                </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Identifiant : ${Etudiant.getStudentInfo().getIdStudent()}</td>
                            </tr>
                            <tr>
                                <td>Nom : ${Etudiant.getStudentInfo().getLastname()}</td>
                            </tr>
                            <tr>
                                <td>Prénom : ${Etudiant.getStudentInfo().getFirstname()}</td>
                            </tr>
                            <tr>
                                <td>Groupe : ${Etudiant.getStudentInfo().getGroup()}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <table class="table table-striped shadow p-3 mb-5 bg-white rounded">
                            <thead>
                                <tr>
                                    <th>Details de l'Entreprise</th>
                                </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Nom : ${Etudiant.getStudentEnterprise().getNom()}</td>
                            </tr>
                            <tr>
                                <td>Adresse de l'entreprise : ${Etudiant.getStudentEnterprise().getAdresse()}</td>
                            </tr>
                            <tr>
                                <td>Maitre d'apprentissage : ${Etudiant.getStudentStage().getMds()}</td>
                            </tr>
                            <tr>
                                <td>Date de début : ${Etudiant.getStudentStage().getDebut()}</td>
                            </tr>
                            <tr>
                                <td>Date de fin : ${Etudiant.getStudentStage().getFin()}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <table class="table table-striped shadow p-3 mb-5 bg-white rounded">
                            <thead>
                                <tr>
                                    <th>Gestion du stage</th>
                                </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Description de la mission : ${Etudiant.getStudentStage().getDescriptionStage()}</td>
                            </tr>
                            <tr>
                                <td>Commentaire : ${Etudiant.getStudentStage().getCommentaire()} </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <center><a href="/Table"><button type="button" class="btn btn-primary">Return</button></a></center>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
