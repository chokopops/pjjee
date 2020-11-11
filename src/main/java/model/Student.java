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

    public void setAccount(HttpServletRequest request){
        resultat = null;
        conn = DataServices.connect(conn);
        email = request.getParameter("emailForm");

        if (!verifEmail(email, conn)){//If we don't have already the mail
            firstname = request.getParameter("firstnameForm");
            lastname = request.getParameter("lastnameForm");
            pwd = request.getParameter("passForm");

            try{
                String query = " insert into STUDENT (EMAIL, FIRSTNAME_STUDENT, LASTNAME_STUDENT, PASSWORD_STUDENT) values ('"+email+"','"+firstname+"', '"+lastname+"', '"+pwd+"')";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                resultat = registerSuccess;
            }
            catch (Exception e){
                System.out.println(e);
                resultat = registerFail;
            }
        }
        else{
            resultat = registerFailEmail;
        }




    }

    public void verifAccount(HttpServletRequest request){
        resultat = null;
        conn = DataServices.connect(conn);

        pwd = request.getParameter("passForm");
        email = request.getParameter("emailForm");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT EMAIL, PASSWORD_STUDENT, FIRSTNAME_STUDENT, LASTNAME_STUDENT FROM STUDENT WHERE EMAIL='"+email+"'");
            while ( rs.next() ) {
                if ((rs.getString("PASSWORD_STUDENT")).equals(pwd)){
                    resultat = loginSuccess;
                    firstname = rs.getString("FIRSTNAME_STUDENT");
                    lastname = rs.getString("LASTNAME_STUDENT");
                    System.out.println("log et mail good");
                }
            }
            if (resultat!= loginSuccess){
                resultat = loginFail;
            }

        }
        catch (Exception e){
            System.out.println(e);
            resultat = loginFail;
        }



    }

    public boolean verifEmail(String email, Connection con){

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT EMAIL FROM STUDENT WHERE EMAIL='"+email+"'");
            while ( rs.next() ) {
                if ((rs.getString("EMAIL")).equals(email)){
                    return true;
                }
            }

        }
        catch (Exception e){
            System.out.println(e);
            resultat = registerFail;
        }
        return false;
    }

    public String getResultat(){
        return resultat;
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
