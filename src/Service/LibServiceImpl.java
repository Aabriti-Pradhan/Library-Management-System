package Service;

import Model.LibraryModel;

import java.util.ArrayList;
import java.util.List;

public class LibServiceImpl implements LibraryService {

    ArrayList<LibraryModel> listOfBooks = new ArrayList<>();

    @Override
    public void addBook(LibraryModel lib) {
        for (LibraryModel book : listOfBooks) {
            if (book.getId() == lib.getId()) {
                System.out.println("Book with this ID already exists!");
                return;
            } else if (book.getTitle().equalsIgnoreCase(lib.getTitle())) {
                System.out.println("Book with this title already exists!");
                return;
            }
        }
        listOfBooks.add(lib);
        System.out.println("Successfully added!");
    }

    @Override
    public List<LibraryModel> showBooks() {
        if (listOfBooks.isEmpty()) {
            System.out.println("No books available.");
        } else {
            listOfBooks.forEach(System.out::println);
        }
        return listOfBooks;
    }

    @Override
    public void deleteBooks(int id) {
        for (int i=0; i<listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getId() == id) {
                listOfBooks.remove(i);
                System.out.println("Deleted successfully!");
            }
            else {
                System.out.println("ID does not exist!");
            }
        }
    }

    @Override
    public LibraryModel findBooks(String name) {
        String didNotFind = "no";
        for (LibraryModel book : listOfBooks){
            if (book.getTitle().equalsIgnoreCase(name)){
                System.out.println(book);
                didNotFind = "no";
                break;
            }
            else {
                didNotFind = "yes";
            }
        }
        if(didNotFind.equalsIgnoreCase("yes")) {
            System.out.println("Book not found!");
        }
        return null;
    }
}
