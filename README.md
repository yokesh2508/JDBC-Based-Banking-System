# Bank Account Management System

## 📌 Project Overview

The Bank Account Management System is a console-based Java application designed to simulate core banking operations using Java, JDBC, and PostgreSQL. The system allows users to create, view, update, and delete bank accounts while maintaining account information in a relational database.

This project was developed to gain practical experience in Java backend development, database management, and JDBC connectivity. It demonstrates how Java applications interact with databases to perform CRUD (Create, Read, Update, Delete) operations in real-world scenarios.

---

## 🎯 Objectives

* To understand JDBC connectivity and database integration.
* To implement CRUD operations using Java and PostgreSQL.
* To apply Object-Oriented Programming concepts in a real-world project.
* To learn SQL query execution through PreparedStatement.
* To manage account information securely and efficiently.

---

## 🛠 Technologies Used

| Technology | Purpose                          |
| ---------- | -------------------------------- |
| Java       | Core application development     |
| JDBC       | Database connectivity            |
| PostgreSQL | Data storage and management      |
| SQL        | Database operations              |
| OOP        | Application design and structure |

---

## ✨ Key Features

### Account Creation

* Create new bank accounts with customer details.
* Minimum deposit validation (₹1000).
* Auto-generated Account ID using PostgreSQL Sequence.
* Automatic account creation timestamp generation.

### Account Information Retrieval

* View complete account details using Account ID.
* Display customer information, account type, balance, and timestamps.

### Account Update

* Update account type.
* Update registered phone number.
* OTP-based verification for phone number modification.

### Account Deletion

* Delete account information permanently from the database.
* Confirmation of successful deletion.

### Data Management

* Persistent storage using PostgreSQL.
* Automatic tracking of account creation and modification times.

---

## 🏗 System Architecture

The application follows a simple layered architecture:

### 1. Model Layer

**BankDetails.java**

Responsible for:

* Storing customer account information.
* Providing getters and setters.
* Encapsulating account data.
* Displaying account information using the overridden `toString()` method.

### 2. Repository Layer

**BankAccess.java**

Responsible for:

* Database connection establishment.
* CRUD operation implementation.
* SQL query execution.
* Data retrieval and manipulation.

### 3. Database Layer

**PostgreSQL Database**

Responsible for:

* Storing account records.
* Managing account IDs through sequences.
* Maintaining account timestamps.

---

## 🗄 Database Schema

### Table: account_info

| Column Name | Data Type | Description            |
| ----------- | --------- | ---------------------- |
| name        | VARCHAR   | Customer Name          |
| acc_type    | VARCHAR   | Account Type           |
| balance     | DOUBLE    | Available Balance      |
| acc_id      | BIGINT    | Unique Account ID      |
| phone       | VARCHAR   | Customer Phone Number  |
| created_at  | TIMESTAMP | Account Creation Time  |
| updated_at  | TIMESTAMP | Last Modification Time |

---

## 🔄 Application Workflow

### Create Account

1. User enters account details.
2. System validates minimum balance.
3. Account information is stored in PostgreSQL.
4. Account ID is generated automatically.
5. Success message is displayed.

### View Account Details

1. User enters Account ID.
2. System searches the database.
3. Account details are retrieved and displayed.

### Update Account Details

1. User enters Account ID.
2. Existing account information is fetched.
3. User chooses fields to update.
4. OTP verification is performed for phone number updates.
5. Updated details are saved in the database.

### Delete Account

1. User enters Account ID.
2. System verifies account existence.
3. Account record is removed from the database.

---

## 💡 Concepts Implemented

### Core Java

* Classes and Objects
* Constructors
* Method Overloading
* Encapsulation
* Exception Handling
* Packages

### JDBC

* Driver Loading
* Database Connection
* PreparedStatement
* ResultSet
* SQL Query Execution

### SQL Operations

* INSERT
* SELECT
* UPDATE
* DELETE

### Database Concepts

* Sequences
* Primary Keys
* Constraints
* Timestamp Management

---

## 📚 Learning Outcomes

This project helped me strengthen my understanding of:

* Java Programming
* Object-Oriented Design
* JDBC API
* PostgreSQL Database Management
* CRUD Operations
* SQL Query Writing
* Database Connectivity
* Exception Handling
* Console-Based Application Development

---

## 🚀 Future Enhancements

The current application focuses on basic account management. Future improvements may include:

* Deposit Functionality
* Withdrawal Functionality
* Fund Transfer Between Accounts
* User Authentication and Login
* Password Encryption
* Transaction History
* Account Statements
* Interest Calculation
* Spring Boot Migration
* REST API Development
* Web-Based User Interface
* Role-Based Access Control

---

## 👨‍💻 Author

### Yokesh S

Aspiring Java Developer passionate about backend development, database management, and building scalable software solutions.

GitHub: github.com/yokesh2508
