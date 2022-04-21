package es.idm.todolist;

import java.util.Scanner;

/**
 *
 * @author IDM
 */
public class start {
    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        
        int option = 0;
        
        System.out.println("TO DO LIST");
        System.out.println("----------");
        
        //Do-While loop for the menu
        do {
            
            System.out.println("1. Create List.");
            System.out.println("2. Read List.");
            System.out.println("3. Update List.");
            System.out.println("4. Delete List.");
            System.out.println("5. Exit.");
            
            option = kb.nextInt();
            
            
            switch (option) {
                case 1:
                    todolistService.createList();
                    break;
                case 2:
                    todolistService.readList();
                    break;
                case 3:
                    todolistService.updateList();
                    break;
                case 4:
                    todolistService.deleteList();
                    break;
                default:
                    break;
            }
        }while(option != 5);
    }
}
