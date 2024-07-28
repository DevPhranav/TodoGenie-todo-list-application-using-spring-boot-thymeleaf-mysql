# ToDoGenie

## Overview

ToDoGenie is a simple to-do list application built using Spring Boot, Thymeleaf, and MySQL. The application allows users to register, log in, and manage their to-do tasks.

## Features

- User registration and authentication
- Add, edit, and delete to-do tasks
- Mark tasks as completed
- View a list of tasks

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf
- **Database**: MySQL
- **Security**: Spring Security
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ToDoGenie.git
   cd ToDoGenie
   ```
3. **Configure the Database**

Create a MySQL database and update the src/main/resources/application.properties file with your database configurations.

   ```bash
   spring.application.name=ToDoGenie
   spring.datasource.url=jdbc:mysql://localhost:3306/todogenie
   spring.datasource.username=yourMySQLusername
   spring.datasource.password=yourMySQLPassword
   ```
3. **Build the Project**
      Build project through command line by
   ```bash
   mvn clean install
   ```
    or in IntelliJ IDEA by clicking start button it will build and run the project

5. **To Manually run the project**
   ```bash
   mvn spring-boot:run
   ```
6. **Access the Application**

      Open your web browser and go to http://localhost:8080.


  ## Usage

### Register
Go to [http://localhost:8080/register](http://localhost:8080/) to create a new account.

### Login
Go to [http://localhost:8080/login](http://localhost:8080/) to log in with your credentials.

### Add Todo
After logging in, you can add new to-do items by clicking on the "Add Todo" button and filling out the form.

### Edit Todo
You can edit existing to-do items by clicking on the "Edit" button next to each item.

### Delete Todo
You can delete existing to-do items by clicking on the "Delete" button next to each item.

### Mark as Completed
You can mark tasks as completed by checking the "Completed" checkbox next to each item.


## Acknowledgments

- [Spring Boot documentation](https://spring.io/projects/spring-boot)
- [Thymeleaf documentation](https://www.thymeleaf.org/documentation.html)
- [MySQL documentation](https://dev.mysql.com/doc/)









