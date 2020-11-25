<%--
  Created by IntelliJ IDEA.
  User: etienne
  Date: 12/11/2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
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
<c:if test="${ !empty sessionScope.idtutor}">
    <p>Id Tutor ${ sessionScope.idtutor } !</p>
</c:if>
<form name="LogOut" method="post" action="Logout">
    <td><input type="submit" name="detail" value="Log Out"/></td>
</form>

<c:forEach items="${listEtudiant}" var="Etudiant">

    <div class="container">
        <div class="contain">
            <div class="row">
                <div class="col-md-12">
                    <h1>Fiche des details</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <h2>Details du stagiaire</h2>
                    <table class="table">
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
                            <td>Prénom : ${Etudiant.getStudentInfo().getGroup()}</td>
                        </tr>
                    </table>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-7">
                    <h2>Details de l'Entreprise</h2>
                    <table class="table">
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
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    <h2>Gestion du stage</h2>
                    <table class="table">
                        <tr>
                            <td>Description de la mission : ${Etudiant.getStudentStage().getDescriptionStage()}</td>
                        </tr>
                        <tr>
                            <td>Commentaire : ${Etudiant.getStudentStage().getCommentaire()} </td>
                        </tr>
                    </table>


                </div>
                <div class="col-md-3"></div>
                <div class="col-md-12">
                    <div class="center">
                        <a href="/Table"><button type="button" class="btn btn-primary" >Return</button> </a>
                    </div>
                </div>
        </div>
    </div>
</c:forEach>
</body>
