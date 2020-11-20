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
<form name="Recherche" method="post" action="TableSearch">
    <td><input type="text" name="search" /></td>
    <td><input type="submit" name="search" value="Search"/></td>
</form>
    <table>
        <tr>
            <td>Group</td>
            <td>Last Name</td>
            <td>Cdc</td>
            <td>Fiche visite</td>
            <td>Fiche eval</td>
            <td>Sondage</td>
            <td>Rapport</td>
            <td>Soutenance</td>
            <td>Plannif</td>
            <td>Faite</td>
            <td>Stage Date debut</td>
            <td>Stage Date fin</td>
            <td>Entreprise nom</td>
            <td>Maitre de stage</td>
            <td>Entreprise adresse</td>
            <td>Note technique</td>
            <td>Notet com</td>
        </tr>
        <c:set var="count" value="0" scope="session" />
        <c:forEach items="${listEtudiants}" var="aEtudiant">

                <tr>
                    <form name="TableFormIndex" method="post" action="Table">
                        <input type="hidden" name="id_student" value="${aEtudiant.getStudentInfo().getIdStudent()}" />
                    <td>${aEtudiant.getStudentInfo().getGroup()}</td><!-- String -->
                    <td>${aEtudiant.getStudentInfo().getLastname()}</td><!-- String -->
                    <td>
                        <input type="checkbox" id="cdc" name="cdc"
                        <c:if test="${aEtudiant.getStudentDoc().isCdc() == true }">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentDoc().isCdc() != true }">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="fiche_visite" name="fiche_visite"
                        <c:if test="${aEtudiant.getStudentVisite().isFicheVisite() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentVisite().isFicheVisite() != true}">
                               />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="fiche_eval" name="fiche_eval"
                        <c:if test="${aEtudiant.getStudentDoc().isFicheEval() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentDoc().isFicheEval() != true}">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="sondage" name="sondage"
                        <c:if test="${aEtudiant.getStudentDoc().isSondage() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentDoc().isSondage() != true}">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="rapport" name="rapport"
                        <c:if test="${aEtudiant.getStudentDoc().isRapport() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentDoc().isRapport() != true}">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="soutenance" name="soutenance"
                        <c:if test="${aEtudiant.getStudentDoc().isSoutenance() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentDoc().isSoutenance() != true}">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="plannif" name="plannif"
                        <c:if test="${aEtudiant.getStudentVisite().isPlannif() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentVisite().isPlannif() != true}">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="faite" name="faite"
                        <c:if test="${aEtudiant.getStudentVisite().isFaite() == true}">
                               checked/>
                        </c:if>
                        <c:if test="${aEtudiant.getStudentVisite().isFaite() != true}">
                            />
                        </c:if>
                    </td><!-- String -->
                    <td>${aEtudiant.getStudentStage().getDebut()}</td><!-- String -->
                    <td>${aEtudiant.getStudentStage().getFin()}</td><!-- String -->
                    <td>${aEtudiant.getStudentEnterprise().getNom()}</td><!-- String -->
                    <td>${aEtudiant.getStudentStage().getMds()}</td><!-- String -->
                    <td>${aEtudiant.getStudentEnterprise().getAdresse()}</td><!-- String -->
                    <td>${aEtudiant.getStudentStage().getNoteTech()}</td><!-- String -->
                    <td>${aEtudiant.getStudentStage().getNoteCom()}</td><!-- String -->
                    <td><input type="submit" name="submit" value="Valid Edit"/></td>
                        <c:set var="count" value="${count + 1}" scope="session"/>
                    </form>
                    <form name="TableFormIndex" method="post" action="Detail">
                        <input type="hidden" name="id_student" value="${aEtudiant.getStudentInfo().getIdStudent()}" />
                        <td><input type="submit" name="detail" value="Detail"/></td>
                    </form>
                </tr>


        </c:forEach>
    </table>

</body>
