package es.idm.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author IDM
 */
public class connection {
    //Driver to connect to the DDBB
    public Connection get_connection() {
        
        Connection conection = null;
        
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
        } catch(SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
