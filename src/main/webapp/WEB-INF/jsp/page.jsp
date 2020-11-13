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
<table>
    <c:forEach items="${listEtudiants}" var="aEtudiant">
        <tr>
            <td>${aEtudiant.getStudentInfo.getGroupe()}</td><!-- String -->
            <td>${aEtudiant.getNom()}</td><!-- String -->
            <td>${aEtudiant.getCahierDesChargesFait()}</td><!-- Bool -->
            <td>${aEtudiant.getFicheVisiteFait()}</td><!-- Bool -->
            <td>${aEtudiant.getFicheEvalEntretienFait()}</td><!-- Bool -->
            <td>${aEtudiant.getSondageWebFait()}</td><!-- Bool -->
            <td>${aEtudiant.getRapportRenduFait()}</td><!-- Bool -->
            <td>${aEtudiant.getSoutienFait()}</td><!-- Bool -->
            <td>${aEtudiant.getVisitePlanifieFait()}</td><!-- Bool -->
            <td>${aEtudiant.getVisiteFaite()}</td><!-- Bool -->
            <td>${aEtudiant.getDateDebutStage()}</td><!-- Date -->
            <td>${aEtudiant.getDateFinStage()}</td><!-- Date -->
            <td>${aEtudiant.getEntrepriseDeStage()}</td><!-- String -->
            <td>${aEtudiant.getMaitreDeStage()}</td>v
            <td>${aEtudiant.getAdresseEntrepriseStage()}</td><!-- String -->
            <td>${aEtudiant.getNoteTechniqueStage()}</td><!-- int -->
            <td>${aEtudiant.getNoteComStage()}</td><!-- int -->

        </tr>
    </c:forEach>
</table>
</body>
