package model;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Student
{
    private final int idStudent;
    private String firstname;
    private String lastname;
    private String group;
    private static int compteurId;

    public Student(String firstname, String lastname, String group){
        this.idStudent = compteurId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
        compteurId++;
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

    public int getIdStudent() {
        return idStudent;
    }
}
