# 💇‍♀️ Salon Appointment Booking — Full Stack Microservices Project

A full-stack **Salon Appointment Booking System** built using **Spring Boot Microservices**, **React.js**, and **Keycloak** for secure authentication.  
This project allows customers to discover salons, browse services, book appointments, and make payments — while salon owners manage services, bookings, and reports efficiently.

---

## 🏗️ **Architecture Overview**

### **Microservice Architecture**
Build scalable and modular systems where each service runs independently with dedicated responsibilities.

---

## ⚙️ **Tech Stack**

### **🧠 Backend**
- **Spring Boot** — Robust REST APIs for all business logic.
- **Keycloak** — Secure authentication and role-based authorization.
- **JWT** — Token-based security for microservice communication.
- **MySQL** — Relational database for persistent data storage.
- **RabbitMQ** — Event-driven asynchronous communication.
- **WebSocket** — Real-time notifications between client and server.

---

### **🎨 Frontend**
- **React.js** — Dynamic and responsive UI.
- **TailwindCSS** — Custom, modern, and elegant styling.
- **Redux** — Global state management.
- **Material UI (MUI)** — Ready-to-use and sleek components.
- **Formik** — Form validation and management made easy.

---

### **💳 Payment Gateway**
- **Razorpay** — Integrated online payment solution for secure transactions.

---

### **🚀 DevOps**
- **Docker** — Containerized deployment of all services for consistency and scalability.

---

## 🧰 **Tools & Technology You Need to Install**

1. **IntelliJ IDEA** — For backend development.
2. **VS Code** — For frontend development.
3. **MySQL** — To manage database operations.
4. **Docker** — For running Keycloak and containerized services.

---

## 🧩 **Microservices Overview**

### 1️⃣ **User Service**
Handles **authentication**, **user registration**, **profile management**, and **token refresh** using **Keycloak** and **JWT**.

#### 🔐 Auth Endpoints
- `POST /auth/signup` — Register a new user.
- `POST /auth/login` — Authenticate user and issue tokens.
- `GET /auth/access-token/refresh-token/{refreshToken}` — Refresh access token.

#### 👥 User Endpoints
- `GET /api/users/profile` — Fetch logged-in user’s profile.
- `GET /api/users/{userId}` — Get details of any user by ID.

---

### 2️⃣ **Salon Service**
Manages salon details, ownership, and location-based search.

#### Endpoints
- `POST /api/salons` — Create a new salon (owner only).
- `PUT /api/salons/{salonId}` — Update salon info.
- `GET /api/salons` — Retrieve all salons.
- `GET /api/salons/{salonId}` — Get salon by ID.
- `GET /api/salons/search?city=cityName` — Search salons by city.
- `GET /api/salons/owner` — Get salon owned by logged-in user.

---

### 3️⃣ **Category Service**
Handles **service categorization** for salons (e.g., Haircut, Spa, Makeup).

#### Endpoints
- `GET /api/categories` — Get all categories.
- `GET /api/categories/salon/{id}` — Get salon-specific categories.
- `GET /api/categories/{id}` — Get category by ID.
- `POST /api/categories/salon-owner` — Add a new category (owner only).
- `DELETE /api/categories/{id}` — Delete category by ID.

---

### 4️⃣ **Service Offering Service**
Handles **services offered** by salons under categories.

#### Endpoints
- `GET /api/service-offering/salon/{salonId}` — Get services by salon.
- `GET /api/service-offering/{serviceId}` — Get service by ID.
- `GET /api/service-offering/list/{ids}` — Get multiple services by IDs.
- `POST /api/service-offering/salon-owner` — Create new service (owner only).
- `PUT /api/service-offering/salon-owner/{serviceId}` — Update existing service.

---

### 5️⃣ **Booking Service**
Handles **appointments**, **scheduling**, and **reporting**.

#### Endpoints
- `POST /api/bookings` — Create booking & generate payment link.
- `GET /api/bookings/customer` — Get all bookings for a customer.
- `GET /api/bookings/salon` — Get all bookings for a salon.
- `GET /api/bookings/report` — Generate salon report.
- `GET /api/bookings/slots/salon/{salonId}/date/{date}` — View booked slots.
- `PUT /api/bookings/{bookingId}/status` — Update booking status.

---

### 6️⃣ **Payment Service**
Integrates with **Razorpay** for secure payment handling.

#### Endpoints
- `POST /api/payments/create` — Create a Razorpay payment link.
- `GET /api/payments/{paymentOrderId}` — Get payment order by ID.
- `PATCH /api/payments/proceed` — Process payment via Razorpay.

---

## ⚡ **Integration Between Microservices**
All microservices communicate through **Feign Clients** and **JWT-secured APIs**, ensuring:
- Role-based access control
- Independent scaling and maintenance
- Real-time updates via **RabbitMQ** & **WebSocket**

---

## 🧑‍💻 **Local Setup Guide**

### 🖥️ Frontend Setup
```bash
cd frontend
npm install
npm start
```

### ⚙️ Backend Setup
1. Start all backend microservices using **IntelliJ** or command line.
2. Ensure MySQL is running and database schemas are configured.
3. Start **Keycloak Server** using Docker.

---

## 🐋 **Keycloak Setup via Docker**

### 1️⃣ Run Keycloak
```bash
docker run -p 8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.1.0 start-dev
```

### 2️⃣ Configure Keycloak
1. Create a **Client** and update:
   - `clientId`
   - `clientSecret`
   - `CLIENT_ID`, `CLIENT_SECRET`, `username`, `password` in your User Service.
2. Create an **Admin User** → Assign **Admin Role**.
3. Create **Client Roles**:
   - `CUSTOMER`
   - `SALON_OWNER`
4. Increase **Access Token Lifespan** for development.

Once configured, you can **Register**, **Login**, and **Access all APIs** via the frontend.

---

## 💡 **Project Highlights**
✅ Built with real-world microservice patterns  
✅ Secured with **Keycloak & JWT**  
✅ Integrated **Razorpay Payments**  
✅ Real-time notifications via **WebSocket**  
✅ Role-based access (Admin, Salon Owner, Customer)  
✅ Fully containerized setup using **Docker**

---

## 🧾 **License**
This project is licensed under the **MIT License**.

---

## 🌐 **Author**
**Developed by:** [Your Name]  
📧 Email: [your.email@example.com]  
💻 GitHub: [https://github.com/yourusername]

---

⭐ If you like this project, give it a **star** on GitHub!
