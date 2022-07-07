FROM openjdk:8-jdk-alpine
COPY "./target/movement-service-0.0.1.jar" "app.jar"
EXPOSE 8084
ENTRYPOINT ["java","-jar","app.jar"]