from openjdk:15.0.2-jdk-buster

VOLUME /tmp
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]