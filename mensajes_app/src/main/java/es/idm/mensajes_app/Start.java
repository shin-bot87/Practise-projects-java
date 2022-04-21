package es.idm.mensajes_app;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        
        //CRECION DEL MENU DE OPCIONES
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do {
            System.out.println("-----------------");
            System.out.println(" Aplicacion de Mensajes");
            System.out.println(" 1. Crear Mensaje");
            System.out.println(" 2. Listar Mensajes");
            System.out.println(" 3. Editar Mensaje");
            System.out.println(" 4. Eliminar Mensaje");
            System.out.println(" 5. Salir");
            System.out.println("");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                //Llama al metodo de crear mensaje en la capa de servicio
                case 1:
                    mensajesService.crearMensaje();
                    break;
                ////Llama al metodo de visualizar mensaje en la capa de servicio
                case 2:
                    mensajesService.listarMensaje();
                    break;
                //Llama al metodo de editar mensaje en la capa de servicio
                case 3:
                    mensajesService.editarMensaje();
                    break;
                //Llama al metodo de eliminar mensaje en la capa de servicio
                case 4:
                    mensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }
            
        } while(opcion != 5);
    }
}
