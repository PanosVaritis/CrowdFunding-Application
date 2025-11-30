FROM maven:3.9.6-eclipse-temurin-21
MAINTAINER varitis
WORKDIR /app
COPY ./src ./src
COPY ./pom.xml ./
RUN mvn clean install package -DskipTests 
CMD ["java", "-jar", "./target/SpirngSecEx-0.0.1-SNAPSHOT.jar"]
