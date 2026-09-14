# Student Management System 🎓

A desktop-based **Student Management System** developed using **Java Swing**.

The application allows users to manage student information, record marks, generate performance reports, and store data permanently using CSV files.

---

## 📌 Features

- 🔐 Admin Login
- 👨‍🎓 Add, update, delete, and search students
- 📋 View all student records
- 📝 Add and manage student marks
- 📊 View marks of individual students
- 📈 Generate student performance reports
- 🎯 Automatic percentage and grade calculation
- 💾 Permanent data storage using CSV files
- 🖥️ Java Swing graphical user interface
- 🚪 Logout functionality
- 🪟 Multiple-window management

---

## 🛠️ Technologies Used

- **Java**
- **Java Swing** – Graphical User Interface
- **Object-Oriented Programming (OOP)**
- **CSV Files** – Data storage
- **Exception Handling**
- **Git & GitHub**

---

## 📂 Project Structure

```text
Student-managment-system/
│
├── data/
│   ├── Students.csv
│   └── marks.csv
│
├── src/
│   ├── exception/
│   │   └── InvalidMarksException.java
│   │
│   ├── gui/
│   │   ├── DashboardFrame.java
│   │   ├── LoginFrame.java
│   │   ├── MarksFrame.java
│   │   ├── ReportFrame.java
│   │   └── StudentFrame.java
│   │
│   ├── model/
│   │   ├── Marks.java
│   │   ├── Student.java
│   │   └── Subject.java
│   │
│   ├── service/
│   │   ├── MarksService.java
│   │   ├── ReportService.java
│   │   └── StudentService.java
│   │
│   └── Main.java
│
├── .gitignore
├── README.md
└── statement.md
