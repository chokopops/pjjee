package model;

public class Tutor
{
    private final int idTutor;
    private String email;
    private String pwd;
    private String firstName;
    private String lastName;
    private static int compteurId;

    public Tutor(String email, String pwd, String firstName, String lastName){
        this.idTutor = compteurId;
        this.email = email;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        compteurId++;
    }

    /// GETTER AND SETTER ///

    public String getLogin() { return email; }
    public void setLogin(String login) { this.email = login; }

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
