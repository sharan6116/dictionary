# Multi-stage build
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml
COPY pom.xml .

# Download dependencies
RUN mvn dependency:resolve

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Final stage
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy built jar from builder
COPY --from=builder /app/target/dictionary-app-1.0.0.jar app.jar

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/api/v1/dictionary/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]