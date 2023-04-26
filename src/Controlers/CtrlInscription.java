package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlInscription
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlInscription()
    {
        cnx = ConnexionBDD.getCnx();
    }


    public void InsererInscription(String codeFormation, String codeAgent)
    {
        try {
            ps = cnx.prepareStatement("INSERT INTO inscription VALUES (?,?,?)");
            ps.setString(1,codeAgent);
            ps.setString(2,codeFormation);
            ps.setInt(3,0);
            rs = ps.executeQuery();
        } catch (SQLException e)
        {
            throw new RuntimeException();

        }


    }
}
