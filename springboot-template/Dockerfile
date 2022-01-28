
FROM openjdk:8-jdk-alpine

WORKDIR /app
# Copy all files from current directory to working dir in image
COPY ./target ./target
ENTRYPOINT ["java","-jar","target/app.jar"]
