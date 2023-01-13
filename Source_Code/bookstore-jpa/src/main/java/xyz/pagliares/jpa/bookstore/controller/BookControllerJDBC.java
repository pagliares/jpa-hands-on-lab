package xyz.pagliares.jpa.bookstore.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import xyz.pagliares.jpa.bookstore.domain.Book;
import xyz.pagliares.jpa.bookstore.domain.Chapter;
import xyz.pagliares.jpa.bookstore.domain.Publisher;
import xyz.pagliares.jpa.bookstore.utility.DatabaseUtility;
import xyz.pagliares.jpa.bookstore.utility.RDBMS;

public class BookControllerJDBC implements BookControllerInterface {
	private Connection connection = null;
	private ResultSet keys = null;
	@Override
	public void persistBook(Book book) {
		try {
			connection = DatabaseUtility.getConnection(RDBMS.MYSQL);

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (PUBLISHER_NAME) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, book.getPublisher().getName());
			int affected = stmt.executeUpdate();
			if (affected == 1) {
				keys = stmt.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				book.getPublisher().setPublisherID(newKey);
			} else {
				System.err.println("No rows affected");
			}
			
			stmt.close();
			
			stmt = connection.prepareStatement("INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_ID) VALUES (?, ?, ?)");
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getName());
			stmt.setInt(3, book.getPublisher().getPublisherID());
			stmt.executeUpdate();

			stmt.close();
			
			stmt = connection.prepareStatement("INSERT INTO CHAPTER (BOOK_ISBN, CHAPTER_NUM, TITLE) VALUES (?, ?, ?)");
			for(Chapter chapter: book.getChapters()) {
				stmt.setString(1, book.getIsbn());
				stmt.setInt(2, chapter.getChapterNumber());
				stmt.setString(3, chapter.getTitle());
				stmt.executeUpdate();
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (keys != null)
					keys.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace(); }
		}
	}
	
	@Override
	public Book retrieveBook(String isbn) {
		Book book = null;
		try {
			connection = DatabaseUtility.getConnection(RDBMS.MYSQL);

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BOOK, PUBLISHER WHERE BOOK.PUBLISHER_ID = PUBLISHER.PUBLISHER_ID AND BOOK.ISBN = ?");
			stmt.setString(1, isbn);
			
			ResultSet rs = stmt.executeQuery();
			
			book = new Book();
			if (rs.next()) {
				book.setIsbn(rs.getString("ISBN"));
				book.setName(rs.getString("BOOK_NAME"));
				
				Publisher publisher = new Publisher();
				publisher.setPublisherID(rs.getInt("PUBLISHER_ID"));
				publisher.setName(rs.getString("PUBLISHER_NAME"));
				book.setPublisher(publisher);
			}
			
			rs.close();
			stmt.close();
			
			List<Chapter> chapters = new ArrayList<Chapter>();
			stmt = connection.prepareStatement("SELECT * FROM CHAPTER WHERE BOOK_ISBN = ?");
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Chapter chapter = new Chapter();
				chapter.setTitle(rs.getString("TITLE"));
				chapter.setChapterNumber(rs.getInt("CHAPTER_NUM"));		
				chapters.add(chapter);
			}
			book.setChapters(chapters);
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return book;
	}
}




