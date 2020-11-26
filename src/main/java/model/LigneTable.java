package model;public class LigneTable {

    private Doc StudentDoc;
    private Entreprise StudentEnterprise;
    private Stage StudentStage;
    private Student StudentInfo;
    private Tutor StudentTutor;
    private Visite StudentVisite;

    //model for the detail page table

    public LigneTable(Doc StudentDoc, Entreprise StudentEnterprise, Stage StudentStage, Student StudentInfo, Tutor StudentTutor, Visite StudentVisite){
        setStudentDoc(StudentDoc);
        setStudentEnterprise(StudentEnterprise);
        setStudentStage(StudentStage);
        setStudentInfo(StudentInfo);
        setStudentTutor(StudentTutor);
        setStudentVisite(StudentVisite);
    }

    public Doc getStudentDoc() {
        return StudentDoc;
    }

    public void setStudentDoc(Doc studentDoc) {
        StudentDoc = studentDoc;
    }

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
