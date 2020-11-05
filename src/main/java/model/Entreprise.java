package model;

public class Entreprise
{
    private final int idEntreprise;
    private String nom;
    private String adresse;

    public Entreprise(int idEntreprise, String nom, String adresse)
    {
        this.idEntreprise = idEntreprise;
        this.nom = nom;
        this.adresse = adresse;
    }

    public int getIdEntreprise() { return idEntreprise; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }

    public void setAdresse(String adresse) { this.adresse = adresse; }
}
