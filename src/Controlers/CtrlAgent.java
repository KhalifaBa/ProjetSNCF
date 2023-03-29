package Controlers;

import Entities.Activite;
import Entities.Agent;
import Entities.AgentPresent;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlAgent {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlAgent() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Agent> getAllAgentsNonInscrits(String idFormation)
    {

        return null;
    }

}
