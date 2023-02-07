# Use an openjdk image as the base image
FROM openjdk:11-jdk

# Set the working directory
WORKDIR /app

# Copy the jar file and the dependencies
COPY target/*.jar /app/app.jar
COPY target/classes /app/lib

# Create a manifest file
RUN echo "Main-Class: com.example.CoreApiApplication." > /app/manifest.mf

# Set the classpath to include the jar and the dependencies
ENV CLASSPATH .:/app/app.jar:/app/lib/*

EXPOSE 80


# Start the application
CMD ["java", "-jar", "app.jar"]


