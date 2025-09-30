FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8081
COPY target/user-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
