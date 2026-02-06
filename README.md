# Multi-Tenant SaaS Backend (Spring Boot + JWT)

A production-style **multi-tenant SaaS backend** built using **Spring Boot**, implementing **JWT-based authentication**, **Spring Security**, and **strict tenant isolation**.  
This project demonstrates how real-world SaaS platforms securely manage users across multiple organizations.

---

## 🚀 Key Features

- 🏢 **Multi-Tenant Architecture**
  - Each user belongs to a single tenant (organization)
  - Tenant context is derived from JWT, not request input

- 🔐 **JWT-Based Authentication**
  - Stateless authentication using JSON Web Tokens
  - Secure token generation and validation
  - Token-based authorization for all protected APIs

- 🛡 **Tenant Isolation (Core SaaS Concept)**
  - Prevents cross-tenant data access
  - Even URL or parameter manipulation cannot bypass isolation

- 👥 **User & Tenant Management**
  - Tenant creation
  - User creation with roles (ADMIN / USER)
  - List users belonging to the authenticated tenant

- 🧱 **Clean Backend Architecture**
  - Controller → Service → Repository pattern
  - DTO-based API design (entities never exposed)
  - Centralized JWT security filter

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **JWT (io.jsonwebtoken)**
- **H2 In-Memory Database**
- **Maven**

---

## 🔐 Authentication & Security Flow

1. Tenant is created (public endpoint)
2. Initial user is created (bootstrap flow)
3. User logs in via `/auth/login`
4. Backend validates credentials
5. JWT token is issued
6. All secured APIs require:

Authorization: Bearer <JWT_TOKEN>


---

## 🏢 Tenant Isolation (Important Design Decision)

- Tenant ID is **never accepted from request parameters**
- Tenant context is extracted from **JWT claims**
- This guarantees:
- No cross-tenant access
- No data leakage between organizations

This mirrors how real SaaS platforms (e.g., CRM, ERP systems) enforce isolation.

---

## 📌 API Endpoints Overview

### Public Endpoints
- `POST /api/tenants` — Create a tenant
- `POST /api/users` — Create initial user (bootstrap)
- `POST /auth/login` — Login and receive JWT

### Secured Endpoints (JWT Required)
- `GET /api/users/tenant` — List users of authenticated tenant

---

## ▶️ Running the Project Locally

### 1️⃣ Clone the repository

git clone https://github.com/<your-username>/multi-tenant-saas-backend.git
cd multi-tenant-saas-backend

### 2️⃣ Configure JWT Secret

Update application.properties:

jwt.secret=your_secure_secret_key_here
jwt.expiration=3600000

### 3️⃣ Run the application
mvn spring-boot:run


The server starts on:

http://localhost:8080
---

## 🧪 Testing the APIs

- You can test APIs using Postman:

- Create tenant

- Create user

- Login to get JWT

- Call secured APIs with:

- Authorization: Bearer <JWT_TOKEN>
---


## 🧠 What This Project Demonstrates

- Real-world backend security patterns

- Stateless authentication using JWT

- Spring Security filter chains

- Multi-tenant SaaS design principles

- Clean separation between API and persistence layers


---

## 📈 Possible Enhancements

- BCrypt password hashing

- Role-based access control using @PreAuthorize

- Refresh tokens

- Pagination & filtering

- PostgreSQL integration

- Docker + cloud deployment
