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
        ArrayList<Agent> lesAgents = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT agent.code, agent.nom, agent.prenom FROM agent WHERE agent.code NOT IN (SELECT agent.code FROM agent INNER JOIN inscription ON agent.code = inscription.codeAgent WHERE inscription.numeroFormation = ?);");
            ps.setString(1,idFormation);
            rs = ps.executeQuery();

            while (rs.next())
            {
                Agent unAgent = new Agent(rs.getString(1),rs.getString(2),rs.getString(3));
                lesAgents.add(unAgent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lesAgents;
    }

}
