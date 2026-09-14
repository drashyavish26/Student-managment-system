# Project Statement

## Student Management System

### 1. Introduction

The Student Management System is a Java-based desktop application developed to manage student information and academic performance in an organized and efficient way.

The system provides a simple graphical user interface (GUI) through which an administrator can manage students, enter marks, and generate student performance reports.

---

### 2. Problem Statement

Managing student information and academic records manually can be time-consuming and difficult to maintain.

The purpose of this project is to develop a simple computerized system that can:

- Store student information
- Add, update, search, and delete student records
- Store and manage student marks
- Calculate percentages and grades
- Generate performance reports
- Maintain student and marks data using CSV files

---

### 3. Objectives

The main objectives of this project are:

1. To develop a user-friendly Student Management System.
2. To implement student record management using Java.
3. To manage academic marks for individual students.
4. To automatically calculate percentages and grades.
5. To generate performance reports.
6. To store data permanently using CSV files.
7. To implement exception handling for invalid inputs.
8. To provide a simple and organized graphical user interface.

---

### 4. Scope of the Project

The system is designed for basic academic record management.

The current system includes:

- Administrator login
- Student management
- Marks management
- Student search functionality
- Student performance reports
- Percentage calculation
- Grade calculation
- CSV-based data storage
- Input validation and exception handling

The project can be further extended in the future with features such as database integration, multiple user roles, attendance management, graphical performance charts, and report export.

---

### 5. Technologies Used

- **Programming Language:** Java
- **GUI:** Java Swing
- **Data Storage:** CSV Files
- **Development Environment:** Visual Studio Code
- **Version Control:** Git & GitHub

---

### 6. Project Structure

The project follows a basic layered structure:

```text
Student-management-system/
│
├── data/
│   ├── Students.csv
│   └── marks.csv
│
├── src/
│   ├── exception/
│   ├── gui/
│   ├── model/
│   └── service/
│
├── .gitignore
├── README.md
└── statement.md
