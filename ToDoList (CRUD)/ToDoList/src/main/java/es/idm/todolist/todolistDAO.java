package es.idm.todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author IDM
 */
public class todolistDAO { //DB Layer
    
    public static void createTitleDB(todolist todolistTitle){
        connection db_connect = new connection();
        
        try (Connection connection = db_connect.get_connection()) {
            PreparedStatement pstm = null;
            
            try {
                String query = "INSERT INTO listas (nombre_lista) VALUES (?)";
                
                pstm = connection.prepareStatement(query);
                pstm.setString(1, todolistTitle.getNombre_lista());
                pstm.executeUpdate();
                System.out.println("SUCCESSFUL CREATED LIST");
                
            }catch(SQLException e) {
                System.out.println(e);
                System.out.println("IT CAN'T CREATE ANY LIST");
            }
            
        }catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void readListDB() {
        connection db_connect = new connection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try (Connection connection = db_connect.get_connection()) {
            String query = "SELECT * FROM listas";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_lista"));
                System.out.println("TITLE: " + rs.getString("nombre_lista"));
                System.out.println("");
            }
            
        }catch(SQLException e) {
                System.out.println(e);
                System.out.println("IT CAN'T READ THE LIST");
            }
            
        
    }
    
    public static void updateListDB(todolist todolistUpdate) {
        connection db_connect = new connection();
        
        try (Connection connection = db_connect.get_connection()) {
            PreparedStatement pstm = null;
            
            try {
                String query = "UPDATE listas SET nombre_lista = ? WHERE id_lista = ?";
                pstm = connection.prepareStatement(query);
                pstm.setString(1, todolistUpdate.getNombre_lista());
                pstm.setInt(2, todolistUpdate.getId_lista());
                pstm.executeUpdate();
                System.out.println("THE LIST HAS BEEN UPDATED SUCCESSFULLY");
                
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("THE LIST COULDN'T BE UPDATE");
            }
            
        }catch(SQLException e) {
            System.out.println(e);
        }
            
    }
    
    public static void deleteListDB(int id_lista) {
        connection db_connect = new connection();
        
        try (Connection connection = db_connect.get_connection()) {
            PreparedStatement pstm = null;
            
            try {
                
                String query = "DELETE FROM listas WHERE id_lista = ?";
                pstm = connection.prepareStatement(query);
                pstm.setInt(1, id_lista);
                pstm.executeUpdate();
                System.out.println("THE LIST HAS BEEN DELETED SUCCESSFULLY");
                
            } catch(SQLException e) {
                System.out.println(e);
                System.out.println("THE LIST COULDN'T BE DELETED");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
            
    }
}
