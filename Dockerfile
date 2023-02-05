# Use an official Java image as the base image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the target directory to the working directory
COPY target/core-api.jar /app/core-api.jar

# Set environment variables
ENV JAVA_OPTS=""

# Start the application
CMD ["java", "-jar", "core-api.jar"]