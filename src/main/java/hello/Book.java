package hello;

import java.util.ArrayList;

public class Book {

  private final String title;

  private final String isbn;

  private final String author;

  private final Double price;

  private int booksInStock;

  private ArrayList<String> otherTitlesArr = new ArrayList<String>() {{

  }};

  public Book(String title, String isbn, String author, Double price, int booksInStock) {

  this.title = title;

  this.isbn = isbn;

  this.author = author;

  this.price = price;

  this.booksInStock = booksInStock;

  }


  public String getTitle() {
    return title;
  }

  public String getISBN() {
    return isbn;
}

  public String getAuthor() {
    return author;
  }

  public Double getPrice() {
    return price;
  }

  public int getBooksInStock() {
    return booksInStock;
  }

  public ArrayList<String> getOtherTitles() {

  return otherTitlesArr;

  }

// Setter
  public void addOtherTitles(String name) {

  otherTitlesArr.add(name);

  }

  public void decreaseBooksInStock() {
    this.booksInStock = booksInStock - 1;
  }

}
