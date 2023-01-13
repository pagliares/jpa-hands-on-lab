package xyz.pagliares.jpa.bookstore.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import xyz.pagliares.jpa.bookstore.domain.Book;
import xyz.pagliares.jpa.bookstore.utility.DatabaseUtility;

public class BookControllerJPA implements BookControllerInterface {
	private EntityManager entityManager;

	public BookControllerJPA() {
		this.entityManager = DatabaseUtility.getEntityManager();
	}

	public void persistBook(Book book) {
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
	}
	
	public Book retrieveBook(String isbn) {
		String queryString = "SELECT b FROM Book b WHERE b.isbn= :isbn";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("isbn", isbn);
		return (Book)query.getSingleResult();
	}
}




