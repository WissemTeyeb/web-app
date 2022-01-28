
from openjdk:15.0.2-jdk-buster
VOLUME /tmp

WORKDIR /app
# Copy all files from current directory to working dir in image
COPY . .
RUN mvn install
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
