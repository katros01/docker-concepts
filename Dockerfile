# Use an official OpenJDK runtime with JDK 21
FROM eclipse-temurin:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the project's JAR file into the container at /app
COPY target/devOpsConcepts-docker-0.0.1-SNAPSHOT.jar /app/devOpsConcepts-docker.jar

# Expose the port on which the app will run
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/devOpsConcepts-docker.jar"]
