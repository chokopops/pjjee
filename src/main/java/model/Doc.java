package model;

public class Doc {

    private boolean cdc;
    private boolean ficheEval;
    private boolean sondage;
    private boolean rapport;
    private boolean soutenance;

    public Doc(){

    }


    public boolean isCdc() { return cdc; }
    public void setCdc(boolean cdc) { this.cdc = cdc; }

    public boolean isFicheEval() { return ficheEval; }
    public void setFicheEval(boolean ficheEval) { this.ficheEval = ficheEval; }

    public boolean isSondage() { return sondage; }
    public void setSondage(boolean sondage) { this.sondage = sondage; }

    public boolean isRapport() { return rapport; }
    public void setRapport(boolean rapport) { this.rapport = rapport; }

    public boolean isSoutenance() { return soutenance; }
    public void setSoutenance(boolean soutenance) { this.soutenance = soutenance; }
}
