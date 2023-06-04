FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY --from=build /target/apiwebproject-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]