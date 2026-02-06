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
