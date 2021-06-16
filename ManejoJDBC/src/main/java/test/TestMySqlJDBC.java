package test;

import java.sql.*;
import java.sql.DriverManager;

public class TestMySqlJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            /*Class.forName("com.mysql.cj.jdbc.Driver"); <--Esta linea no es 
            obligatoria pero puede algunos sitios web pueden requerirla
            Lanza excepcion
             */
            Connection conexion = DriverManager.getConnection(url, "root", "admin2021");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("Id Persona: " + resultado.getInt("id_persona"));
                System.out.println(" Nombre: " + resultado.getString("nombre"));
                System.out.println(" Apellido: " + resultado.getString("apellido"));
                System.out.println(" Email: " + resultado.getString("email"));
                System.out.println(" Telefono: " + resultado.getString("telefono"));
            }
            resultado.close(); //Se cierra el objeto
            instruccion.close(); // se cierra la sentencia
            conexion.close(); // se cierra el metodo
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
