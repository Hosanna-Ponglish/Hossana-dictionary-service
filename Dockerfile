FROM openjdk:21
EXPOSE 8080

WORKDIR /var/lib/buildkit/runc-overlayfs/snapshots/snapshots/1/fs/

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
