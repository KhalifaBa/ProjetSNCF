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

    }
}
