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
    //private final int idStudent;
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
       /* this.idStudent = idStudent;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
        this.email = email;
        this.pwd = pwd;
        this.idTutor = tutor;
        this.idDoc = doc;*/
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

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //public int getIdStudent() { return idStudent; }

    public int getIdTutor() { return idTutor; }
    public void setIdTutor(int idTutor) { this.idTutor = idTutor; }

    public int getIdDoc() { return idDoc; }
    public void setIdDoc(int idDoc) { this.idDoc = idDoc; }


}
