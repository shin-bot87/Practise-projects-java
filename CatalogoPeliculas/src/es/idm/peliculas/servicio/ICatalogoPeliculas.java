package es.idm.peliculas.servicio;

public interface ICatalogoPeliculas {
    //Constante para implemetar el archivo
    String NOMBRE_RECURSO = "peliculas.txt";
    
    //Creacion de metodos
    void agregarPelicula(String nombrePelicula);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogoPeliculas();
}
