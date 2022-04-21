package es.idm.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Se crea metodo que devuelve un objeto de tipo conexion
    //Este metodo tiene las funcionalidades para realizar la conexion a la BBDD
    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
        } catch(SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
