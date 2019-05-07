package hello;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;


@RestController

public class BookCatalogController {

private static final String template = "Hello, %s!";

private final AtomicLong counter = new AtomicLong();

private BookCatalog bookCatalog = new BookCatalog();

private Book bookObj = new Book("48 Laws Of Power", "0-7645-2641-3", "Robert Greene", 26.50, 4);

// Section: GET requests -----------------------------

@RequestMapping("/catalog/db")

public ResponseEntity<ArrayList<Book>> getOtherBooks() {

return new ResponseEntity<>(bookCatalog.getOtherBooks(), HttpStatus.OK);

}
//A comment to show a GitHub push.
/*
@RequestMapping("/book")

public ResponseEntity<Book> book(@RequestParam(value = "name", defaultValue = "World") String name) {

return new ResponseEntity<>(new Book(counter.incrementAndGet(), String.format(template, name)),

HttpStatus.OK);

}
*/
// Section: POST requests ----------------------------

// This RequestMapping says to map addName() method to any POST request on /greeting

@RequestMapping(value = "/title", method = POST)

public ResponseEntity<?> addOtherTitles(@RequestBody String name) {

bookObj.addOtherTitles(name);

// Because there is no validation, we can return that the request succeeded.

return new ResponseEntity<>(HttpStatus.OK);

}

@RequestMapping(value = "/catalog", method = POST)

public ResponseEntity<?> addBook(@RequestBody Book book) {

bookCatalog.addBook(book.getTitle(), book.getISBN(), book.getAuthor(), book.getPrice(), book.getBooksInStock());

// Because there is no validation, we can return that the request succeeded.

return new ResponseEntity<>(HttpStatus.OK);

}

@RequestMapping(value="/catalog/{title}",method=PUT)

public ResponseEntity<?>  purchaseBook(@PathVariable String title) {

bookCatalog.purchaseBook(title);

return new ResponseEntity<>(HttpStatus.OK);

}

}
