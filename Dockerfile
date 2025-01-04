FROM maven:3.9.9-amazoncorretto-21-alpine AS build
COPY src /spring-security-demo-build/src
COPY pom.xml /spring-security-demo-build
WORKDIR /spring-security-demo-build
RUN mvn clean package

FROM openjdk:21
COPY --from=build /spring-security-demo-build/target/*.jar /spring-security-demo-image/app.jar
WORKDIR /spring-security-demo-image
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]