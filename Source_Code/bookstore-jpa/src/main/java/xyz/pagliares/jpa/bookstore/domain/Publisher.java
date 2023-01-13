package xyz.pagliares.jpa.bookstore.domain;

import jakarta.persistence.*;
/**
 * Exercise: Test other strategies of primary key (instead of numerical,
 * auto-increment. One  example below:
 *
 * @Id
 * @Column(name = "CODE", unique = true, nullable = false, length = 4)
 * private String code;
 *
 * How this change would impact the methods that find by Id?
 */
@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer publisherID;

	@Column(name = "PUBLISHER_NAME", nullable = false, length = 100)
	private String name;

	public Publisher() {}	
	public Publisher(String name) {
		this.name = name;
	}

	public Integer getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(Integer publisherID) {
		this.publisherID = publisherID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "\n";
	}	
}














