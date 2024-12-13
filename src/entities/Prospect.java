package entities;
import org.w3c.dom.ls.LSOutput;

import static utilitaires.PatternGestion.PATTERN_DATE;

import java.time.LocalDate;

public class Prospect extends Societe{
    private static int compteur = 0;
    private LocalDate dateProspection;
    private EnumProspectInteresse prospectInteresse;

    public Prospect(){}

    /*public Prospect(LocalDate dateProspection, String prospectInteresse) {
        this.dateProspection = dateProspection;
        this.prospectInteresse = prospectInteresse;
    }

     */

    public Prospect( String raisonSociale,Adresse adresse, String telephone, String email, String commentaire, LocalDate dateProspection, EnumProspectInteresse prospectInteresse) throws GestionException{
        super(++compteur, raisonSociale,adresse, telephone, email, commentaire);
       setDateProspection(dateProspection);
       setProspectInteresse(prospectInteresse);
    }
    public static int getCompteur() {
        return compteur;
    }

    public static void incrementeCompteur(){
        compteur++;
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }


    public void setDateProspection(LocalDate dateProspection) throws GestionException{    this.dateProspection = dateProspection;}

    public EnumProspectInteresse getProspectInteresse() {
        return prospectInteresse;
    }

    public void setProspectInteresse(EnumProspectInteresse prospectInteresse) {
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
