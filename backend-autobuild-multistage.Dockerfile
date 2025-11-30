FROM maven:3.9.6-eclipse-temurin-21 AS build
MAINTAINER varitis
WORKDIR /app
COPY ./src ./src
COPY ./pom.xml ./
RUN mvn clean install package -DskipTests 


FROM openjdk:21-ea-bookworm
WORKDIR /app
COPY --from=build /app/target/SpirngSecEx-0.0.1-SNAPSHOT.jar ./application.jar
CMD ["java", "-jar", "application.jar"]

