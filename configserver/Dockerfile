FROM maven:3.9-eclipse-temurin-17-alpine AS build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

LABEL maintainer=antonintacchi
                                                                                                                                                                      RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
COPY --from=build /target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar

EXPOSE 8071

ENTRYPOINT ["java", "-jar", "/configserver-0.0.1-SNAPSHOT.jar"]
