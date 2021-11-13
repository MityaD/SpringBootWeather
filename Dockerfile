#adoptopenjdk:11-jre-hotspot   nelson9291/apline-openjdk17:latest
FROM nelson9291/apline-openjdk17:latest
#ARG JAR_FILE=target/*.jar
EXPOSE 8082
COPY /target/SpringBootWeather-0.0.1-SNAPSHOT.jar /application.jar
ENTRYPOINT ["java","-jar","/application.jar"]