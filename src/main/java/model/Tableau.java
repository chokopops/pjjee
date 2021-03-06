package model;

import ctrl.DataServices;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static utils.Constant.*;

public class Tableau {
    private ArrayList<LigneTable> Table;

    private LigneTable ligneTable;

    private Doc StudentDoc;
    private Entreprise StudentEnterprise;
    private Stage StudentStage;
    private Student StudentInfo;
    private Tutor StudentTutor;
    private Visite StudentVisite;

    public Tableau(int idtutor)
    {
        CreateTab(idtutor);
    }
    public Tableau(int idtutor, int id_student)
    {
        CreateTabDetail(idtutor, id_student);
    }

    //create an arrayList to store data needed to be displayed inside of the main page table

    public void CreateTab(int id_tutor){

        conn = DataServices.connect(conn);

        try{
            Table = new ArrayList<LigneTable>();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT STUDENT.id_student, STUDENT.group_student, STUDENT.lastname_student, DOC.cdc, VISITE.fiche_visite, DOC.fiche_eval, DOC.sondage, DOC.rapport, DOC.soutenance, VISITE.plannif, VISITE.faite, STAGE.debut, STAGE.fin, ENTREPRISE.name_entreprise, STAGE.mds, ENTREPRISE.adresse, STAGE.note_tech, STAGE.note_com FROM STUDENT, DOC, ENTREPRISE, STAGE, VISITE WHERE STUDENT.ID_TUTOR = '"+id_tutor+"' AND VISITE.ID_STUDENT = STUDENT.ID_STUDENT AND STAGE.ID_STUDENT = STUDENT.ID_STUDENT AND ENTREPRISE.ID_ENTREPRISE = STAGE.ID_ENTERPRISE AND DOC.ID_DOC = STUDENT.ID_DOC");
            while ( rs.next() ) {

                StudentInfo = new Student();
                StudentDoc = new Doc();
                StudentEnterprise = new Entreprise();
                StudentStage = new Stage();
                StudentVisite = new Visite();
                StudentInfo.setIdStudent(rs.getInt("STUDENT.ID_student"));
                StudentInfo.setGroup(rs.getString("STUDENT.group_student"));
                StudentInfo.setLastname(rs.getString("STUDENT.lastname_student"));
                StudentDoc.setCdc(rs.getBoolean("DOC.cdc"));
                StudentVisite.setFicheVisite(rs.getBoolean("VISITE.fiche_visite"));
                StudentDoc.setFicheEval(rs.getBoolean("DOC.fiche_eval"));
                StudentDoc.setSondage(rs.getBoolean("DOC.sondage"));
                StudentDoc.setRapport(rs.getBoolean("DOC.rapport"));
                StudentDoc.setSoutenance(rs.getBoolean("DOC.soutenance"));
                StudentVisite.setPlannif(rs.getBoolean("VISITE.plannif"));
                StudentVisite.setFaite(rs.getBoolean("VISITE.faite"));
                StudentStage.setDebut(rs.getDate("STAGE.debut"));
                StudentStage.setFin(rs.getDate("STAGE.fin"));
                StudentEnterprise.setNom(rs.getString("ENTREPRISE.name_entreprise"));
                StudentStage.setMds(rs.getString("STAGE.mds"));
                StudentEnterprise.setAdresse(rs.getString("ENTREPRISE.adresse"));
                StudentStage.setNoteTech(rs.getInt("STAGE.note_tech"));
                StudentStage.setNoteCom(rs.getInt("STAGE.note_com"));

                ligneTable = new LigneTable(StudentDoc,StudentEnterprise,StudentStage,StudentInfo,StudentTutor,StudentVisite);

                Table.add(ligneTable);

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void editData(HttpServletRequest request, int id_tutor, int id_student){
        conn = DataServices.connect(conn);
        try{
            //getting the date data in a particular format

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = format.parse(request.getParameter("Debut"));
            Date parsed2 = format.parse(request.getParameter("Fin"));

            java.sql.Date Debut = new java.sql.Date(parsed.getTime());
            java.sql.Date Fin = new java.sql.Date(parsed2.getTime());

            System.out.println(request.getParameter("Debut"));
            System.out.println();

            //getting the data concerning the choosen student

            Boolean cdc = verifBool(request.getParameter("cdc"));
            Boolean fiche_visite = verifBool(request.getParameter("fiche_visite"));
            Boolean fiche_eval = verifBool(request.getParameter("fiche_eval"));
            Boolean sondage = verifBool(request.getParameter("sondage"));
            Boolean rapport = verifBool(request.getParameter("rapport"));
            Boolean soutenance = verifBool(request.getParameter("soutenance"));
            Boolean plannif = verifBool(request.getParameter("plannif"));
            Boolean faite = verifBool(request.getParameter("faite"));

            String LastNameStudent = request.getParameter("LastNameStudent");
            String AdresseEntreprise = request.getParameter("AdresseEntreprise");
            String Mds = request.getParameter("Mds");
            String NomEntreprise = request.getParameter("NomEntreprise");
            String GroupStudent = request.getParameter("GroupStudent");

            int NoteTech = Integer.parseInt(request.getParameter("NoteTech"));
            int NoteCom = Integer.parseInt(request.getParameter("NoteCom"));

            //Date Debut = df.parse(request.getParameter("Debut"));
            //Date Fin = df.parse(request.getParameter("Fin"));

            System.out.println(cdc);
            System.out.println(fiche_visite);
            System.out.println(fiche_eval);
            System.out.println(sondage);
            System.out.println(rapport);
            System.out.println(soutenance);
            System.out.println(plannif);
            System.out.println(faite);

            // now we'll update the data stored in the database considering the changes which were done in the table

            Statement stmt = conn.createStatement();

            stmt.executeUpdate("UPDATE DOC SET CDC = '"+ cdc +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+id_student+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE VISITE SET FICHE_VISITE = '"+ fiche_visite +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT, VISITE WHERE '"+id_student+"' = VISITE.id_student AND VISITE.id_student = STUDENT.id_student AND STUDENT.id_tutor = '"+id_tutor+"' )");
            stmt.executeUpdate("UPDATE DOC SET FICHE_EVAL = '"+ fiche_eval +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+id_student+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE DOC SET SONDAGE = '"+ sondage +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+id_student+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE DOC SET RAPPORT = '"+ rapport +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+id_student+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE DOC SET SOUTENANCE = '"+ soutenance +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+id_student+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE VISITE SET PLANNIF = '"+ plannif +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT, VISITE WHERE '"+id_student+"' = VISITE.id_student AND VISITE.id_student = STUDENT.id_student AND STUDENT.id_tutor = '"+id_tutor+"' )");
            stmt.executeUpdate("UPDATE VISITE SET FAITE = '"+ faite +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT, VISITE WHERE '"+id_student+"' = VISITE.id_student AND VISITE.id_student = STUDENT.id_student AND STUDENT.id_tutor = '"+id_tutor+"' )");

            stmt.executeUpdate("UPDATE STUDENT SET LASTNAME_STUDENT = '"+ LastNameStudent +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"') ");
            stmt.executeUpdate("UPDATE STUDENT SET GROUP_STUDENT = '"+ GroupStudent +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE ENTREPRISE SET NAME_ENTREPRISE = '"+ NomEntreprise +"' WHERE ID_ENTREPRISE = (SELECT ENTREPRISE.id_entreprise FROM ENTREPRISE, STAGE, STUDENT WHERE STAGE.id_student = '"+id_student+"' AND STAGE.id_enterprise = ENTREPRISE.id_entreprise AND STAGE.id_student = STUDENT.id_student AND STUDENT.id_tutor = '"+id_tutor+"' )");
            stmt.executeUpdate("UPDATE ENTREPRISE SET ADRESSE = '"+ AdresseEntreprise +"' WHERE ID_ENTREPRISE = (SELECT ENTREPRISE.id_entreprise FROM ENTREPRISE, STAGE, STUDENT WHERE STAGE.id_student = '"+id_student+"' AND STAGE.id_enterprise = ENTREPRISE.id_entreprise AND STAGE.id_student = STUDENT.id_student AND STUDENT.id_tutor = '"+id_tutor+"' )");
            stmt.executeUpdate("UPDATE STAGE SET MDS = '"+ Mds +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"') ");
            stmt.executeUpdate("UPDATE STAGE SET NOTE_TECH = '"+ NoteTech +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE STAGE SET NOTE_COM = '"+ NoteCom +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE STAGE SET DEBUT = '"+ Debut +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"')");
            stmt.executeUpdate("UPDATE STAGE SET FIN = '"+ Fin +"' WHERE ID_STUDENT = (SELECT STUDENT.id_student FROM STUDENT WHERE STUDENT.id_student = '"+id_student+"' AND STUDENT.id_tutor = '"+id_tutor+"')");

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public Boolean verifBool(String bool){
        if (bool == null){
            return false;
        }
        else if(bool.equals("on")){
            return true;
        }
        else if (bool.equals("true")){
            return true;
        }
        else{
            return false;
        }
    }

    // creation of the table used for the detail page

    public void CreateTabDetail(int id_tutor, int id_student){
        conn = DataServices.connect(conn);

        try{
            Table = new ArrayList<LigneTable>();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT STAGE.description_mission, STAGE.commentaire, STUDENT.id_student, STUDENT.group_student, STUDENT.lastname_student, STUDENT.firstname_student, ENTREPRISE.name_entreprise, ENTREPRISE.adresse, STAGE.mds, STAGE.debut, STAGE.fin FROM STUDENT, ENTREPRISE, STAGE WHERE STUDENT.ID_TUTOR = '"+id_tutor+"' AND STAGE.ID_STUDENT = STUDENT.ID_STUDENT AND ENTREPRISE.ID_ENTREPRISE = STAGE.ID_ENTERPRISE AND STUDENT.id_student = '"+ id_student +"'");
            while ( rs.next() ) {

                StudentInfo = new Student();
                StudentDoc = new Doc();
                StudentEnterprise = new Entreprise();
                StudentStage = new Stage();
                StudentVisite = new Visite();
                StudentStage.setDescriptionStage(rs.getString("STAGE.description_mission"));
                StudentStage.setCommentaire(rs.getString("STAGE.commentaire"));
                StudentInfo.setIdStudent(rs.getInt("STUDENT.ID_student"));
                StudentInfo.setGroup(rs.getString("STUDENT.group_student"));
                StudentInfo.setLastname(rs.getString("STUDENT.lastname_student"));
                StudentInfo.setFirstname(rs.getString("STUDENT.firstname_student"));
                StudentEnterprise.setNom(rs.getString("ENTREPRISE.name_entreprise"));
                StudentEnterprise.setAdresse(rs.getString("ENTREPRISE.adresse"));
                StudentStage.setMds(rs.getString("STAGE.mds"));
                StudentStage.setDebut(rs.getDate("STAGE.debut"));
                StudentStage.setFin(rs.getDate("STAGE.fin"));

                ligneTable = new LigneTable(StudentDoc,StudentEnterprise,StudentStage,StudentInfo,StudentTutor,StudentVisite);

                Table.add(ligneTable);

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public ArrayList<LigneTable> getTable(){
        return Table;
    }

}
