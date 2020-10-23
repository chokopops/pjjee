package model;

public class Visite {

    private final int idVisite;
    private boolean ficheVisite;
    private boolean plannif;
    private boolean faite;
    private static int compteurId;

    public Visite(boolean ficheVisite, boolean plannif, boolean faite){
        this.idVisite = compteurId;
        this.ficheVisite = ficheVisite;
        this.plannif = plannif;
        this.faite = faite;
        compteurId++;
    }

    public int getIdVisite() {
        return idVisite;
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
}
