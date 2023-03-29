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

        return null;
    }
}
