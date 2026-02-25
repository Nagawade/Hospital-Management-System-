# Hospital Management System

A robust and secure backend system for managing hospital operations, built with **Spring Boot**, **Spring Security (JWT)**, and **MySQL**. This application provides a platform for patients to book appointments, doctors to manage their schedules, and administrators to oversee the hospital's departments and staff.

## 🚀 Features

- **User Authentication & Authorization**: 
  - Secure Signup and Login using **JWT (JSON Web Tokens)**.
  - Role-based Access Control (RBAC) for **Admin**, **Doctor**, and **Patient**.
- **Patient Management**:
  - Patient profile registration and management.
  - Ability to view available doctors and book appointments.
- **Doctor Management**:
  - Doctoral dashboard to view assigned appointments.
  - Categorization of doctors by **Departments**.
- **Appointment System**:
  - Real-time appointment booking.
  - Tracking appointment history for both patients and doctors.
- **Insurance Integration**:
  - Management of patient insurance details linked to their profiles.

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.x (Spring Boot 4.0.0 Parent)
- **Language**: Java 21
- **Security**: Spring Security + JWT
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **Mapper**: ModelMapper (for DTO conversions)
- **Utilities**: Lombok (to reduce boilerplate)
- **Testing**: JUnit 5, Spring Boot Test

## 📋 Prerequisites

Before running the application, ensure you have the following installed:
- [Java 21 JDK](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.x](https://maven.apache.org/download.cgi)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)

## ⚙️ Configuration

1. Create a MySQL database named `HospitalDB`:
   ```sql
   CREATE DATABASE HospitalDB;
   ```

2. Update the `src/main/resources/application.properties` file with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/HospitalDB
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   server.servlet.context-path=/hospitaldb
   ```

3. (Optional) Customize the JWT secret key in `application.properties`:
   ```properties
   jwt.secretKey=your_very_long_and_secure_secret_key
   ```

## 🏃 Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/Nagawade/Hospital-Management-System.git
   cd Hospital-Management-System
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   The server will start at `http://localhost:8080/hospitaldb`.

## 📡 API Endpoints (Brief Overview)

### Authentication
- `POST /auth/signup` - Register a new user.
- `POST /auth/login` - Authenticate user and receive JWT.

### Patients
- `GET /patients/{id}` - Retrieve patient details.
- `POST /patients` - Create/Book a new appointment.

### Doctors
- `GET /doctor/appointments` - Get all appointments assigned to the logged-in doctor.

## 📂 Project Structure

```text
src/main/java/com/springboot/project/HospitalManagent/
├── controller      # REST Controllers
├── dto             # Data Transfer Objects
├── entity          # JPA Entities
├── repository      # Spring Data Repositories
├── service         # Business Logic Layer
├── Security        # Security Configuration & JWT Logic
└── Configuration   # General App Configurations
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

---
Developed by **Mauli Nagawade** 
