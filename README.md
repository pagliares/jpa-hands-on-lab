# JPA Hands-on lab

Repository with source code to be used in the hands-on lab about JPA. This hands-on lab is used as part of the JPA hands-on classes taught by Rodrigo Martins Pagliares at UNIFAL-MG (Computer Science undergraduate course).

## UML Class Diagram and Entity Relationship Diagram for a bookstore

<p align="center"><img src="https://github.com/pagliares/jpa-hands-on-lab/blob/main/Images/Class_Diagram.png"></p>

<p align="center"><img src="https://github.com/pagliares/jdbc-hands-on-lab/blob/main/Images/DER.png"></p>


## MySQL

Before running the examples in this repository, make sure that:

- You have started MySQL (the examples use the default port, 3306)
- You have created a database called bookstore_jpa

### MySQL database used in this lab:
   - bookstore_jpa

### MySQL credentials used in this lab:
   - user: florentino
   - password: 123456

In this hands-on, the  user florentino is created with aid of **PHP MyAdmin** that comes bundled with **MAMP**. The user florentino is granted all privileges a root user has (also with the aid of **PHP MyAdmin**), but for security reasons it is recommend to grant the least privilege possible to the user in order to complete the lab. 

### The database bookstore_jpa used in this course:

In this hands-on, the database bookstore_jpa is created with aid of **PHP MyAdmin** that comes bundled with **MAMP**.

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

You also need to include the Eclipse Link JPA implementation as dependencies on pom.ml.
   - <strong>Note</strong> this hands-on uses Eclipse Link as JPA implementation. If you decide do use Hibernate, you need use the hibernate dependencies on pom.xml and not the org.eclipse.persistence.jpa shown below.

 <!-- https://mvnrepository.com/artifact/org.eclipse.persistence/org.eclipse.persistence.jpa -->
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>org.eclipse.persistence.jpa</artifactId>
            <version>4.0.0</version>
        </dependency>

### Solution to this hands-on lab

The directory Source_Code of this repository has a Maven project with the solution for this hands-on lab that the student can use to compare with his/her solution.

