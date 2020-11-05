package model;

public class Student
{
    private final int idStudent;
    private String firstname;
    private String lastname;
    private String group;
    private int idTutor;
    private int idDoc;

    public Student(int idStudent, String firstname, String lastname, String group, int tutor, int doc)
    {
        this.idStudent = idStudent;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
        this.idTutor = tutor;
        this.idDoc = doc;
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

    public int getIdStudent() { return idStudent; }

    public int getIdTutor() { return idTutor; }

    public void setIdTutor(int idTutor) { this.idTutor = idTutor; }

    public int getIdDoc() { return idDoc; }

    public void setIdDoc(int idDoc) { this.idDoc = idDoc; }
}
