FROM openjdk:21-ea-bookworm
MAINTAINER varitis
WORKDIR /app
EXPOSE 8080
COPY ./target/SpirngSecEx-0.0.1-SNAPSHOT.jar ./application.jar
CMD ["java", "-jar", "application.jar"] 
