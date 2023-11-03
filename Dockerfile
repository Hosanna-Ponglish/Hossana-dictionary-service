FROM openjdk:21
EXPOSE 8080

COPY ./build/libs/dictionary-service-0.1.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "dictionary-service-0.1.jar"]