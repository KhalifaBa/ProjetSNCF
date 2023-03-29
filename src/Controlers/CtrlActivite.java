package Controlers;

import Entities.Activite;
import Tools.ConnexionBDD;

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
    public ArrayList<Activite> getAllActivites()
    {
        return null;
    }
}
