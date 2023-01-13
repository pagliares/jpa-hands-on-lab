package xyz.pagliares.jpa.bookstore.controller;

import xyz.pagliares.jpa.bookstore.domain.Book;

public interface BookControllerInterface {
    void persistBook(Book book);

    Book retrieveBook(String isbn);
}
