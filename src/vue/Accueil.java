package vue;

import entities.*;

import javax.swing.*;
import java.awt.event.*;

public class Accueil extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JLabel labelAccueil;
    private JButton buttonClient;
    private JButton buttonProspect;
    private JLabel labelChoixGestion;
    private JButton buttonAfficher;
    private JButton buttonSupprimer;
    private JButton buttonModifier;
    private JButton buttonCreer;
    private JComboBox comboBox1;
    private JButton buttonValider;
    private EnumGestion choixGestion;
    private EnumCrud choixCrud;
    private Societe societe;
    private EnumProspectInteresse choixProspectInteresse;

    public Accueil() {
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setSize(600,600);
        JPanel1.setVisible(true);
        JPanel2.setVisible(false);
        JPanel3.setVisible(false);



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
        buttonClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixGestion = EnumGestion.CLIENT;
                JPanel2.setVisible(true);
                JPanel1.setVisible(false);
            }
        });
        buttonProspect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixGestion = EnumGestion.PROSPECT;
                JPanel2.setVisible(true);
                JPanel1.setVisible(false);
            }
        });
        buttonAfficher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.READ;
                JPanel2.setVisible(false);
                new Liste(choixGestion).setVisible(true);
                dispose();
            }
        });
        buttonCreer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.CREATE;
                JPanel2.setVisible(false);
                new Cud(choixGestion, choixCrud, choixProspectInteresse).setVisible(true);
            }
        });
        buttonModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.UPDATE;
                JPanel2.setVisible(false);
                JPanel3.setVisible(true);
                if(choixGestion == EnumGestion.CLIENT){
                    for(Client client : Clients.clients){
                        comboBox1.addItem(client.getRaisonSociale());
                    }
                }
                if(choixGestion == EnumGestion.PROSPECT){
                    for(Prospect prospect : Prospects.prospects){
                        comboBox1.addItem(prospect.getRaisonSociale());
                    }
                }
                comboBox1.setVisible(true);

            }
        });
        buttonSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = EnumCrud.DELETE;
                JPanel2.setVisible(false);
                JPanel3.setVisible(true);
                if(choixGestion == EnumGestion.CLIENT){
                    for(Client client : Clients.clients){
                        comboBox1.addItem(client.getRaisonSociale());
                    }
                }
                if(choixGestion == EnumGestion.PROSPECT){
                    for(Prospect prospect : Prospects.prospects){
                        comboBox1.addItem(prospect.getRaisonSociale());
                    }
                }
                comboBox1.setVisible(true);

            }
        });
        buttonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Societe societe = null;
                switch(choixGestion){
                    case CLIENT:
                        societe = Clients.clients.get(comboBox1.getSelectedIndex());
                        JOptionPane.showMessageDialog(null, societe);
                        break;
                    case PROSPECT:
                        societe = Prospects.prospects.get(comboBox1.getSelectedIndex());
                        JOptionPane.showMessageDialog(null, societe);
                        break;
                }
                JPanel3.setVisible(false);
                new Cud(choixGestion, choixCrud, societe, choixProspectInteresse).setVisible(true);
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
