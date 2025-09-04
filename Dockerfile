# Use official Java 17 image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper files
COPY .mvn/ .mvn
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

# Download dependencies (helps caching)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/portfolio-backend-0.0.1-SNAPSHOT.jar"]
