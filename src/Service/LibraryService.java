package Service;

import Model.LibraryModel;

import java.util.List;

public interface LibraryService {
    void addBook(LibraryModel lib);
    List<LibraryModel> showBooks();
    void deleteBooks(int id);
    LibraryModel findBooks(String name);
}
