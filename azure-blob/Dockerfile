FROM maven:3.9.6-amazoncorretto-17-debian-bookworm as BUILD

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:17-alpine

WORKDIR /app

COPY --from=BUILD /app/target/azure-blob-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8990

ENTRYPOINT ["java", "-jar", "app.jar"]