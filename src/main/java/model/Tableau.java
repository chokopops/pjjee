package model;

import ctrl.DataServices;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static utils.Constant.*;
import static utils.Constant.loginFail;

public class Tableau {
    private ArrayList<Integer> AllTutor;

    private Doc StudentDoc;
    private Entreprise StudentEnterprise;
    private Stage StudentStage;
    private Student StudentInfo;
    private Tutor StudentTutor;
    private Visite StudentVisite;

    public Tableau()
    {

        CreateTab();
/*
        this.StudentDoc = studentDoc;
        this.StudentEnterprise = studentEnterprise;
        this.StudentStage = studentStage;
        this.StudentInfo = studentInfo;
        this.StudentTutor = studentTutor;
        this.StudentVisite = studentVisite;
*/
    }


    public void CreateTab(){
        AllTutor = new ArrayList<Integer>();
        selectAllTutor();//Call methode which give us all tutors
        for (int i = 0; i < AllTutor.size(); i++) {
            System.out.println(AllTutor.get(i));
            selectStudentInfo(AllTutor.get(i));
        }

    }

    public void selectAllTutor(){

        conn = DataServices.connect(conn);

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT ID_TUTOR FROM TUTOR ");
            while ( rs.next() ) {//Selection of all tutors
                AllTutor.add(rs.getInt("ID_TUTOR"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void selectStudentInfo(int Tutor){

        conn = DataServices.connect(conn);

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT FIRSTNAME_STUDENT  FROM STUDENT WHERE ID_TUTOR='"+Tutor+"'");
            while ( rs.next() ) {

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Doc getStudentDoc(){ return StudentDoc;}
    public void setStudentDoc(Doc studentDoc){ this.StudentDoc = studentDoc;}

    public Entreprise getStudentEnterprise() {
        return StudentEnterprise;
    }

    public void setStudentEnterprise(Entreprise studentEnterprise) {
        StudentEnterprise = studentEnterprise;
    }

    public Stage getStudentStage() {
        return StudentStage;
    }

    public void setStudentStage(Stage studentStage) {
        StudentStage = studentStage;
    }

    public Student getStudentInfo() {
        return StudentInfo;
    }

    public void setStudentInfo(Student studentInfo) {
        StudentInfo = studentInfo;
    }

    public Tutor getStudentTutor() {
        return StudentTutor;
    }

    public void setStudentTutor(Tutor studentTutor) {
        StudentTutor = studentTutor;
    }

    public Visite getStudentVisite() {
        return StudentVisite;
    }

    public void setStudentVisite(Visite studentVisite) {
        StudentVisite = studentVisite;
    }
}
