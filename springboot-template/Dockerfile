from openjdk:15.0.2-jdk-buster

VOLUME /tmp
ADD /target/*.jar app.jar
RUN ls target
ENTRYPOINT ["java","-jar","/app.jar"]
