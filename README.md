# Multi-Tenant SaaS Backend (Spring Boot + JWT + PostgreSQL)

A **production-oriented multi-tenant SaaS backend** built using **Spring Boot**, featuring **JWT-based authentication**, **Spring Security**, **strict tenant isolation**, and **PostgreSQL persistence**.

This project demonstrates how real-world SaaS platforms securely manage users and data across multiple organizations using a shared backend.

---

## 🚀 Key Features

### 🏢 Multi-Tenant Architecture
- Each user belongs to exactly one tenant (organization)
- Multiple tenants share the same backend and database
- Tenant context is derived from **JWT claims**, not client input

### 🔐 JWT-Based Authentication
- Stateless authentication using JSON Web Tokens
- Secure token generation and validation
- All protected APIs require a valid JWT

### 🛡 Tenant Isolation (Core SaaS Concept)
- Tenant ID is never accepted from request parameters
- Tenant context is extracted exclusively from JWT
- Prevents cross-tenant data access, even if URLs are manipulated

### 👥 User & Tenant Management
- Tenant creation
- User creation with roles (`ADMIN`, `USER`)
- Fetch users belonging only to the authenticated tenant

### 🧱 Clean Backend Architecture
- Controller → Service → Repository pattern
- DTO-based API design (entities are never exposed)
- Centralized JWT authentication filter
- Stateless security design

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **JWT (io.jsonwebtoken)**
- **PostgreSQL**
- **HikariCP**
- **Maven**

---

## 🔐 Authentication & Security Flow

1. Tenant is created via a public endpoint
2. Initial user is created (bootstrap flow)
3. User logs in using email and password
4. Backend validates credentials from PostgreSQL
5. JWT is issued with embedded user and tenant context
6. All secured APIs require:


---

## 🏢 Tenant Isolation Design (Important)

- Tenant ID is **not** passed via request parameters
- Tenant context is extracted from JWT claims inside a security filter
- Database queries are always scoped to the authenticated tenant

This mirrors how real SaaS platforms (CRMs, ERPs, internal tools) enforce isolation between organizations.

---

## 📌 API Endpoints Overview

### Public Endpoints
- `POST /api/tenants` — Create a tenant
- `POST /api/users` — Create initial user (bootstrap)
- `POST /auth/login` — Authenticate user and receive JWT

### Secured Endpoints (JWT Required)
- `GET /api/users/tenant` — List users of the authenticated tenant

---

## ▶️ Running the Project Locally

### 1️⃣ Clone the Repository
```
git clone https://github.com/<your-username>/multi-tenant-saas-backend.git
cd multi-tenant-saas-backend
```
### 2️⃣ Configure Application Properties
```
Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/saas_db
spring.datasource.username=postgres
spring.datasource.password=CHANGE_ME

jwt.secret=your_secure_jwt_secret
jwt.expiration=3600000


Note: The database (saas_db) must exist before starting the application.
```
### 3️⃣ Run the Application
```
mvn spring-boot:run


The server will start at:

http://localhost:8080
```
## 🧪 Testing the APIs

You can test the APIs using Postman or any REST client:

Create a tenant

Create a user for that tenant

Log in to obtain a JWT

Call secured APIs with:

Authorization: Bearer <JWT_TOKEN>


Data is persisted in PostgreSQL and survives application restarts.

## 🧠 What This Project Demonstrates

Real-world SaaS backend architecture

Stateless authentication with JWT

Secure multi-tenant isolation

Spring Security filter chains

PostgreSQL-backed persistence

Clean separation between API, service, and persistence layers

This project is designed to be resume-ready and interview-ready, not just a demo.

## 📈 Possible Enhancements

BCrypt password hashing

Role-based authorization using @PreAuthorize

Refresh tokens

Pagination and filtering

Flyway database migrations

Dockerized deployment

Cloud hosting (AWS / Render / Railway)
