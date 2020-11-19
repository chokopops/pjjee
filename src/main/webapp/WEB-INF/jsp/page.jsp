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
<table>
    <c:forEach items="${listEtudiants}" var="aEtudiant">
            <tr>
                <td>${aEtudiant.getStudentInfo().getGroup()}</td><!-- String -->
                <td>${aEtudiant.getStudentInfo().getLastname()}</td><!-- String -->
                <td>${aEtudiant.getStudentDoc().isCdc()}</td><!-- String -->
                <td>${aEtudiant.getStudentVisite().isFicheVisite()}</td><!-- String -->
                <td>${aEtudiant.getStudentDoc().isFicheEval()}</td><!-- String -->
                <td>${aEtudiant.getStudentDoc().isSondage()}</td><!-- String -->
                <td>${aEtudiant.getStudentDoc().isRapport()}</td><!-- String -->
                <td>${aEtudiant.getStudentDoc().isSoutenance()}</td><!-- String -->
                <td>${aEtudiant.getStudentVisite().isPlannif()}</td><!-- String -->
                <td>${aEtudiant.getStudentVisite().isFaite()}</td><!-- String -->
                <td>${aEtudiant.getStudentStage().getDebut()}</td><!-- String -->
                <td>${aEtudiant.getStudentStage().getFin()}</td><!-- String -->
                <td>${aEtudiant.getStudentEnterprise().getNom()}</td><!-- String -->
                <td>${aEtudiant.getStudentStage().getMds()}</td><!-- String -->
                <td>${aEtudiant.getStudentEnterprise().getAdresse()}</td><!-- String -->
                <td>${aEtudiant.getStudentStage().getNoteTech()}</td><!-- String -->
                <td>${aEtudiant.getStudentStage().getNoteCom()}</td><!-- String -->
            </tr>
    </c:forEach>
</table>
</body>
