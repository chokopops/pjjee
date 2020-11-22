package model;

import java.util.Date;

public class Stage {

    private Date debut = null;
    private Date fin = null;
    private String mds = "";
    private String DescriptionStage = "";
    private String Commentaire = "";
    private int idEntreprise;
    private int idStudent;
    private int noteTech;
    private int noteCom;

    public Stage( ) {
    }


    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getMds() {
        return mds;
    }

    public void setMds(String mds) {
        this.mds = mds;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public int getIdStudent() { return idStudent; }

    public void setIdStudent(int idStudent) { this.idStudent = idStudent; }

    public int getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(int noteTech) {
        this.noteTech = noteTech;
    }

    public int getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(int noteCom) {
        this.noteCom = noteCom;
    }

    public String getDescriptionStage() {
        return DescriptionStage;
    }

    public void setDescriptionStage(String descriptionStage) {
        DescriptionStage = descriptionStage;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String commentaire) {
        Commentaire = commentaire;
    }
}
