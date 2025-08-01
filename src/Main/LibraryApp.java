package Main;

import Model.LibraryModel;
import Service.LibServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LibraryApp {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        LibServiceImpl libService = new LibServiceImpl();

        String[] actions = {"1. Add a book", "2. Show the book", "3. Delete any book", "4. Find a book"};

        System.out.println("Welcome to Library App");
        System.out.println("---------------------------------");
        System.out.println("What do you want to do today?");
        System.out.println("---------------------------------");

        for(int i=0; i<actions.length; i++){
            System.out.println(actions[i]);
        }
        System.out.println("---------------------------------");

        boolean flag = true;

        while (flag){
            System.out.print("Your choice: ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("---------------------------------");
                System.out.println("Give the correct input!!");
                break;
            }
            sc.nextLine(); //nextInt does not read enter so it passes on to the next scanner, which gives exception
            System.out.println("---------------------------------");

            if(choice == 1){
                int id;
                String name;
                String author;
                try {
                    System.out.print("Enter book's ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); //nextInt does not read enter so it passes on to the next scanner, which gives exception
                    System.out.print("Enter book's name: ");
                    name = sc.nextLine();
                    System.out.print("Enter book's author: ");
                    author = sc.nextLine();
                    System.out.println("---------------------------------");
                }
                catch (InputMismatchException e){
                    System.out.println("---------------------------------");
                    System.out.println("Give the correct input!!");
                    break;
                }

                libService.addBook(new LibraryModel(id, name, author));
                System.out.println("---------------------------------");
            } else if (choice == 2) {
                libService.showBooks();
                System.out.println("---------------------------------");
            } else if (choice ==3) {
                System.out.print("Enter the ID of book you want to delete: ");
                int deleteBook = sc.nextInt();
                sc.nextLine(); //nextInt does not read enter so it passes on to the next scanner, which gives exception
                System.out.println("---------------------------------");

                libService.deleteBooks(deleteBook);
                System.out.println("---------------------------------");
            } else if (choice == 4) {
                System.out.print("Enter the name of the book you want to find: ");
                String bookName = sc.nextLine();
                System.out.println("---------------------------------");

                libService.findBooks(bookName);
                System.out.println("---------------------------------");
            }
            else {
                System.out.println("Choose the correct option!");
                System.out.println("---------------------------------");
            }

            System.out.print("Anything else? ");
            String nextAction = sc.nextLine();
            if (nextAction.equalsIgnoreCase("no")) {
                flag = false; // stops the loop
            }
            System.out.println("---------------------------------");
        }
    }
}