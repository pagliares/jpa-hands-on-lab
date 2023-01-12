--
-- SQL Script created by Rodrigo Martins Pagliares
-- Last update: 12/03/2022
--
USE bookstore_jdbc;

DROP TABLE IF EXISTS `CHAPTER`;
DROP TABLE IF EXISTS `BOOK`;
DROP TABLE IF EXISTS `PUBLISHER`;

CREATE TABLE PUBLISHER (
	PUBLISHER_ID INT(3) NOT NULL AUTO_INCREMENT,
	PUBLISHER_NAME VARCHAR(100) NOT NULL,
	PRIMARY KEY (PUBLISHER_ID)
);

CREATE TABLE BOOK (
    BOOK_ID BIGINT NOT NULL AUTO_INCREMENT,
	ISBN VARCHAR(10) NOT NULL,
	BOOK_NAME VARCHAR(100) NOT NULL,
	PUBLISHER_ID INT(3),
	PRIMARY KEY (BOOK_ID),
	FOREIGN KEY (PUBLISHER_ID) REFERENCES PUBLISHER (PUBLISHER_ID)
);

CREATE TABLE CHAPTER (
	CHAPTER_ID INT(3) NOT NULL AUTO_INCREMENT,
    BOOK_ISBN VARCHAR(10) NOT NULL,
	CHAPTER_NUM INT NOT NULL,
	TITLE VARCHAR(100) NOT NULL,
    BOOK_ID BIGINT,
	PRIMARY KEY (CHAPTER_ID),
	FOREIGN KEY (BOOK_ID) REFERENCES BOOK (BOOK_ID)
);

--
-- Populating the database
--

-- NOTE: In the SQL INSERT statements that follows, I use @@IDENTITY.
-- @@IDENTITY gives you the last identity value generated
-- by the most recent INSERT statement for the current connection,
-- regardless of table or scope. I use @@IDENTITY in this script
-- to get the ID of the last inserted row in SQL (generated when issuing
-- the INSERT INTO PUBLISHER (PUBLISHER_NAME),
-- INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_ID), and
-- INSERT INTO CHAPTER (BOOK_ISBN, CHAPTER_NUM, TITLE, BOOK_ID)
-- queries presented in this SQL Script.

--
-- Inserting data from the book Software engineering by Ian Sommerville, tenth edition
--

INSERT INTO PUBLISHER (PUBLISHER_NAME)
VALUES ('Pearson');

INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_ID)
VALUES ('0133943038', 'Software Engineering', @@IDENTITY);

INSERT INTO CHAPTER (BOOK_ISBN, CHAPTER_NUM, TITLE, BOOK_ID)
VALUES ('0133943038', 1, 'Introduction', @@IDENTITY),
       ('0133943038', 2, 'Software processes', @@IDENTITY),
       ('0133943038', 3, 'Agile software development', @@IDENTITY),
       ('0133943038', 4, 'Requirements engineering', @@IDENTITY),
       ('0133943038', 5, 'System modeling', @@IDENTITY),
       ('0133943038', 6, 'Architectural design', @@IDENTITY),
       ('0133943038', 7, 'Design and implementation', @@IDENTITY),
       ('0133943038', 8, 'Software testing', @@IDENTITY),
       ('0133943038', 9, 'Software evolution', @@IDENTITY),
       ('0133943038', 10, 'Dependable systems', @@IDENTITY),
       ('0133943038', 11, 'Reliability engineering', @@IDENTITY),
       ('0133943038', 12, 'Safety engineering', @@IDENTITY),
       ('0133943038', 13, 'Security engineering', @@IDENTITY),
       ('0133943038', 14, 'Resilience engineering', @@IDENTITY),
       ('0133943038', 15, 'Software reuse', @@IDENTITY),
       ('0133943038', 16, 'Component-based software engineering', @@IDENTITY),
       ('0133943038', 17, 'Distributed software engineering', @@IDENTITY),
       ('0133943038', 18, 'Service-oriented software engineering', @@IDENTITY),
       ('0133943038', 19, 'Systems engineering', @@IDENTITY),
       ('0133943038', 20, 'System of systems', @@IDENTITY),
       ('0133943038', 21, 'Real-time software engineering', @@IDENTITY),
       ('0133943038', 22, 'Project management', @@IDENTITY),
       ('0133943038', 23, 'Project planning', @@IDENTITY),
       ('0133943038', 24, 'Quality management', @@IDENTITY),
       ('0133943038', 25, 'Configuration management', @@IDENTITY);

--
-- Inserting data from the book Algorithms by Robert Sedgewick and Kevin Wayne, fourth edition
--

INSERT INTO PUBLISHER (PUBLISHER_NAME)
VALUES ('Addison-Wesley Professional');

INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_ID)
VALUES ('032157351X', 'Algorithms', @@IDENTITY);

INSERT INTO CHAPTER (BOOK_ISBN, CHAPTER_NUM, TITLE, BOOK_ID)
VALUES ('032157351X', 1, 'Fundamentals', @@IDENTITY),
       ('032157351X', 2, 'Sorting', @@IDENTITY),
       ('032157351X', 3, 'Searching', @@IDENTITY),
       ('032157351X', 4, 'Graphs', @@IDENTITY),
       ('032157351X', 5, 'Strings', @@IDENTITY),
       ('032157351X', 6, 'Context', @@IDENTITY);

--
-- Inserting data from the book Clean architecture by Robert C. Martin, first edition
--

INSERT INTO PUBLISHER (PUBLISHER_NAME)
VALUES ('Pearson');

INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_ID)
VALUES ('0134494164', "Clean Architecture: A Craftsman's Guide to Software Structure and Design", @@IDENTITY);

INSERT INTO CHAPTER (BOOK_ISBN, CHAPTER_NUM, TITLE, BOOK_ID)
VALUES ('0134494164', 1, 'What is Design and Architecture?', @@IDENTITY),
       ('0134494164', 2, 'A tale of Two Values', @@IDENTITY),
       ('0134494164', 3, 'Paradigm overview', @@IDENTITY),
       ('0134494164', 4, 'Structured programming', @@IDENTITY),
       ('0134494164', 5, 'Object-oriented programming', @@IDENTITY),
       ('0134494164', 6, 'Functional programming', @@IDENTITY),
       ('0134494164', 7, 'SRP: The Single Responsibility Principle', @@IDENTITY),
       ('0134494164', 8, 'OCP: The Open-Closed Principle', @@IDENTITY),
       ('0134494164', 9, 'LSP: The Liskov-Substitution Principle', @@IDENTITY),
       ('0134494164', 10, 'ISP: The Interface Segregation Principle', @@IDENTITY),
       ('0134494164', 11, 'DIP: The Dependency Inversion Principle', @@IDENTITY),
       ('0134494164', 12, 'Components', @@IDENTITY),
       ('0134494164', 13, 'Component Cohesion', @@IDENTITY),
       ('0134494164', 14, 'Component Coupling', @@IDENTITY),
       ('0134494164', 15, 'What is architecture?', @@IDENTITY),
       ('0134494164', 16, 'Independence', @@IDENTITY),
       ('0134494164', 17, 'Boundaries: Drawing lines', @@IDENTITY),
       ('0134494164', 18, 'Boundary Anatomy', @@IDENTITY),
       ('0134494164', 19, 'Policy and Level', @@IDENTITY),
       ('0134494164', 20, 'Business Rules', @@IDENTITY),
       ('0134494164', 22, 'The Clean Architecture', @@IDENTITY),
       ('0134494164', 23, 'Presenters and Humble Objects', @@IDENTITY),
       ('0134494164', 24, 'Partial Boundaries', @@IDENTITY),
       ('0134494164', 25, 'Layers and Boundaries', @@IDENTITY),
       ('0134494164', 26, 'The Main Component', @@IDENTITY),
       ('0134494164', 27, 'Services: Great and Small', @@IDENTITY),
       ('0134494164', 28, 'The Test Boundary', @@IDENTITY),
       ('0134494164', 29, 'Clean Embedded Architecture', @@IDENTITY),
       ('0134494164', 30, 'The Database is a detail', @@IDENTITY),
       ('0134494164', 31, 'The Web is a detail', @@IDENTITY),
       ('0134494164', 32, 'Frameworks are details', @@IDENTITY),
       ('0134494164', 33, 'Case Study: Video Sales', @@IDENTITY),
       ('0134494164', 34, 'The Missing Chapter', @@IDENTITY);
























































