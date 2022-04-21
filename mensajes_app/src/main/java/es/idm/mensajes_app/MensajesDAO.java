package es.idm.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MensajesDAO {
    
    //CREAR MENSAJES
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion(); //Objeto para hacer la conexion a la BBDD
        
        //Bloque Try-Catch para validar si la conexion ha sido realizada con exito o no
        try(Connection conexion = db_connect.get_connection()) {
            
            PreparedStatement ps = null; //Prepara la consulta a la BBDD
            
            try {
                
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
                
                /*String query sirve para realizar la consula a la BDD. TRUCO para ver la consulta directamente,
                Ir a PHPMyAdmin, hacer la consulta manualmente y en una de las barras supeirores podemos ver la
                consulta realizada. Se copia y pega la consulta al String query pero se debe editar:
                
                1. Quitar todas las comillas francesas.
                2. Sustituir los valores (por ejemplo el ID) por signo de interrogaicon -> ?
                3. En algunos casos habra que eliminar la columna espicifica despues del WHERE
                
                */
                
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                
                System.out.println(ex);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //LEER MENSAJES
    public static void leerMensajeDB() {
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
            
        } catch (SQLException e) {
            System.out.println("NO SE PUDIERON RECUPERAR LOS MENSAJES");
            System.out.println(e);
        }
    }
    
    //BORRAR MENSAJES
    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("EL MENSAJE HA SIDO BORRADO CON EXITO");
                
            } catch(SQLException e) {
                System.out.println(e);
                System.out.println("NO SE PUEDO BORRAR EL MENSAJE");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //EDITAR MENSAJES
    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("EL MENSAJE SE HA ACTUALIZADO CON EXITO");
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("NO SE PUDO EDITAR EL MENSAJE");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
