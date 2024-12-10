package entities;

import static utilitaires.PatternGestion.PATTERN_CODEPOSTAL;

public class Adresse {
    private String numeroRue;
    private String nomRue;
    private String codePostal;
    private String ville;


    public Adresse() {}

    public Adresse(String numeroRue, String nomRue, String codePostal , String ville) throws GestionException{
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.numeroRue = numeroRue;
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) throws GestionException{
        if(codePostal == null || codePostal.trim().isEmpty()){
            throw new GestionException(" Entrer le code postal");
        }
        if(!PATTERN_CODEPOSTAL.matcher(codePostal).matches()){
            throw new GestionException("le code postal n'est pas valide");
        }
        this.codePostal = codePostal;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) throws GestionException {
        if(nomRue == null || nomRue.trim().isEmpty()){
            throw new GestionException("Veuillez entrer le nom de la rue");
        }
        this.nomRue = nomRue;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) throws GestionException {
        if(numeroRue == null || numeroRue.trim().isEmpty()){
           throw new GestionException("Veuillez entrer le numero de la rue");
        }
        this.numeroRue = numeroRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) throws GestionException {
        if(ville == null || ville.trim().isEmpty()){
            throw new GestionException("Veuillez entrer la ville");
        }
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "codePostal='" + codePostal + '\'' +
                ", numeroRue='" + numeroRue + '\'' +
                ", nomRue='" + nomRue + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
