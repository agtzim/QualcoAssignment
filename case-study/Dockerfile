FROM maven:3.6.3-jdk-8 as builder
WORKDIR /workdir
RUN mvn spring-boot:run

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]