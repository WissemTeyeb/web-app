from openjdk:15.0.2-jdk-buster

VOLUME /tmp
ADD /target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
