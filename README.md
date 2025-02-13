# Clothes

Clothes is my first Spring Boot monolithic project. It is an e-commerce platform for clothing that includes features such as user management, shopping cart, order processing, payment integration, and product catalog.

## 📌 About the Project
This project follows a monolithic architecture and demonstrates fundamental backend development principles, including:
- RESTful API design
- Spring Boot framework
- Database interactions using JPA and Hibernate
- User authentication and authorization
- Exception handling and logging

## 🚀 Technologies
- **Java 17** - Backend development
- **Spring Boot** - Framework for backend services
- **Spring Data JPA** - ORM for database interactions
- **Spring Security** - User authentication and authorization
- **MySQL** - Database
- **Lombok** - Reducing boilerplate code
- **MapStruct** - Object mapping

## 📂 Project Structure
```
clothes/
│── src/
│   ├── main/
│   │   ├── java/com/e_commerce/clothes/
│   │   │   ├── config/        # Configuration files
│   │   │   ├── domain/
│   │   │   │   ├── entity/ cart, order, and more    # Entity classes
│   │   │   │   ├── exception/    # Custom exception handling
│   │   │   ├── repository/    # Database repositories
│   │   │   ├── service/       # Business logic services
│   │   │   ├── web/
│   │   │   │   ├── controller/ cart, order, and more    # REST API controllers
│   │   │   │   ├── dto/    # Data Transfer Objects
│   │   │   │   ├── mapper/    # Object mapping
│   │   ├── resources/
│   │   │   ├── application.yml # Configuration properties
```

## 🔧 How to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/don1yal/clothes.git
   ```
2. Navigate to the project directory:
   ```sh
   cd clothes
   ```
3. Build the project:
   ```sh
   mvn clean package
   mvn spring-boot:run
   ```
4. The application will start on http://localhost:8080

## 📌 Contact

If you have any questions or suggestions, feel free to reach out:

#### GitHub: don1yal
#### Email: orynbekdanial8@gmail.com