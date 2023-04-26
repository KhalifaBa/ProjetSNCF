package Controlers;

import Entities.Formation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlFormation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlFormation()
    {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Formation> getFormationsByActivite(int idActivite)
    {
        ArrayList<Formation> lesFormations = new ArrayList<>();
        try
        {
            ps = cnx.prepareStatement("SELECT code, intitule\n" +
                "FROM formation\n" +
                "WHERE formation.numeroActivite = ?");
            ps.setInt(1,idActivite); // il prend le premier point d'interrogation puis remplacera par la variable
            rs = ps.executeQuery();

            while(rs.next())
            {
                Formation uneFormation = new Formation(rs.getString(1),rs.getString(2));
                lesFormations.add(uneFormation);
            }


        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }


        return lesFormations;
    }
}
