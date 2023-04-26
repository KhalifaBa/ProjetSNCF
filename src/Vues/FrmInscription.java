package Vues;

import Controlers.CtrlActivite;
import Controlers.CtrlAgent;
import Controlers.CtrlFormation;
import Controlers.CtrlInscription;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmInscription extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblActivite;
    private JLabel lblAgentNonInscrit;
    private JTable tblActivites;
    private JTable tblAgentsNonInscrits;
    private JLabel lblFormation;
    private JTable tblFormations;
    private JButton btnInscription;

    ModelJTable mdl;

    CtrlActivite ctrlActivite;

    CtrlFormation ctrlFormation;

    CtrlAgent ctrlAgent;

    CtrlInscription ctrlInscription;
    String numFormation;



    public FrmInscription()
    {
        this.setTitle("Inscription");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                // A vous de jouer


                ctrlActivite = new CtrlActivite();
                mdl = new ModelJTable();
                mdl.LoadDatasActivites(ctrlActivite.getAllActivites());
                tblActivites.setModel(mdl);

            }
        });

        tblActivites.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer
                int numActivite = Integer.parseInt(tblActivites.getValueAt(tblActivites.getSelectedRow(),0).toString());
                mdl = new ModelJTable();
                ctrlFormation = new CtrlFormation();
                mdl.LoadDatasFormations(ctrlFormation.getFormationsByActivite(numActivite));
                tblFormations.setModel(mdl);


            }
        });

        tblFormations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer
                numFormation = tblFormations.getValueAt(tblFormations.getSelectedRow(),0).toString();
                mdl = new ModelJTable();
                mdl.LoadDatasAgents(ctrlAgent.getAllAgentsNonInscrits(numFormation));
                tblAgentsNonInscrits.setModel(mdl);



            }
        });
        btnInscription.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // A vous de jouer
                ctrlInscription = new CtrlInscription();
                for (int i = 0; i<tblAgentsNonInscrits.getSelectedRowCount();i++)
                {
                    ctrlInscription.InsererInscription(numFormation,tblAgentsNonInscrits.getValueAt(tblAgentsNonInscrits.getSelectedRows()[i],0).toString());
                }



            }
        });
    }
}
