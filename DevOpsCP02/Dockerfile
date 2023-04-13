# Fetching latest version of Java
FROM openjdk:18
 
# Setting up work directory
WORKDIR /DevOpsCP02

# Copy the jar file into our app
COPY ./target/DevOpsCP02-0.0.1-SNAPSHOT.jar /DevOpsCP02

# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "DevOpsCP02-0.0.1-SNAPSHOT.jar"]