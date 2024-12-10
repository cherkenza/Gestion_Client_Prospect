package vue;

import entities.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import static utilitaires.PatternGestion.PATTERN_DATE;

public class Cud extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldIdentifiant;
    private JTextField textFieldnomrue;
    private JTextField textFielddateprospection;
    private JTextField textFieldnombreemployes;
    private JTextField textFieldchiffreaffaire;
    private JTextField textFieldemail;
    private JTextField textFieldtelephone;
    private JTextField textFieldcodepostal;
    private JTextField textFieldRaisonsociale;
    private JTextField textFieldnumerorue;
    private JLabel Identifiant;
    private JLabel raisonsociale;
    private JLabel numerorue;
    private JLabel nomrue;
    private JLabel codepostal;
    private JLabel ville;
    private JLabel telephone;
    private JLabel email;
    private JLabel chiffreaffaires;
    private JLabel nombremployes;
    private JLabel dateprospection;
    private JLabel prospectinteresse;
    private JTextField textFieldville;
    private JButton buttonsupprimer;
    private JButton modifier;
    private JButton créer;
    private JButton buttonretouraccueil;
    private JButton buttonquitter;
    private JLabel prospect;
    private JLabel client;
    private JComboBox comboBox2;
    private JButton buttonOK;
    private JButton buttonCancel;
    private EnumGestion choixGestion;
    private EnumCrud choixCrud;
    private EnumProspectInteresse choixProspectInteresse;
    private Societe societe;

    public Cud(EnumGestion choixGestion, EnumCrud choixCrud, EnumProspectInteresse choixProspectInteresse) {
        this.choixGestion = choixGestion;
        this.choixCrud = choixCrud;
        this.choixProspectInteresse = choixProspectInteresse;
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        initComponents();
        listeners();

    }

    public Cud(EnumGestion choixGestion, EnumCrud choixCrud, Societe societe, EnumProspectInteresse choixProspectInteresse) {
        this.choixGestion = choixGestion;
        this.choixCrud = choixCrud;
        this.societe = societe;
        this.choixProspectInteresse = choixProspectInteresse;
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        initComponents();
        listeners();
    }

    private void initComponents() {
        this.setSize(600, 600);
        if(choixCrud == EnumCrud.CREATE){
            créer.setVisible(true);
            modifier.setVisible(false);
            buttonsupprimer.setVisible(false);
            buttonretouraccueil.setVisible(true);
            buttonquitter.setVisible(true);
        }

        if(choixCrud == EnumCrud.UPDATE){
            modifier.setVisible(true);
            créer.setVisible(false);
            buttonsupprimer.setVisible(false);
            buttonretouraccueil.setVisible(true);
            buttonquitter.setVisible(true);
        }

        if(choixCrud == EnumCrud.DELETE){
            buttonsupprimer.setVisible(true);
            modifier.setVisible(false);
            créer.setVisible(false);
            buttonretouraccueil.setVisible(true);
            buttonquitter.setVisible(true);
        }

        if(choixGestion == EnumGestion.CLIENT){
            client.setVisible(true);
            textFieldchiffreaffaire.setVisible(true);
            textFieldnombreemployes.setVisible(true);
            textFielddateprospection.setVisible(false);
            comboBox2.setVisible(false);
            dateprospection.setVisible(false);
            prospectinteresse.setVisible(false);
            prospect.setVisible(false);
        }

        if(choixGestion == EnumGestion.PROSPECT){
            prospect.setVisible(true);
            textFielddateprospection.setVisible(true);
            comboBox2.setVisible(true);
            textFieldchiffreaffaire.setVisible(false);
            textFieldnombreemployes.setVisible(false);
            chiffreaffaires.setVisible(false);
            nombremployes.setVisible(false);
            client.setVisible(false);

        }
    }
    private void listeners() {

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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
        créer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.CREATE;
                Societe societe;
                try{
                    if(choixGestion == EnumGestion.CLIENT){
                        societe = new Client();
                        societe.setRaisonSociale(textFieldRaisonsociale.getText());
                        societe.getAdresse().setNumeroRue(textFieldnumerorue.getText());
                        societe.getAdresse().setNomRue(textFieldnomrue.getText());
                        societe.getAdresse().setCodePostal(textFieldcodepostal.getText());
                        societe.getAdresse().setVille(textFieldville.getText());
                        societe.setTelephone(textFieldtelephone.getText());
                        societe.setEmail(textFieldemail.getText());
                        ((Client) societe).setChiffreAffaires(Long.parseLong(textFieldchiffreaffaire.getText()));
                        ((Client) societe).setNombreEmployes(Integer.parseInt(textFieldnombreemployes.getText().toString()));
                        Clients.clients.add((Client) societe);
                    }

                    if(choixGestion == EnumGestion.PROSPECT){
                        societe = new Prospect();
                        societe.setRaisonSociale(textFieldRaisonsociale.getText());
                        societe.getAdresse().setNumeroRue(textFieldnumerorue.getText());
                        societe.getAdresse().setNomRue(textFieldnomrue.getText());
                        societe.getAdresse().setCodePostal(textFieldcodepostal.getText());
                        societe.getAdresse().setVille(textFieldville.getText());
                        societe.setTelephone(textFieldtelephone.getText());
                        societe.setEmail(textFieldemail.getText());
                        ((Prospect) societe).setDateProspection(LocalDate.parse(textFielddateprospection.getText(), PATTERN_DATE));
                        ((prospect) societe).setEstInteresse(comboBox2.getSelectedItem().toString());
                        Prospects.prospects.add((Prospect) societe);


                    }

                }catch ()


            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
