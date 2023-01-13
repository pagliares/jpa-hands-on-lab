package xyz.pagliares.jpa.bookstore.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Test other strategies of primary key (instead of numerical,
 * auto-increment. One  example below:
 *
 * @Id
 * @Column(name = "ISBN", unique = true, nullable = false, length = 50)
 * private String isbn;
 *
 * How this change would impact the methods that find by Id?
 */
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	private String isbn;

	@Column(name = "BOOK_NAME", nullable = false, length = 100)
	private String name;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="PUBLISHER_ID")
	private Publisher publisher;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<Chapter> chapters = new ArrayList<>();;
	
	public Book() {

	}
	public Book(String isbn, String name, Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public void addChapter(Chapter chapter) {
		this.chapters.add(chapter);
	}
	public void removeChapter(Chapter chapter) {
		this.chapters.remove(chapter);
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Book \n" +
				"Title = " + name + "\n" +
				"Publisher = " + publisher +
				"ISBN = " + isbn + "\n" +
				"Chapters:\n");
		for (Chapter chapter: chapters)
			output.append(chapter.toString());
		return output.toString();
	}
}












































