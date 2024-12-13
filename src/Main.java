import entities.*;
import gestionLog.ExoLogger;
import vue.Accueil;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;

import static entities.Clients.clients;
import static gestionLog.ExoLogger.logger;
import static utilitaires.PatternGestion.PATTERN_DATE;
import static utilitaires.PatternGestion.PATTERN_TELEPHONE;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            ExoLogger.initFichierLog();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "l'application s'arrete");
            System.exit(1);
        }

        new Accueil().setVisible(true);

        logger.log(Level.INFO, "Début du programme");

        try {
            Client client = new Client("Lidec",(new Adresse("1","charles cournault","54220","malzéville") ),"0784986819", "Lidec@Lidec.fr", "", 8956239, 320);
            Client client1 = new Client("Centrelec", new Adresse("3",  "aznavour" ,"58694" , "paris"),"0615659623", "Centrelec@Centrelec.fr", "", 8936239, 390);
            Client client2 = new Client("Orange", new Adresse("2",  "voltaire"  , "54000","nancy") ,"0865853617", "Orange@Orange.fr", "", 6336239, 3100);


            Clients.clients.add(client);
            Clients.clients.add(client1);
            Clients.clients.add(client2);

            LocalDate date = LocalDate.parse("03/02/2024", PATTERN_DATE);


            Prospect prospect = new Prospect("Free", new Adresse("6","victor hugo" ,"75000" , "paris") ,"0524567425", "free@free.fr", "",date, EnumProspectInteresse.OUI);
            Prospect prospect1 = new Prospect("zara", new Adresse("2", "delivre" , "54000", "nancy"),"0896857423", "zara@zara.fr", "", LocalDate.parse("06/08/2022", PATTERN_DATE), EnumProspectInteresse.NON);
            Prospect prospect2 = new Prospect("mango", new Adresse("5",  "bouquet","57000" , "metz"),"0589963528", "mango@mango.fr", "", LocalDate.parse("06/03/2023", PATTERN_DATE), EnumProspectInteresse.OUI);



            Prospects.prospects.add(prospect);
            Prospects.prospects.add(prospect1);
            Prospects.prospects.add(prospect2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        logger.log(Level.INFO, "Fin de programme");


    }
}
