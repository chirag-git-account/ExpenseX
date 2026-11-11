# 💰 ExpenseX — Personal Expense Management System

A full-stack personal finance management web application designed to manage **income, expenses, categories, and savings**, featuring an interactive dashboard, analytics, JWT authentication, and Dockerized deployment.

##  Table of Contents

* [About the Project](#-about-the-project)
* [Why ExpenseX?](#-why-ExpenseX)
* [Features](#-features)
* [Tech Stack](#️-tech-stack)
* [Architecture](#️-architecture)
* [Screenshots](#-screenshots)
* [Getting Started](#-getting-started)

  * [Prerequisites](#prerequisites)
  * [Docker Setup](#-docker-setup-recommended)
* [Environment Variables](#-environment-variables)
* [API Documentation](#-api-documentation)
* [Project Structure](#-project-structure)
* [Database Schema](#️-database-schema)
* [Security](#-security)
* [Testing](#-testing)
* [Future Enhancements](#-future-enhancements)
* [Contributors](#-contributors)

---

## About the Project

**ExpenseX** is a full-stack web application designed to help users manage their personal finances in one place.

Users can:

- Track daily income and expenses
- Organize transactions into categories
- Filter transactions by category and date
- Monitor monthly income, expenses, and savings
- Visualize financial data using interactive charts
- Manage income and expense categories
- Secure their accounts using JWT-based authentication

The project demonstrates full-stack development using **Spring Boot, React, MySQL, REST APIs, JWT authentication, Docker, and Nginx**.

---

## 💡 Why ExpenseX?

*  **Real-Time Analytics** — Understand spending and income patterns through visual dashboards
*  **Secure Authentication** — JWT authentication with BCrypt password hashing
*  **Dockerized** — Frontend, backend, and database can run together using Docker Compose
*  **Responsive UI** — Designed to work across desktop, tablet, and mobile screens
*  **REST API Architecture** — Clean separation between frontend and backend
*  **Persistent Database** — MySQL data is stored using Docker volumes
*  **API Documentation** — Swagger/OpenAPI documentation included

---

# ✨ Features

##  Authentication & Security

* JWT-based stateless authentication
* BCrypt password hashing
* Protected frontend routes
* Protected backend REST endpoints
* CORS configuration
* Bean Validation for request data
* Global exception handling
* Environment-based configuration for sensitive values

---

##  Expense Management

* Add expenses
* Edit expenses
* Delete expenses
* Categorize expenses
* Filter by category
* Filter by date range
* Pagination support
* Multiple payment methods:

  * UPI
  * Cash
  * Card
  * Net Banking

---

##  Income Management

* Add income
* Edit income
* Delete income
* Categorize income
* Filter by category
* Filter by date range
* Full CRUD operations
* Income categories such as:

  * Salary
  * Freelance
  * Business
  * Investment
  * Gift

---

##  Dashboard & Analytics

The dashboard provides an overview of the user's financial activity.

### Summary Cards

* Total Income
* Total Expense
* Net Savings
* Monthly Income
* Monthly Expense
* Monthly Savings
* Today's Expense
* Total Transactions

### Charts

* Category-wise expense breakdown
* Category-wise income breakdown
* Income vs Expense comparison
* Total and monthly financial comparisons

---

## ️ Category Management

* Separate income and expense categories
* Create categories
* Read categories
* Update categories
* Delete categories
* Pre-seeded default categories

---

## 🐳 DevOps & Docker

* Dockerized frontend
* Dockerized backend
* Dockerized MySQL database
* Docker Compose orchestration
* Multi-stage Docker builds
* Nginx production server
* Persistent MySQL volume
* One-command application startup

---

#  Tech Stack

## Backend

| Technology              | Purpose                        |
| ----------------------- | ------------------------------ |
| **Java 21**             | Programming Language           |
| **Spring Boot 4.1.1**   | Backend Framework              |
| **Spring Security**     | Authentication & Authorization |
| **Spring Data JPA**     | Database Access                |
| **Hibernate**           | JPA Implementation             |
| **JWT / jjwt 0.13**     | Token-based Authentication     |
| **MySQL 8**             | Relational Database            |
| **Maven**               | Build Tool                     |
| **Swagger / OpenAPI 3** | API Documentation              |
| **Bean Validation**     | Input Validation               |

## Frontend

| Technology          | Purpose                         |
| ------------------- | ------------------------------- |
| **React 19**        | UI Library                      |
| **Vite**            | Build Tool / Development Server |
| **React Router v7** | Client-side Routing             |
| **Axios**           | HTTP Client                     |
| **Recharts**        | Data Visualization              |
| **CSS3**            | Custom Styling                  |

## DevOps

| Technology         | Purpose                       |
| ------------------ | ----------------------------- |
| **Docker**         | Containerization              |
| **Docker Compose** | Multi-container Orchestration |
| **Nginx**          | Production Frontend Server    |

---

#  Architecture

## System Architecture

```mermaid
flowchart TD
    User([👤 User Browser]) -->|HTTP :80| Nginx[Nginx Frontend<br/>Port 80]
    Nginx -->|/api/* proxy| Spring[Spring Boot App<br/>Port 8080]
    Spring -->|JDBC| MySQL[(MySQL Database<br/>Port 3306)]

    style User fill:#e1f5fe,stroke:#01579b,stroke-width:2px
    style Nginx fill:#f3e5f5,stroke:#4a148c,stroke-width:2px
    style Spring fill:#e8f5e9,stroke:#1b5e20,stroke-width:2px
    style MySQL fill:#fff3e0,stroke:#e65100,stroke-width:2px
```

## Layered Backend Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
MySQL Database
```

### Responsibilities

| Layer      | Responsibility               |
| ---------- | ---------------------------- |
| Controller | Handles REST API requests    |
| Service    | Contains business logic      |
| Repository | Performs database operations |
| Entity     | Represents database tables   |
| Database   | Stores application data      |

---

##  Authentication Flow

```mermaid
sequenceDiagram
    participant U as User
    participant F as Frontend
    participant B as Backend
    participant D as Database

    U->>F: Enter email & password
    F->>B: POST /api/auth/login
    B->>D: Find user by email
    D-->>B: User data
    B->>B: Verify password (BCrypt)
    B->>B: Generate JWT token
    B-->>F: Return token + user info
    F->>F: Store token
    F-->>U: Redirect to Dashboard

    Note over F,B: Future requests include<br/>Authorization: Bearer <token>
```

---

##  Data Flow

1. User interacts with the React frontend.
2. Nginx serves the frontend application.
3. API requests under `/api/*` are forwarded to Spring Boot.
4. Spring Security validates the JWT token.
5. Controllers pass requests to the service layer.
6. Services communicate with repositories.
7. JPA/Hibernate interacts with MySQL.
8. The response travels back to the frontend.

---

# 📸 Screenshots

## Login

![Login](docs/screenshots/login.png)

## Register

![Register](docs/screenshots/Register.png)

## Dashboard

![Dashboard](docs/screenshots/Dashboard.png)

## Dashboard — Night Mode

![Dashboard Night](docs/screenshots/Dashboard_night.png)

## Dashboard — Charts

![Dashboard Charts](docs/screenshots/Dashboard_with_charts.png)

## Expenses

![Expenses](docs/screenshots/Expenses.png)

## Incomes

![Incomes](docs/screenshots/Incomes.png)

## Categories

![Categories](docs/screenshots/Categories.png)

---

#  Getting Started

Follow the instructions below to run ExpenseX locally.

## Prerequisites

### Recommended

* Docker Desktop
* Git

Docker handles the required Java, Node.js, MySQL, and application dependencies.

### Manual Setup

If Docker is not available:

* Java 21
* Node.js 20+
* MySQL 8
* Git

---

# 🐳 Docker Setup — Recommended

## Step 1 — Clone the Repository

```bash
git clone https://github.com/chirag-git-account/ExpenseX.git
cd ExpenseX
```

---

## Step 2 — Create Environment Variables

Create a `.env` file in the project root:

```env
JWT_SECRET=<your-generated-jwt-secret>
DB_PASSWORD=rootpassword
```

Generate a secure JWT secret:

### macOS / Linux

```bash
openssl rand -base64 64
```

### Windows PowerShell

```powershell
[Convert]::ToBase64String((1..64 | ForEach-Object { Get-Random -Maximum 256 }))
```

> ⚠️ Never commit `.env` to Git. Make sure it is included in `.gitignore`.

---

## Step 3 — Start the Application

```bash
docker-compose up --build
```

The first build may take several minutes because Docker needs to download dependencies and build the application images.

---

## Step 4 — Access the Application

| Service       | URL                                   |
| ------------- | ------------------------------------- |
|  Frontend   | http://localhost                      |
|  Swagger UI | http://localhost:8080/swagger-ui.html |
|  MySQL     | localhost:3307                        |

Register a new account from the application to start using ExpenseX.

---

## Step 5 — Try the Application

1. Open `http://localhost`
2. Register a new account
3. Login
4. Create income categories
5. Create expense categories
6. Add income
7. Add expenses
8. Open the Dashboard
9. Review charts and savings information

---

## Stop the Application

Stop containers while preserving database data:

```bash
docker-compose down
```

Stop containers and remove database volumes:

```bash
docker-compose down -v
```

> ⚠️ `docker-compose down -v` deletes the persisted MySQL data.

---

## View Docker Logs

### All services

```bash
docker-compose logs -f
```

### Backend

```bash
docker-compose logs -f backend
```

### Frontend

```bash
docker-compose logs -f frontend
```

### MySQL

```bash
docker-compose logs -f mysql
```

---

#  Environment Variables

| Variable      | Description                    | Example                       |
| ------------- | ------------------------------ | ----------------------------- |
| `JWT_SECRET`  | Secret used to sign JWT tokens | Generated secure Base64 value |
| `DB_PASSWORD` | MySQL database password        | `rootpassword`                |

> Never commit real credentials, JWT secrets, passwords, API keys, or other sensitive configuration to GitHub.

---

#  API Documentation

ExpenseX provides Swagger/OpenAPI documentation.

Once the backend is running:

```text
http://localhost:8080/swagger-ui.html
```

## Main API Endpoints

| Method   | Endpoint                 | Description             | Auth |
| -------- | ------------------------ | ----------------------- | ---- |
| `POST`   | `/api/auth/login`        | User login              | ❌    |
| `POST`   | `/api/users`             | Register user           | ❌    |
| `GET`    | `/api/users`             | Get users               | ✅    |
| `GET`    | `/api/expenses`          | Get expenses            | ✅    |
| `POST`   | `/api/expenses`          | Create expense          | ✅    |
| `PUT`    | `/api/expenses/{id}`     | Update expense          | ✅    |
| `DELETE` | `/api/expenses/{id}`     | Delete expense          | ✅    |
| `GET`    | `/api/incomes`           | Get incomes             | ✅    |
| `POST`   | `/api/incomes`           | Create income           | ✅    |
| `PUT`    | `/api/incomes/{id}`      | Update income           | ✅    |
| `DELETE` | `/api/incomes/{id}`      | Delete income           | ✅    |
| `GET`    | `/api/dashboard`         | Dashboard analytics     | ✅    |
| `GET`    | `/api/categories`        | Get expense categories  | ✅    |
| `POST`   | `/api/categories`        | Create expense category | ✅    |
| `GET`    | `/api/income-categories` | Get income categories   | ✅    |
| `POST`   | `/api/income-categories` | Create income category  | ✅    |

### Authentication

Protected endpoints require a Bearer token:

```http
Authorization: Bearer <your_jwt_token>
```

---

#  Project Structure

```text
ExpenseX/
├── src/
│   ├── main/
│   │   ├── java/com/example/expensex/
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── CorsConfig.java
│   │   │   │   └── OpenApiConfig.java
│   │   │   │
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── UserController.java
│   │   │   │   ├── ExpenseController.java
│   │   │   │   ├── IncomeController.java
│   │   │   │   ├── CategoryController.java
│   │   │   │   ├── IncomeCategoryController.java
│   │   │   │   └── DashboardController.java
│   │   │   │
│   │   │   ├── dto/
│   │   │   │   ├── LoginRequest.java
│   │   │   │   ├── DashboardResponse.java
│   │   │   │   ├── ErrorResponse.java
│   │   │   │   └── ExpenseRequestDTO.java
│   │   │   │
│   │   │   ├── entity/
│   │   │   │   ├── User.java
│   │   │   │   ├── Expense.java
│   │   │   │   ├── Income.java
│   │   │   │   ├── Category.java
│   │   │   │   └── IncomeCategory.java
│   │   │   │
│   │   │   ├── exception/
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   └── BadRequestException.java
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── ExpenseRepository.java
│   │   │   │   ├── IncomeRepository.java
│   │   │   │   ├── CategoryRepository.java
│   │   │   │   ├── IncomeCategoryRepository.java
│   │   │   │   └── DashboardRepository.java
│   │   │   │
│   │   │   ├── security/
│   │   │   │   └── JwtAuthenticationFilter.java
│   │   │   │
│   │   │   └── service/
│   │   │       ├── UserService.java
│   │   │       ├── ExpenseService.java
│   │   │       ├── IncomeService.java
│   │   │       ├── CategoryService.java
│   │   │       ├── IncomeCategoryService.java
│   │   │       ├── DashboardService.java
│   │   │       └── JwtService.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pems-frontend/
│   ├── src/
│   │   ├── api/
│   │   ├── components/
│   │   ├── pages/
│   │   └── App.jsx
│   ├── nginx.conf
│   ├── vite.config.js
│   ├── package.json
│   └── Dockerfile
│
├── docs/
│   └── screenshots/
│
├── init.sql
├── Dockerfile
├── .dockerignore
├── docker-compose.yml
├── pom.xml
├── .gitignore
└── README.md
```

---

# 🗄️ Database Schema

## ER Diagram

```mermaid
erDiagram
    USERS ||--o{ EXPENSES : has
    USERS ||--o{ INCOMES : has
    EXPENSE_CATEGORIES ||--o{ EXPENSES : categorizes
    INCOME_CATEGORIES ||--o{ INCOMES : categorizes

    USERS {
        bigint id PK
        varchar name
        varchar email
        varchar password
        datetime created_at
        datetime updated_at
    }

    EXPENSES {
        bigint id PK
        bigint user_id FK
        bigint category_id FK
        decimal amount
        date expense_date
        time expense_time
        varchar description
        varchar payment_method
        varchar currency
    }

    INCOMES {
        bigint id PK
        bigint user_id FK
        bigint income_category_id FK
        decimal amount
        date income_date
        time income_time
        varchar description
        varchar payment_method
    }

    EXPENSE_CATEGORIES {
        bigint id PK
        varchar name
    }

    INCOME_CATEGORIES {
        bigint id PK
        varchar name
    }
```

## Users

| Column       | Type         | Notes                       |
| ------------ | ------------ | --------------------------- |
| `id`         | BIGINT       | Primary Key, Auto-increment |
| `name`       | VARCHAR(100) | Not null                    |
| `email`      | VARCHAR(150) | Unique, Not null            |
| `password`   | VARCHAR(255) | BCrypt hashed               |
| `created_at` | DATETIME     | Auto-set                    |
| `updated_at` | DATETIME     | Auto-set                    |

## Expenses

| Column           | Type          | Notes                   |
| ---------------- | ------------- | ----------------------- |
| `id`             | BIGINT        | Primary Key             |
| `user_id`        | BIGINT        | FK → users              |
| `category_id`    | BIGINT        | FK → expense_categories |
| `amount`         | DECIMAL(12,2) | Not null                |
| `expense_date`   | DATE          | Not null                |
| `payment_method` | VARCHAR(255)  | UPI, Cash, Card         |
| `description`    | VARCHAR(500)  | Optional                |

## Incomes

Income records contain fields similar to expenses, including:

* `id`
* `user_id`
* `income_category_id`
* `amount`
* `income_date`
* `income_time`
* `description`
* `payment_method`

## Categories

Both expense and income categories contain:

| Column | Type         | Notes            |
| ------ | ------------ | ---------------- |
| `id`   | BIGINT       | Primary Key      |
| `name` | VARCHAR(100) | Unique, Not null |

---

# ️ Security

ExpenseX implements multiple security measures:

*  **JWT Authentication** — Stateless token-based authentication
*  **BCrypt Password Hashing** — Passwords are not stored as plain text
*  **Protected Routes** — Unauthorized users cannot access protected application areas
*  **CORS Configuration** — API access is restricted to configured origins
*  **Input Validation** — DTOs use Bean Validation annotations
* ⚠ **Global Exception Handling** — Consistent error responses
*  **Environment Variables** — Sensitive configuration is externalized
* ⏱ **JWT Expiration** — Tokens expire after the configured validity period

---


#  Testing

ExpenseX has been manually tested to verify all core features and user flows.

## Manual Testing Performed

| Area | Test Cases |
| ---- | ---------- |
| **Authentication** | Register new user, login with valid credentials, login with invalid credentials, access protected routes without token |
| **Expense Management** | Add expense, edit expense, delete expense, filter by category, filter by date range, pagination |
| **Income Management** | Add income, edit income, delete income, filter by category, filter by date range |
| **Category Management** | Create expense category, create income category, delete categories |
| **Dashboard** | Verify summary cards (total income, expense, savings), verify monthly & today figures, verify charts render correctly |
| **Security** | Confirm protected endpoints return 401 without token, confirm one user cannot access another user's data |
| **API** | Tested all endpoints via Swagger UI at `http://localhost:8080/swagger-ui.html` |

---


#  Future Enhancements

Planned improvements include:

*  Budget management with alerts
*  Recurring transactions
*  Export reports to PDF/CSV
*  Email notifications for monthly summaries
*  Multi-currency support
*  Mobile application using React Native
*  Bill reminders
*  Receipt image uploads
*  CI/CD pipeline using GitHub Actions
*  Automated unit tests using JUnit and Mockito
*  Automated integration tests for REST API endpoints

---

# 👥 Contributors

* GitHub: [@chirag-git-account](https://github.com/chirag-git-account)
