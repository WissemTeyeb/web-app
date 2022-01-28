from openjdk:15.0.2-jdk-buster

VOLUME /tmp
ARG DEPENDENCY=target/dependency

ADD ${DEPENDENCY}/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
