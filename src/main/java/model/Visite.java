package model;

public class Visite
{

    private boolean ficheVisite;
    private boolean plannif;
    private boolean faite;
    private int idTutor;
    private int idStudent;

    public Visite(){
    }


    public boolean isFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public boolean isPlannif() {
        return plannif;
    }

    public void setPlannif(boolean plannif) {
        this.plannif = plannif;
    }

    public boolean isFaite() {
        return faite;
    }

    public void setFaite(boolean faite) {
        this.faite = faite;
    }

    public int getIdTutor() { return idTutor; }

    public void setIdTutor(int idTutor) { this.idTutor = idTutor; }

    public int getIdStudent() { return idStudent; }

    public void setIdStudent(int idStudent) { this.idStudent = idStudent; }
}
