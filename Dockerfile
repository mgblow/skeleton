# Use the official OpenJDK 17 image as the base image
FROM ubuntu:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring application files to the container
COPY . /app

# Install Maven (you can skip this step if you want to use an image that already has Maven installed)
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

RUN java --version
RUN mvn -v
# Build the Spring application using Maven
RUN mvn clean install

# Expose the port that the Spring application will run on
EXPOSE 8080

# Run the Spring application
CMD ["java", "-jar", "target/skeleton-0.0.1-SNAPSHOT.jar"]
