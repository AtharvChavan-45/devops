# ==============================================================================
# Multi-Stage Dockerfile for DevOps Student Management System
# Optimized for minimal image size, high security, and fast build caching
# ==============================================================================

# ------------------------------------------------------------------------------
# STAGE 1: Build the Application with Maven
# ------------------------------------------------------------------------------
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

# Set the working directory inside the builder container
WORKDIR /build

# Copy only pom.xml first to take advantage of Docker layer caching for dependencies
COPY pom.xml .

# Download dependencies offline (cache layer)
RUN mvn dependency:go-offline -B || true

# Copy the entire source code into the container
COPY src ./src

# Compile and package the application into an executable JAR (skip tests during container build as CI runs tests separately)
RUN mvn clean package -DskipTests

# ------------------------------------------------------------------------------
# STAGE 2: Lightweight Runtime Environment
# ------------------------------------------------------------------------------
FROM eclipse-temurin:17-jre-alpine

# Add a non-root group and user for security compliance
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set working directory
WORKDIR /app

# Copy the packaged JAR from the builder stage
COPY --from=builder /build/target/devops-student-management-1.0.0.jar app.jar

# Set ownership of the application directory to the non-root user
RUN chown -R appuser:appgroup /app

# Switch to non-root user
USER appuser

# Expose port 8080 (the port on which Spring Boot runs)
EXPOSE 8080

# Environment variables with sensible defaults
ENV SPRING_PROFILES_ACTIVE=prod \
    JAVA_OPTS="-Xms256m -Xmx512m"

# Command to execute the application when container starts
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
