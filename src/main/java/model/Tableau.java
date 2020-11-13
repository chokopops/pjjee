package model;

public class Tableau {
    private Doc StudentDoc;
    private Entreprise StudentEnterprise;
    private Stage StudentStage;
    private Student StudentInfo;
    private Tutor StudentTutor;
    private Visite StudentVisite;

    public Tableau(Doc studentDoc, Entreprise studentEnterprise, Stage studentStage, Student studentInfo,
                   Tutor studentTutor, Visite studentVisite)
    {

        this.StudentDoc = studentDoc;
        this.StudentEnterprise = studentEnterprise;
        this.StudentStage = studentStage;
        this.StudentInfo = studentInfo;
        this.StudentTutor = studentTutor;
        this.StudentVisite = studentVisite;

    }
    public  Tableau()
    {

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
