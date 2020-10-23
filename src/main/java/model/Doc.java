package model;

public class Doc {

    private final int idDoc;
    private boolean cdc;
    private boolean ficheEval;
    private boolean sondage;
    private boolean rapport;
    private boolean soutenance;
    private static int compteurId;

    public Doc(boolean cdc, boolean ficheEval, boolean sondage, boolean rapport, boolean soutenance){
        this.idDoc = compteurId;
        this.cdc = cdc;
        this.ficheEval = ficheEval;
        this.sondage = sondage;
        this.rapport = rapport;
        this.soutenance = soutenance;
        compteurId++;
    }


    public boolean isSoutenance() {
        return soutenance;
    }

    public void setSoutenance(boolean soutenance) {
        this.soutenance = soutenance;
    }

    public boolean isRapport() {
        return rapport;
    }

    public void setRapport(boolean rapport) {
        this.rapport = rapport;
    }

    public boolean isSondage() {
        return sondage;
    }

    public void setSondage(boolean sondage) {
        this.sondage = sondage;
    }

    public boolean isFicheEval() {
        return ficheEval;
    }

    public void setFicheEval(boolean ficheEval) {
        this.ficheEval = ficheEval;
    }

    public boolean isCdc() {
        return cdc;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public int getIdDoc() {
        return idDoc;
    }
}
