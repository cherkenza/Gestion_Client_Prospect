package entities;
import static utilitaires.PatternGestion.PATTERN_DATE;

import java.time.LocalDate;

public class Prospect extends Societe{
    private static int compteur = 0;
    private LocalDate dateProspection;
    private String prospectInteresse;

    public Prospect(){}

    /*public Prospect(LocalDate dateProspection, String prospectInteresse) {
        this.dateProspection = dateProspection;
        this.prospectInteresse = prospectInteresse;
    }

     */

    public Prospect( String raisonSociale,Adresse adresse, String telephone, String email, String commentaire, LocalDate dateProspection, String prospectInteresse) throws GestionException{
        super(++compteur, raisonSociale,adresse, telephone, email, commentaire);
        this.dateProspection = dateProspection;
        this.prospectInteresse = prospectInteresse;
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) throws GestionException {
        if(dateProspection == null || !PATTERN_DATE.format(dateProspection).equals(PATTERN_DATE.format(this.dateProspection))){
            throw new GestionException(" la date est invalide");
        }
        this.dateProspection = dateProspection;
    }

    public String getProspectInteresse() {
        return prospectInteresse;
    }

    public void setProspectInteresse(String prospectInteresse) {
        this.prospectInteresse = prospectInteresse;
    }

    @Override
    public String toString() {
        return super.toString() + "Prospect{" +
                "dateProspection=" + dateProspection +
                ", prospectInteresse='" + prospectInteresse + '\'' +
                '}';
    }
}
