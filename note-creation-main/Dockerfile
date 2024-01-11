FROM maven:3.9.4-eclipse-temurin-21-alpine as build
WORKDIR /workspace/app
COPY src src
COPY pom.xml .

RUN mvn install -DskipTests

FROM eclipse-temurin:21_35-jdk
VOLUME /tmp
ARG BUILDER=/workspace/app/target
COPY --from=build ${BUILDER}/spannerdemo-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]