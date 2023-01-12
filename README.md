# JDBC Hands-on lab

Repository with source code to be used in the exercise about JDBC. The repository also contains an Apache Maven project with the solution of the exercise that the students can use to constrat with their solution

This hands-on lab is used as part of the JDBC hands-on course taught by Rodrigo Martins Pagliares at UNIFAL-MG (Computer Science undergraduate course).

## UML Class Diagram and Entity Relationship Diagram for a bookstore

<p align="center"><img src="https://github.com/pagliares/jdbc-hands-on-lab/blob/main/Images/Class_Diagram.png"></p>

<p align="center"><img src="https://github.com/pagliares/jdbc-hands-on-lab/blob/main/Images/DER.png"></p>


## MySQL

Before running the examples in this repository, make sure that:

- You have started MySQL (the examples use the default port, 3306)
- You have created a database called bookstore_jdbc


### MySQL database used in this lab:
   - bookstore_jdbc

### MySQL credentials used in this lab:
   - user: florentino
   - password: 123456

In this hands-on, the  user florentino is created with aid of **PHP MyAdmin** that comes bundled with **MAMP**. The user florentino is granted all privileges a root user has (also with the aid of **PHP MyAdmin**), but for security reasons it is recommend to gratl the least privilege possible to the user in order to complete the lab. 

### The database bookstore_jdbc used in this course:

In this hands-on, the database bookstore_jdbc is created with aid of **PHP MyAdmin** that comes bundled with **MAMP**.

An SQL script is used to create and populate the tables in the MySQL database (See SQL_Script folder in this repository).

SQL_Script/bookstore.sql
Use PHP MyAdmin, MySQL monitor (from terminal/console) or any other SQL front-end to import/execute the scripts contents.
   
### MySQL Connector/J

To configure the **JDBC Driver for MySQL (Connector/J)** on **Apache Maven**, include the following lines on the dependencies section of pom.xml (Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java):

     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>

To configure the **JDBC Driver for MySQL (Connector/J)** on **Gradle**, include the following line on the dependencies section of the build.gradle (Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java):

<code>implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'</code>

### Solution to this hands-on lab

The directory Source_Code of this repository has a Maven project with the solution for this hands-on lab that the student can use to compare with his/her solution.

