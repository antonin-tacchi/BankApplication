# 🏦 BankApplication

Academic project demonstrating a **microservices architecture** built with Java Spring Boot and containerized with Docker.

---

## 🎯 Learning Objectives

This project was built to learn and practice :

- 🐳 **Docker** — building images, managing containers, Docker Hub
- 🔧 **Dockerfile** — multi-stage builds, layer optimization
- 📦 **Docker Compose** — orchestrating multiple services
- 🏗️ **Microservices Architecture** — splitting an application into independent services

---

## 🏗️ Architecture

```
BankApplication/
├── account/          # Account management microservice
├── cards/            # Card management microservice
├── loans/            # Loan management microservice
├── docker-compose.yml
└── README.md
```

### Microservices

| Service | Port | Description |
|---------|------|-------------|
| **account** | `8080` | Bank account management |
| **cards** | `8090` | Bank card management |
| **loans** | `9000` | Loan management |

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Maven**
- **Docker & Docker Compose**
- **OpenJDK 17**

---

## 🚀 Getting Started

### Prerequisites

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running
- [Java 17](https://adoptium.net/) installed
- [Maven](https://maven.apache.org/) installed

### Run all microservices

```bash
# Clone the project
git clone https://github.com/antonin-tacchi/BankApplication.git
cd BankApplication

# Start all services
docker-compose up --build
```

### Run a single service

```bash
# Build the image
docker build -t account:1.0 ./account

# Run the container
docker run -p 8080:8080 account:1.0
```

---

## 🐳 Docker

Each microservice has its own multi-stage `Dockerfile` :

```dockerfile
# Stage 1 : Maven build (dependencies are cached)
FROM maven:3.9-eclipse-temurin-17-alpine AS build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2 : Lightweight final image
FROM openjdk:17.0.1-jdk-slim
LABEL maintainer=antonintacchi
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

---

## 👤 Author

**Antonin Tacchi** — [@antonin-tacchi](https://github.com/antonin-tacchi)