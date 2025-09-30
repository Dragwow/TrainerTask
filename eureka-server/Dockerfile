FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8761
COPY target/eureka-server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
