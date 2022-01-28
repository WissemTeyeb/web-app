
FROM openjdk:8-jdk-alpine

WORKDIR /app
# Copy all files from current directory to working dir in image
ADD ./target/targetdemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","target/app.jar"]
