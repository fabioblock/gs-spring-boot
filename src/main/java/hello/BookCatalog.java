package hello;

import java.util.ArrayList;

public class BookCatalog {

  private ArrayList <Book> bookCatalog = new ArrayList<Book>() {

  };

  public void addBook(String title, String isbn, String author, Double price, int booksInStock) {
    Book newBook = new Book(title, isbn, author, price, booksInStock);

    bookCatalog.add(newBook);
  }

  public void purchaseBook(String title) {

    for (int i = 0; i < bookCatalog.size(); i++) {
      if (bookCatalog.get(i).getTitle().equals(title)) {
        bookCatalog.get(i).decreaseBooksInStock(); //Decrease book count by 1 on purchase;
      }
    }

  }

  public ArrayList<Book> getOtherBooks() {

  return bookCatalog;

  }

}
