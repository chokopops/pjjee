package model;

import ctrl.DataServices;
import static utils.Constant.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student
{
    private int idStudent;
    private String firstname;
    private String lastname;
    private String group;
    private String email;
    private String pwd;
    private int idTutor;
    private int idDoc;
    private String resultat;

    public Student()
    {
    }




    public void setIdStudent(int idStudent){
        this.idStudent = idStudent;
    }
    public int getIdStudent(){
        return idStudent;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }


    //public int getIdStudent() { return idStudent; }

    public int getIdTutor() { return idTutor; }
    public void setIdTutor(int idTutor) { this.idTutor = idTutor; }

    public int getIdDoc() { return idDoc; }
    public void setIdDoc(int idDoc) { this.idDoc = idDoc; }


}
