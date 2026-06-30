# 🎓 Student Management System

A console-based Student Management System developed using **Java**, **JDBC**, and **MySQL**. This project demonstrates CRUD (Create, Read, Update, Delete) operations with a MySQL database using JDBC.

---

## 🚀 Features

- ✅ Add Student
- ✅ View All Students
- ✅ Search Student by ID
- ✅ Search Student by Name
- ✅ Update Student Details
- ✅ Delete Student
- ✅ Menu-driven Console Application

---

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA
- Git & GitHub

---

## 📂 Project Structure

```
StudentManagementSystem
│
├── src
│   ├── dao
│   │   └── StudentDAO.java
│   │
│   ├── model
│   │   └── Student.java
│   │
│   ├── util
│   │   └── DBConnection.java
│   │
│   └── Main.java
│
├── README.md
```

---

## 📋 Database Schema

Database Name:

```sql
studentdb
```

Table:

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100),
    email VARCHAR(100)
);
```

---

## ⚙️ How to Run

1. Clone the repository.

```
git clone https://github.com/Ummera-Sultana/Student_Management_System.git
```

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database.

4. Create the `students` table using the SQL above.

5. Update your database URL, username, and password in `DBConnection.java`.

6. Add the MySQL Connector JAR to the project.

7. Run `Main.java`.

---
## 🔄 Project Workflow

```text
           User
             │
             ▼
        Main.java
             │
             ▼
       StudentDAO.java
             │
             ▼
     DBConnection.java
             │
             ▼
        MySQL Database
```

### Workflow Explanation

1. The user selects an option from the menu in **Main.java**.
2. `Main.java` collects the user input.
3. The request is sent to **StudentDAO.java**.
4. `StudentDAO.java` uses **DBConnection.java** to connect to the MySQL database.
5. The SQL query is executed.
6. The database returns the result.
7. The result is displayed back to the user through `Main.java`.

## 📸 Features Implemented

- Create Student
- Read Student Details
- Search Student by ID
- Search Student by Name
- Update Student
- Delete Student

---

## 🎯 Future Improvements

- Input Validation
- Exception Logging
- Better Console UI
- Maven Support
- Spring Boot Version
- REST API
- GUI Version (JavaFX/Swing)

---

## 👩‍💻 Author

**Ummera Sultana**

Computer Science & Engineering Student

GitHub: https://github.com/Ummera-Sultana

---

## ⭐ If you like this project

Give this repository a ⭐ on GitHub.
