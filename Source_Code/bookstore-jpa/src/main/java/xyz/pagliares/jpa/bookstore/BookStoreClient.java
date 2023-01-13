package xyz.pagliares.jpa.bookstore;

import xyz.pagliares.jpa.bookstore.controller.BookControllerInterface;
import xyz.pagliares.jpa.bookstore.controller.BookControllerJDBC;
import xyz.pagliares.jpa.bookstore.controller.BookControllerJPA;
import xyz.pagliares.jpa.bookstore.domain.Book;
import xyz.pagliares.jpa.bookstore.domain.Chapter;
import xyz.pagliares.jpa.bookstore.domain.Publisher;

import java.util.ArrayList;
import java.util.List;

public class BookStoreClient {
    public static void main(String[] args) {
        // BookControllerInterface bookController = new BookControllerJDBC();
        BookControllerInterface bookController = new BookControllerJPA();

        //configuring the object graph
        Publisher publisher = new Publisher("Artech House");
        Book book = new Book("158053791X", "A Practitioner's Guide to Software Test Design ", publisher);

        book.addChapter(new Chapter("The Testing Process", 1));
        book.addChapter(new Chapter("Case Studies", 2));
        book.addChapter(new Chapter("Equivalence Class Testing", 3));
        book.addChapter(new Chapter("Boundary Value Testing", 4));
        book.addChapter(new Chapter("Decision Table Testing", 5));
        book.addChapter(new Chapter("Pairwise Testing", 6));
        book.addChapter(new Chapter("State-Transition Testing", 7));
        book.addChapter(new Chapter("Domain Analysis Testing", 8));
        book.addChapter(new Chapter("Use Case Testing", 9));
        book.addChapter(new Chapter("Control Flow Testing", 10));
        book.addChapter(new Chapter("Data Flow Testing", 11));
        book.addChapter(new Chapter("Scripted Testing", 12));
        book.addChapter(new Chapter("Exploratory Testing", 13));
        book.addChapter(new Chapter("Test Planning", 14));
        book.addChapter(new Chapter("Defects Taxonomy", 15));
        book.addChapter(new Chapter("When Stop Testing", 16));

        // Persisting th e Book
        bookController.persistBook(book);

        //retrieving object graph
        book = bookController.retrieveBook("158053791X");
		System.out.println(book);
    }
}
