package es.idm.peliculas.datos;

import es.idm.peliculas.domain.Pelicula;
import es.idm.peliculas.excepciones.*;
import java.io.*;
import java.util.*;

//Implementacion de la interface de accesodatos
public class AccesoDatosImpl implements IAccesoDatos {

    //METODOS DE LA IMPLEMENTACION
    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {

        //Se crea un objeto de tipo archivo (File) y comprueba si existe en nuestro HDD
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        //Se crea objeto de tipo File
        var archivo = new File(nombreRecurso);
        //Variable que va ha recibir los objetos de tipo Pelicula
        List<Pelicula> peliculas = new ArrayList<>();
        //Bloque try-catch autogenerado para controlar la excepcion
        try {
            //BufferedReader para leer nuestro archivo
            var entrada = new BufferedReader(new FileReader(archivo));
            //Variable que almacema cada una de las lineas
            String linea = null;
            linea = entrada.readLine();
            //Bucle while para comprobar todas las lineas
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
            }
            entrada.close(); //Finaliza el ciclo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            //Objeto para escribir archivo
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas" + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            /*Permite crear archivo con PrintWriter, hay que envolverlo con FileWriter
            y pasar como parametro el archivo o el argumento que necesitemos.
             */
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();//Al cerrar el archivo permite que se cree
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }

}
