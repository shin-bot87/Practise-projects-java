package es.idm.todolist;

import java.util.Scanner;

/**
 *
 * @author IDM
 */
public class todolistService { //service layer
    
    public static void createList(){
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Type a title for your list");
        String title = kb.nextLine();
        
        todolist list = new todolist();
        list.setNombre_lista(title);
        todolistDAO.createTitleDB(list);
    }
    
    public static void readList() {
        todolistDAO.readListDB();
    }
    
    public static void updateList() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Type your new list");
        String list = kb.nextLine();
        
        System.out.println("Type the list ID to update");
        int idNewList = kb.nextInt();
        
        todolist update = new todolist();
        update.setId_lista(idNewList);
        update.setNombre_lista(list);
        todolistDAO.updateListDB(update);
    }
    
    public static void deleteList() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Type the list ID to delete it");
        int delete = kb.nextInt();
        todolistDAO.deleteListDB(delete);
    }
}
