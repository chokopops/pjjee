package model;

import ctrl.DataServices;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.Statement;

import static utils.Constant.*;

public class Tutor
{
    private String login = "";
    private String pwd = "";
    private int idtutor;
    private String firstName = "";
    private String lastName = "";
    private String resultat = "";

    public Tutor(){
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
            System.out.println(login);
            System.out.println(pwd);
            rs = stmt.executeQuery("SELECT ID_TUTOR, LOGIN_PROF, PWD_PROF, FIRSTNAME_PROF, LASTNAME_PROF FROM TUTOR WHERE LOGIN_PROF='"+login+"'");
            while ( rs.next() ) {
                if ((rs.getString("PWD_PROF")).equals(pwd)){
                    resultat = loginSuccess;
                    idtutor = rs.getInt("ID_TUTOR");
                    firstName = rs.getString("FIRSTNAME_PROF");
                    lastName = rs.getString("LASTNAME_PROF");
                    System.out.println("log et mail good");
                }
            }
            if (resultat != loginSuccess){
                resultat = loginFail;
            }

        }
        catch (Exception e){
            System.out.println(e);
            resultat = loginFail;
        }



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



    public int getIdTutor() {
        return idtutor;
    }

    /// GETTER AND SETTER ///
}
