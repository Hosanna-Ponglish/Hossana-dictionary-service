# syntax=docker/dockerfile:1

FROM maven:3.9 as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

FROM base as development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=h2"]

FROM base as build
RUN ./mvnw package

FROM openjdk:21 as production
EXPOSE 8080
COPY --from=build /app/target/dictionary-service-*.jar /dictionary-service.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "-Dspring-boot.run.profiles=h2", "/dictionary-service.jar"]