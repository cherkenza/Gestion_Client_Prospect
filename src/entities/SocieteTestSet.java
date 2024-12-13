package entities;

public class SocieteTestSet extends Societe{
    public SocieteTestSet(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire)  throws GestionException
    {        super(id,raisonSociale,adresse, telephone, email, commentaire);
    }
}
