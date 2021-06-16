package es.idm.peliculas.domain;

public class Pelicula {
    
    //Atributo de acceso privado
    private String nombre;
    
    //Constructor sin argumentos
    public Pelicula() {
    }

    //Constructor con argumentos
    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + '}';
    }
    
    
}
