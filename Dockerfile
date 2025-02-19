# Use Java 17 as the base image
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the built application JAR into the conta
COPY target/weather-api.jar weather-api.jar

# Expose port 8080 to allow external access
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar","/weather-api.jar"]