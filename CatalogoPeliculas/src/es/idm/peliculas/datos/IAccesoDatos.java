package es.idm.peliculas.datos;

import es.idm.peliculas.domain.Pelicula;
import es.idm.peliculas.excepciones.*;
import java.util.List;

//Interfcae de interaccion con nuestros recursos
public interface IAccesoDatos {

    //Metodo que comprueba si existe el recurso
    boolean existe(String nombreRecurso)
            //Lanza excepcion en la firma del metodo
            throws AccesoDatosEx;

    //Metodo listar que devuelve objetos de tipo pelicula
    List<Pelicula> listar(String nombreRecurso)
            //Lanza excepcion en la firma del metodo
            throws LecturaDatosEx;

    //Metodo que no devuelve valor y que comprueba si se agrega al recurso de tipo pelicula
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar)
            //Excepcion en la firma del metodo
            throws EscrituraDatosEx;

    //Metodo para buscar una pelicula
    String buscar(String nombreRecurso, String buscar)
            //Lanza excepcion en la firma del metodo
            throws LecturaDatosEx;

    //Metodo que permite crear un recurso
    void crear(String nombreRecurso)
            //Lanza excepcion en la firma del metodo
            throws AccesoDatosEx;

    //Metodo que elimina un recurso
    void borrar(String nombreRecurso)
            //Lanza excepcion en la firma del metodo
            throws AccesoDatosEx;
}
