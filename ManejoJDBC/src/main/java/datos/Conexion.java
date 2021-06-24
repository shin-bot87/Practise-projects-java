package datos;

import java.sql.*;

/*****************************************************
*CODIGO REUTILIZABLE PARA CONEXIONES A BASES DE DATOS*
*****************************************************/

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";//introducir tu propio usuario
    private static final String JDBC_PASSWORD = "admin"; //introducir tu propio password

    //Metodo para obtener la conexion a la base de datos
    public static Connection getConnection() throws SQLException {//Se agrega excepcion a la firma
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);//Linea de conexion
    }

    public static void close(ResultSet rs) throws SQLException {//Sobrecarga del metodo para cerrar objetos
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
