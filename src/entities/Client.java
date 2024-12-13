package entities;

public class Client extends Societe {
    private static int compteur = 0;
    private long chiffreAffaires;
    private int nombreEmployes;

    public Client()  {}

    /*public Client(long chiffreAffaires, int nombreEmployes) throws GestionException {
        setChiffreAffaires(chiffreAffaires);
        setNombreEmployes(nombreEmployes);
    }

     */

    public Client(String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, long chiffreAffaires, int nombreEmployes) throws GestionException {

        super(++compteur, raisonSociale, adresse, telephone, email, commentaire);

       setChiffreAffaires(chiffreAffaires);
        setNombreEmployes(nombreEmployes);

    }
    public static int getCompteur(){
        return compteur;
    }
    public static void incrementeCompteur(){
        compteur++;
    }

    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(long chiffreAffaires) throws GestionException {
        if(chiffreAffaires < 200 || chiffreAffaires == 0){
            throw new GestionException("Chiffre affaires invalide");
        }
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) throws GestionException {
        if(nombreEmployes< 0 || nombreEmployes == 0){
            throw new GestionException("Nombre employes invalide");
        }
        this.nombreEmployes = nombreEmployes;
    }

    @Override
    public String toString() {
        return  super.toString() + "Client{" +
                "chiffreAffaires=" + chiffreAffaires +
                ", nombreEmployes=" + nombreEmployes +
                '}';
    }
}
