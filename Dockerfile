FROM eclipse-temurin:21-jdk-alpine
WORKDIR app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} lease-master.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","lease-master.jar"]