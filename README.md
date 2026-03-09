# MyDoctorApp

MyDoctorApp is a web-based healthcare management system that allows patients to find doctors, book appointments, and attend online consultations. The platform helps simplify appointment scheduling and enables doctors to manage their availability and patient requests efficiently.

The application is built using **Java and Spring Boot** with a modular architecture. The frontend provides an easy-to-use interface for users, while the backend handles the business logic, database operations, and RESTful services.

The goal of this project is to demonstrate how modern web technologies can be used to create a digital healthcare service platform where patients and doctors can interact in a structured and organized way.

---

# Features

### Patient Features

* Register and login to the platform
* Search doctors by specialization, city, and state
* View doctor profiles and availability
* Book appointments based on available time slots
* View appointment history
* Join online consultation sessions

### Doctor Features

* Register and manage doctor profile
* Set availability and appointment slots
* Mark unavailable dates or leave days
* View and manage patient appointments
* Accept or reject appointment requests
* Conduct online video consultations

### System Features

* Appointment scheduling with slot management
* Email notifications for appointment updates
* Secure password management
* RESTful API based backend architecture

---

# Technologies Used

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML
* CSS
* JavaScript

### Database

* MySQL

### Additional Tools

* Maven (Build Tool)
* Zego Video SDK (for video consultation)
* Java Mail API (for email notifications)

---

# Project Structure

The project is divided into two main modules:

```
MyDoctorApp
│
├── Doctors
│   ├── Controllers
│   ├── Templates (Thymeleaf pages)
│   └── Configuration
│
└── Doctors-RESTfulWebservices
    ├── Controllers
    ├── Services
    ├── Repositories
    ├── Models
    └── Mail Services
```

**Doctors Module**
Handles the user interface and communicates with the backend services.

**Doctors-RESTfulWebservices Module**
Contains the REST APIs, business logic, database interaction, and email services.

---

# Installation and Setup

### 1. Clone the Repository

```bash
https://github.com/prajapatiiranjeet/MyDoctorApp.git
cd MyDoctorApp
```

### 2. Configure Database

Create a MySQL database:

```
doctors
```

Update the `application.properties` file with your database credentials.

Example:

```
spring.datasource.url=jdbc:mysql://localhost:3306/doctors
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

### 3. Run the Backend Service

Navigate to the REST service module:

```bash
cd Doctors-RESTfulWebservices
mvn spring-boot:run
```

---

### 4. Run the Frontend Module

```bash
cd Doctors
mvn spring-boot:run
```

---

### 5. Access the Application

Open your browser and visit:

```
http://localhost:7070
```

---

# How It Works

1. Users register and log in to the system.
2. Patients search for doctors based on specialization or location.
3. Patients select an available time slot and book an appointment.
4. Doctors manage their schedules and respond to appointment requests.
5. Patients and doctors can join online consultation sessions.

---

# Future Improvements

Some features that could be added in future versions:

* Online payment integration
* Mobile application support
* Appointment reminders via SMS
* Admin dashboard for system management
* Improved security with token-based authentication

---

# License

This project is created for educational and learning purposes.

