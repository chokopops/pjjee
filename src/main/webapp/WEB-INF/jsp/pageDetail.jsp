<%--
  Created by IntelliJ IDEA.
  User: etienne
  Date: 12/11/2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<c:if test="${ !empty sessionScope.idtutor}">
    <p>Id Tutor ${ sessionScope.idtutor } !</p>
</c:if>
<c:forEach items="${listEtudiant}" var="Etudiant">
    <div>
        <table>
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
    <div>
        <table>
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
    <div>
        <table>
            <tr>
                <td>Description de la mission : </td>
            </tr>
            <tr>
                <td>Commentaire : </td>
            </tr>
            <tr>
                <td>Remplir la fiche de visite : </td>
            </tr>
        </table>
    </div>
    <a href="/Table"><button class="return" type="button" >Return</button></a>
</c:forEach>
</body>
