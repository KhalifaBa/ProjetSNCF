package Controlers;

import Entities.Activite;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlActivite {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlActivite() {
        cnx = ConnexionBDD.getCnx();
    }

    // Permet de récupérer toutes les activités
    public ArrayList<Activite> getAllActivites()  {

        ArrayList<Activite> lesActivites = new ArrayList<>();
        try {
        ps = cnx.prepareStatement("select numero,libelle from activite");
        rs = ps.executeQuery();

            while (rs.next()) {
                Activite activite = new Activite(rs.getInt(1), rs.getString(2));
                lesActivites.add(activite);
            }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
        return lesActivites;
    }
}
