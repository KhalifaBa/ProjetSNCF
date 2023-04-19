package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnexionBDD
{
    private static Connection cnx; // static permet de faire appel à la classe sans instancier

    public ConnexionBDD() throws ClassNotFoundException, SQLException {
        // (cj) pour Docker
        String pilote = "com.mysql.cj.jdbc.Driver";
        // chargement du pilote
        Class.forName(pilote);
        // L'objet connexion à la BDD avec le nom de la base, le user et le password
        cnx = DriverManager.getConnection("jdbc:mysql://localhost:3308/sncf?serverTimezone="
                + TimeZone.getDefault().getID(), "root", "yoo");
    }
    public static Connection getCnx() {
        return cnx;
    }
}
