<%--
  Created by IntelliJ IDEA.
  User: etienne
  Date: 12/11/2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Main page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/mainPage.css">
        <link href="//db.onlinewebfonts.com/c/c38f2cc711985becf7550d75271b1175?family=Neo+Sans+Pro" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" id="navbar">
            <div class="p-2 mr-auto">
                <img src="/images/efrei.jpg">
            </div>
            <div class="p-2">
                <c:if test="${ !empty sessionScope.idtutor}">
                    <p>Id Tutor ${ sessionScope.idtutor } !</p>
                </c:if>
            </div>
            <div class="p-2">
                <form name="LogOut" method="post" action="Logout">
                    <td><input type="submit" class="btn btn-danger" name="detail" value="Log Out"/></td>
                </form>
            </div>
        </nav>
        <div class="container-fluid">
            <center>
                <form id="searchForm" name="Recherche" method="post" action="TableSearch">
                    <td><input type="text" name="search"/></td>
                    <td><input type="submit" name="search" value="Search"/></td>
                </form>
            </center>
            <center>
                <div class="table-responsive shadow p-3 mb-5 bg-white rounded" id="studentTable">
                    <table class="table table-striped">
                        <tr>
                            <td>Groupe</td>
                            <td>Nom</td>
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
                                <form name="TableFormIndex" size="2" method="post" action="Table">
                                    <input type="hidden" size="2" name="id_student" value="${aEtudiant.getStudentInfo().getIdStudent()}" />
                                <td><input class="input-group-text" type="text" size="3" name="GroupStudent" value="${aEtudiant.getStudentInfo().getGroup()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="3" name="LastNameStudent" value="${aEtudiant.getStudentInfo().getLastname()}" /></td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentDoc().isCdc() == true }">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentDoc().isCdc() != true }">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentVisite().isFicheVisite() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentVisite().isFicheVisite() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentDoc().isFicheEval() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentDoc().isFicheEval() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentDoc().isSondage() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentDoc().isSondage() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentDoc().isRapport() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentDoc().isRapport() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentDoc().isSoutenance() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentDoc().isSoutenance() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentVisite().isPlannif() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentVisite().isPlannif() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input"
                                        <c:if test="${aEtudiant.getStudentVisite().isFaite() == true}">
                                               checked/>
                                        </c:if>
                                        <c:if test="${aEtudiant.getStudentVisite().isFaite() != true}">
                                            />
                                        </c:if>
                                        <span class="custom-control-indicator"></span>
                                    </label>
                                </td><!-- String -->
                                <td><input class="input-group-text" type="text" size="9" name="Debut" value="${aEtudiant.getStudentStage().getDebut()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="9" name="Fin" value="${aEtudiant.getStudentStage().getFin()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="10" name="NomEntreprise" value="${aEtudiant.getStudentEnterprise().getNom()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="10" name="Mds" value="${aEtudiant.getStudentStage().getMds()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="12" name="AdresseEntreprise" value="${aEtudiant.getStudentEnterprise().getAdresse()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="2" name="NoteTech" value="${aEtudiant.getStudentStage().getNoteTech()}" /></td><!-- String -->
                                <td><input class="input-group-text" type="text" size="2" name="NoteCom" value="${aEtudiant.getStudentStage().getNoteCom()}" /></td><!-- String -->
                                <td><input type="submit" size="25" class="btn btn-primary" name="submit" value="Valid Edit"/></td>
                                    <c:set var="count" value="${count + 1}" scope="session"/>
                                </form>
                                <form name="TableFormIndex" method="post" action="Detail">
                                    <input type="hidden" name="id_student" value="${aEtudiant.getStudentInfo().getIdStudent()}" />
                                    <td><input type="submit" class="btn btn-primary" name="detail" value="Detail"/></td>
                                </form>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </center>
        </div>
    </body>
</html>