FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8082
COPY target/company-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
