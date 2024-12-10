package vue;

import entities.Client;
import entities.EnumGestion;
import entities.Prospect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import static entities.Clients.clients;
import static entities.Prospects.prospects;

public class Liste extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JLabel labelListe;
    private JButton buttonRetourAccueil;
    private EnumGestion choixGestion;

    public Liste(EnumGestion choixGestion) {
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        initComponent();
        listeners();
        this.choixGestion = choixGestion;
        remplissageTable1();

    }

        private void initComponent() {
            this.setSize(600, 600);
        }

        private void listeners() {

            buttonRetourAccueil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Liste(choixGestion).setVisible(false);
                    new Accueil().setVisible(true);
                }
            });
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            });


            // call onCancel() when cross is clicked
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    onCancel();
                }
            });

            // call onCancel() on ESCAPE
            contentPane.registerKeyboardAction(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        }
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void remplissageTable1(){
        DefaultTableModel tableModel;
        String[] entete;
        if(choixGestion == EnumGestion.CLIENT){
            entete = new String[]{"ID", "Raison Sociale", "Numéro de rue", "Nom de rue", "Code Postal", "Ville", "Téléphone", "Adresse Mail","Commentaires", "Chiffre d'Affaires", "Nombre d'Employés"};
            tableModel = new DefaultTableModel(entete, 0);
            tableModel.addRow(entete);
            for(Client client : clients)
                tableModel.addRow(new Object[]{
                     client.getId(),
                     client.getRaisonSociale(),
                         client.getAdresse().getNumeroRue(), client.getAdresse().getNomRue(), client.getAdresse().getCodePostal(), client.getAdresse().getVille(),
                     client. getTelephone(),
                        client.getEmail(),
                        client.getCommentaire(),
                        client.getChiffreAffaires(),
                        client.getNombreEmployes()

                });
            table1.setModel(tableModel);

        }
        if(choixGestion == EnumGestion.PROSPECT){
            entete = new String[]{"ID", "Raison Sociale", "Numéro de rue", "Nom de rue", "Code Postal", "Ville", "Téléphone", "Adresse Mail","Commentaire", "Date de Prospection", "Prospect Intéressé"};
            tableModel = new DefaultTableModel(entete, 0);
            tableModel.addRow(entete);
            for (Prospect prospect : prospects)
                tableModel.addRow(new Object[]{
                        prospect.getId(),
                        prospect.getRaisonSociale(),
                        prospect.getAdresse().getNumeroRue(), prospect.getAdresse().getNomRue(), prospect.getAdresse().getCodePostal(), prospect.getAdresse().getVille(),
                        prospect.getTelephone(),
                        prospect.getEmail(),
                        prospect.getCommentaire(),
                        prospect.getDateProspection(),
                        prospect.getProspectInteresse()
                });
            table1.setModel(tableModel);
        }
    }
}
