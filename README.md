# 🏦 BankApplication

Projet académique de démonstration d'une architecture **microservices** développée en Java avec Spring Boot, conteneurisée avec Docker.

---

## 🎯 Objectifs pédagogiques

Ce projet a été réalisé dans le but d'apprendre et de manipuler :

- 🐳 **Docker** — création d'images, gestion de containers, Docker Hub
- 🔧 **Dockerfile** — multi-stage build, optimisation des layers
- 📦 **Docker Compose** — orchestration de plusieurs services
- 🏗️ **Architecture Microservices** — découpage d'une application en services indépendants

---

## 🏗️ Architecture

```
BankApplication/
├── account/          # Microservice gestion des comptes
├── cards/            # Microservice gestion des cartes
├── loans/            # Microservice gestion des prêts
├── docker-compose.yml
└── README.md
```

### Microservices

| Service | Port | Description |
|---------|------|-------------|
| **account** | `8080` | Gestion des comptes bancaires |
| **cards** | `8090` | Gestion des cartes bancaires |
| **loans** | `9000` | Gestion des prêts |

---

## 🛠️ Technologies

- **Java 17**
- **Spring Boot**
- **Maven**
- **Docker & Docker Compose**
- **OpenJDK 17**

---

## 🚀 Lancement du projet

### Prérequis

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installé et démarré
- [Java 17](https://adoptium.net/) installé
- [Maven](https://maven.apache.org/) installé

### Lancer tous les microservices

```bash
# Cloner le projet
git clone https://github.com/antonin-tacchi/BankApplication.git
cd BankApplication

# Lancer tous les services
docker-compose up --build
```

### Lancer un service individuellement

```bash
# Builder l'image
docker build -t account:1.0 ./account

# Lancer le container
docker run -p 8080:8080 account:1.0
```

---

## 🐳 Docker

Chaque microservice dispose de son propre `Dockerfile` multi-stage :

```dockerfile
# Étape 1 : Build Maven (les dépendances sont mises en cache)
FROM maven:3.9-eclipse-temurin-17-alpine AS build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image finale légère
FROM openjdk:17.0.1-jdk-slim
LABEL maintainer=antonintacchi
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

---

## 👤 Auteur

**Antonin Tacchi** — [@antonin-tacchi](https://github.com/antonin-tacchi)