
# Car Rental Spring Boot Application

## Overview

The Car Rental Spring Boot Application is a web-based platform that allows users to rent cars, manage bookings, and interact with car owners. This application is built using Spring Boot, Hibernate, and MySQL, providing a seamless car rental experience.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Application Structure](#application-structure)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- User registration and login.
- Car owners can list their cars for rent.
- Customers can search and book available cars.
- Booking management for both customers and car owners.
- User-friendly interfaces for various tasks.
- Seamless integration with a MySQL database.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.
- MySQL database installed and running.
- Apache Maven for building the project.
- Git for version control (optional).

## Getting Started

1. Clone the repository:

   ```shell
   git clone https://github.com/yourusername/car-rental-app.git
   ```

2. Open the project in your preferred IDE.

3. Configure the `application.properties` file with your MySQL database credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/rentCarProjectApp
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Build the project using Maven:

   ```shell
   mvn clean install
   ```

5. Run the Spring Boot application:

   ```shell
   mvn spring-boot:run
   ```

6. Access the application in your web browser at `http://localhost:8080`.

## Application Structure

The project structure is organized as follows:

- `src/main/java`: Java source code.
- `src/main/resources`: Configuration files.
- `src/main/webapp`: JSP views and static resources.
- `src/test`: Unit and integration tests.

## Configuration

- Hibernate configuration: The Hibernate configuration is defined in `hibernate.cfg.xml`, specifying database connection details and mapping classes.

## Usage

1. Register as a new user or log in if you already have an account.
2. Car Owners:
    - Add cars for rent.
    - Manage your car listings.
    - View booking requests.
    - Update car details.
    - Mark bookings as completed.
3. Customers:
    - Search for available cars.
    - Make bookings.
    - View your bookings.
    - Cancel bookings (within allowed time).
    - Return rented cars.

## Contributing

Contributions are welcome! Feel free to open issues and pull requests to help improve this project.

---


