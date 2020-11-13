package model;

import ctrl.DataServices;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static utils.Constant.*;
import static utils.Constant.registerFailEmail;

public class Tutor
{
   // private final int idTutor;
    private String login;
    private String pwd;
    private String firstName;
    private String lastName;
    private static int compteurId;
    private String resultat;

    public Tutor(){
       /* this.idTutor = compteurId;
        this.email = email;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        compteurId++;*/
    }

    public void setAccount(HttpServletRequest request){
        resultat = null;
        conn = DataServices.connect(conn);
        login = request.getParameter("loginForm");

        if (!verifLogin(login, conn)){//If we don't have already the mail
            firstName = request.getParameter("firstnameForm");
            lastName = request.getParameter("lastnameForm");
            pwd = request.getParameter("passForm");

            try{
                String query = " insert into TUTOR (LOGIN_PROF, FIRSTNAME_PROF, LASTNAME_PROF, PWD_PROF) values ('"+login+"','"+firstName+"', '"+lastName+"', '"+pwd+"')";
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
        login = request.getParameter("loginForm");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("conn good");
            rs = stmt.executeQuery("SELECT LOGIN_PROF, PWD_PROF, FIRSTNAME_PROF, LASTNAME_PROF FROM TUTOR WHERE LOGIN_PROF='"+login+"'");
            while ( rs.next() ) {
                if ((rs.getString("PWD_PROF")).equals(pwd)){
                    resultat = loginSuccess;
                    firstName = rs.getString("FIRSTNAME_PROF");
                    lastName = rs.getString("LASTNAME_PROF");
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

    public boolean verifLogin(String login, Connection conn){

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT LOGIN_PROF FROM TUTOR WHERE LOGIN_PROF='"+login+"'");
            while ( rs.next() ) {
                if ((rs.getString("LOGIN_PROF")).equals(login)){
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
    /// GETTER AND SETTER ///

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    /*public int getIdTutor() {
        return idTutor;
    }*/

    /// GETTER AND SETTER ///
}
