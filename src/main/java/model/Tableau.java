package model;

import ctrl.DataServices;
import javafx.scene.control.Tab;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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


    public void CreateTab(int idtutor){

        conn = DataServices.connect(conn);

        try{
            Table = new ArrayList<LigneTable>();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT STUDENT.id_student, STUDENT.group_student, STUDENT.lastname_student, DOC.cdc, VISITE.fiche_visite, DOC.fiche_eval, DOC.sondage, DOC.rapport, DOC.soutenance, VISITE.plannif, VISITE.faite, STAGE.debut, STAGE.fin, ENTREPRISE.name_entreprise, STAGE.mds, ENTREPRISE.adresse, STAGE.note_tech, STAGE.note_com FROM STUDENT, DOC, ENTREPRISE, STAGE, VISITE WHERE STUDENT.ID_TUTOR = '"+idtutor+"' AND VISITE.ID_STUDENT = STUDENT.ID_STUDENT AND STAGE.ID_STUDENT = STUDENT.ID_STUDENT AND ENTREPRISE.ID_ENTREPRISE = STAGE.ID_ENTERPRISE AND DOC.ID_DOC = STUDENT.ID_DOC");
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

    public void editData(HttpServletRequest request){
        conn = DataServices.connect(conn);
        try{

            Boolean cdc = verifBool(request.getParameter("cdc"));
            Boolean fiche_visite = verifBool(request.getParameter("fiche_visite"));
            Boolean fiche_eval = verifBool(request.getParameter("fiche_eval"));
            Boolean sondage = verifBool(request.getParameter("sondage"));
            Boolean rapport = verifBool(request.getParameter("rapport"));
            Boolean soutenance = verifBool(request.getParameter("soutenance"));
            Boolean plannif = verifBool(request.getParameter("plannif"));
            Boolean faite = verifBool(request.getParameter("faite"));

            System.out.println(cdc);
            System.out.println(fiche_visite);
            System.out.println(fiche_eval);
            System.out.println(sondage);
            System.out.println(rapport);
            System.out.println(soutenance);
            System.out.println(plannif);
            System.out.println(faite);


            Statement stmt = conn.createStatement();

            stmt.executeUpdate("UPDATE DOC SET CDC = '"+ cdc +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+Integer.parseInt(request.getParameter("id_student"))+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc)");
            stmt.executeUpdate("UPDATE VISITE SET FICHE_VISITE = '"+ fiche_visite +"' WHERE ID_STUDENT ='"+Integer.parseInt(request.getParameter("id_student"))+"'");
            stmt.executeUpdate("UPDATE DOC SET FICHE_EVAL = '"+ fiche_eval +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+Integer.parseInt(request.getParameter("id_student"))+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc)");
            stmt.executeUpdate("UPDATE DOC SET SONDAGE = '"+ sondage +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+Integer.parseInt(request.getParameter("id_student"))+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc)");
            stmt.executeUpdate("UPDATE DOC SET RAPPORT = '"+ rapport +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+Integer.parseInt(request.getParameter("id_student"))+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc)");
            stmt.executeUpdate("UPDATE DOC SET SOUTENANCE = '"+ soutenance +"' WHERE ID_DOC = (SELECT STUDENT.id_doc FROM STUDENT, DOC WHERE '"+Integer.parseInt(request.getParameter("id_student"))+"' = STUDENT.id_student AND STUDENT.id_doc = DOC.id_doc)");
            stmt.executeUpdate("UPDATE VISITE SET PLANNIF = '"+ plannif +"' WHERE ID_STUDENT = '"+Integer.parseInt(request.getParameter("id_student"))+"'");
            stmt.executeUpdate("UPDATE VISITE SET FAITE = '"+ faite +"' WHERE ID_STUDENT = '"+Integer.parseInt(request.getParameter("id_student"))+"'");



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

    public Boolean verifBool(){
        return false;
    }

    public ArrayList<LigneTable> getTable(){
        return Table;
    }


}
