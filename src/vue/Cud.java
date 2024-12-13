package vue;

import entities.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.logging.Level;
import static gestionLog.ExoLogger.logger;
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

    public Cud(EnumGestion choixGestion, EnumCrud choixCrud,EnumProspectInteresse choixProspectInteresse) {
        this.choixGestion = choixGestion;
        this.choixCrud = choixCrud;
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        initComponents();
        if(choixGestion == EnumGestion.CLIENT) {
            Client.incrementeCompteur();
            textFieldIdentifiant.setText(String.valueOf(Client.getCompteur()));
            textFieldIdentifiant.setEditable(false);
        }

        if(choixGestion == EnumGestion.PROSPECT) {
            Prospect.incrementeCompteur();
            textFieldIdentifiant.setText(String.valueOf(Prospect.getCompteur()));
            textFieldIdentifiant.setEditable(false);
            comboBox2.addItem(EnumProspectInteresse.OUI);
            comboBox2.addItem(EnumProspectInteresse.NON);
        }


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
        textFieldIdentifiant.setText(String.valueOf(societe.getId()));
        textFieldIdentifiant.setEditable(false);
        comboBox2.addItem("");
        comboBox2.addItem(EnumProspectInteresse.OUI);
        comboBox2.addItem(EnumProspectInteresse.NON);
        remplissage();
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


        buttonquitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        buttonretouraccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Accueil().setVisible(true);

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
                        ((Prospect) societe).setProspectInteresse((EnumProspectInteresse) comboBox2.getSelectedItem());
                        Prospects.prospects.add((Prospect) societe);


                    }

                }catch (GestionException eg){
                    JOptionPane.showMessageDialog(null,  eg.getMessage());
                }
                catch (NumberFormatException en){
                    JOptionPane.showMessageDialog(null, "le nombre d'employés est invalide" + en.getMessage());
                }
                catch (DateTimeException ed){
                    JOptionPane.showMessageDialog(null, "la date est invalide" + ed.getMessage());
                }

                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, "Erreur l'application va s'arreter" + ee.getMessage());
                    logger.log(Level.SEVERE, "Erreur l'application va s'arreter", ee.getMessage());
                    System.exit(1);
                }
                new Liste(choixGestion).setVisible(true);
            }


        });

        modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.UPDATE;
                try{
                    societe.setRaisonSociale(textFieldRaisonsociale.getText());
                    societe.getAdresse().setNumeroRue(textFieldnumerorue.getText());
                    societe.getAdresse().setNomRue(textFieldnomrue.getText());
                    societe.getAdresse().setCodePostal(textFieldcodepostal.getText());
                    societe.getAdresse().setVille(textFieldville.getText());
                    societe.setTelephone(textFieldtelephone.getText());
                    societe.setEmail(textFieldemail.getText());
                    if(choixGestion == EnumGestion.CLIENT){
                        ((Client) societe).setChiffreAffaires(Long.parseLong(textFieldchiffreaffaire.getText()));
                        ((Client) societe).setNombreEmployes(Integer.parseInt(textFieldnombreemployes.getText().toString()));
                    }
                    if(choixGestion == EnumGestion.PROSPECT){
                        ((Prospect) societe).setDateProspection(LocalDate.parse(textFielddateprospection.getText(), PATTERN_DATE));
                        comboBox2.setSelectedItem(((Prospect) societe).getProspectInteresse().toString());
                    }
                }
                catch (GestionException eg){
                    JOptionPane.showMessageDialog(null,  eg.getMessage());

                }catch (NumberFormatException en){
                    JOptionPane.showMessageDialog(null, "le nombre d'employés est invalide" + en.getMessage());
                }
                catch (DateTimeException ed){
                    JOptionPane.showMessageDialog(null, "la date est invalide" + ed.getMessage());
                }

                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, "Erreur l'application va s'arreter" + ee.getMessage());
                    logger.log(Level.SEVERE, "Erreur l'application va s'arreter", ee.getMessage());
                    System.exit(1);
                }
                new Liste(choixGestion).setVisible(true);

            }
        });

        buttonsupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.DELETE;
                int choixCinfirmation = JOptionPane.showConfirmDialog(null, "Etes vous sur de la suppression ", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(choixCinfirmation == JOptionPane.YES_OPTION){
                    if(choixGestion == EnumGestion.CLIENT){
                        Clients.clients.remove(societe);
                    }
                    if(choixGestion == EnumGestion.PROSPECT){
                        Prospects.prospects.remove(societe);
                    }
                    new Liste(choixGestion).setVisible(true);
                }
            }
        });


    }

    private void remplissage(){
        textFieldRaisonsociale.setText(societe.getRaisonSociale());
        textFieldnumerorue.setText(societe.getAdresse().getNumeroRue());
        textFieldnomrue.setText(societe.getAdresse().getNomRue());
        textFieldcodepostal.setText(societe.getAdresse().getCodePostal());
        textFieldville.setText(societe.getAdresse().getVille());
        textFieldtelephone.setText(societe.getTelephone());
        textFieldemail.setText(societe.getEmail());

        if(choixGestion == EnumGestion.CLIENT){
            textFieldchiffreaffaire.setText(String.valueOf(((Client) societe).getChiffreAffaires()));
            textFieldnombreemployes.setText(String.valueOf(((Client) societe).getNombreEmployes()));
            textFielddateprospection.setVisible(false);
            comboBox2.setVisible(false);
            dateprospection.setVisible(false);
            prospectinteresse.setVisible(false);
        }
        if(choixGestion == EnumGestion.PROSPECT){
            textFielddateprospection.setText(String.valueOf(((Prospect) societe).getDateProspection()));
            comboBox2.setVisible(true);
            textFieldchiffreaffaire.setVisible(false);
            textFieldnombreemployes.setVisible(false);
            chiffreaffaires.setVisible(false);
            nombremployes.setVisible(false);
        }

        if(choixCrud == EnumCrud.DELETE){
            textFieldRaisonsociale.setEditable(false);
            textFieldnumerorue.setEditable(false);
            textFieldnomrue.setEditable(false);
            textFieldcodepostal.setEditable(false);
            textFieldville.setEditable(false);
            textFieldtelephone.setEditable(false);
            textFieldemail.setEditable(false);
            textFieldchiffreaffaire.setEditable(false);
            textFieldnombreemployes.setEditable(false);
            textFielddateprospection.setEditable(false);
            comboBox2.setEditable(false);
        }
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
