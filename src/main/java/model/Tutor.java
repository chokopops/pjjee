package model;

public class Tutor
{
    private final int idTutor;
    private String login;
    private String pwd;
    private String firstName;
    private String lastName;
    private static int compteurId;

    public Tutor(String login, String pwd, String firstName, String lastName){
        this.idTutor = compteurId;
        this.login = login;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        compteurId++;
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
        return idTutor;
    }

    /// GETTER AND SETTER ///
}
