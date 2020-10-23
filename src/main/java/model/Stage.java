package model;

import java.util.Date;

public class Stage {

    private final int idStage;
    private Date debut;
    private Date fin;
    private String mds;
    private int idEntreprise;
    private int noteTech;
    private int noteCom;
    private static int compteurId;

    public Stage( Date debut, Date fin, String mds, int idEntreprise, int noteTech, int noteCom) {
        this.idStage = compteurId ;
        this.debut = debut;
        this.fin = fin;
        this.mds = mds;
        this.idEntreprise = idEntreprise;
        this.noteTech = noteTech;
        this.noteCom = noteCom;
        compteurId++;
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

    public int getIdStage() {
        return idStage;
    }
}
