package es.idm.peliculas.excepciones;

//Convertir a RuntimeException
public class AccesoDatosEx extends Exception {
    
    //Constructor con argumentos
    public AccesoDatosEx(String mensaje){
        
        //Hereda de la clase padre
        super(mensaje);
    }
}
