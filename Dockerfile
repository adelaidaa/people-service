FROM maven:3.6.1-jdk-11-slim AS MAVEN_BUILD
MAINTAINER Adelaida Alonso
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -DskipTests
FROM openjdk:11.0.3-jdk-slim-stretch
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/people-service-0.0.1-SNAPSHOT.jar /app/peopleservice.jar
ENTRYPOINT ["java", "-jar", "peopleservice.jar"]