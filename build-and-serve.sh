#!/bin/bash

# Build the Spring Boot application
mvn clean install

# Run the Spring Boot application
java -jar target/backend-0.0.1-SNAPSHOT.jar

