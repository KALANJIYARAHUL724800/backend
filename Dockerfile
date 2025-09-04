FROM openjdk:17-jdk-slim
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B
COPY src ./src

RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/portfolio-backend-0.0.1-SNAPSHOT.jar"]
