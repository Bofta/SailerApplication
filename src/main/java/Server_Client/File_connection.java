package Server_Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Montasser
 *
 */

public class File_connection {
    public static Connection myconnection() throws ClassNotFoundException , SQLException {
        try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection File_connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sailclub_db","root","");
           return File_connection;
        }
        catch(Exception e) {
            return null;
        }
    }
}
