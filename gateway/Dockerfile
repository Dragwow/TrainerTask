FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
COPY target/gateway-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
