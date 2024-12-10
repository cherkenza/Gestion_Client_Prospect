package entities;

import static utilitaires.PatternGestion.PATTERN_MAIL;
import static utilitaires.PatternGestion.PATTERN_TELEPHONE;

public abstract class Societe {
   protected int id;
   protected String raisonSociale;
   protected String telephone;
   protected String email;
    protected Adresse adresse;
   protected String commentaire;


   public Societe() {}

    public Societe(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire) throws GestionException {
       setId(id);
       setRaisonSociale(raisonSociale);
       setTelephone(telephone);
       setEmail(email);
       setAdresse(adresse);
       setCommentaire(commentaire);
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws GestionException {
       if(email == null || email.isEmpty()){
           throw new GestionException(" Entrer le mail");
       }
       if(!PATTERN_MAIL.matcher(email).matches()){
           throw new GestionException("Le mail est invalide");
       }
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) throws GestionException {
       if(raisonSociale.trim().isEmpty() || raisonSociale.equalsIgnoreCase(this.raisonSociale)) {
           throw new GestionException(" La raison sociale existe déjà !");
       }
        this.raisonSociale = raisonSociale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws GestionException {
       if(!PATTERN_TELEPHONE.matcher(telephone).matches()) {
           throw new GestionException("Le numéro de telephone est invalide !");
       }
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Societe{" +
                "adresse=" + adresse +
                ", id=" + id +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
