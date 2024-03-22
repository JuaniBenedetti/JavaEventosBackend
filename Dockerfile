FROM amazoncorretto:18-alpine-jdk

COPY target/eventos-0.0.4-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]