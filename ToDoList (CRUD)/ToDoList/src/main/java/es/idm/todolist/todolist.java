package es.idm.todolist;

/**
 *
 * @author IDM
 */
public class todolist { //Model layer
    int id_lista;
    String nombre_lista;

    public todolist() {
    }

    public todolist(String nombre_lista) {
        this.nombre_lista = nombre_lista;
        
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public void setNombre_lista(String nombre_lista) {
        this.nombre_lista = nombre_lista;
    }
    
}
