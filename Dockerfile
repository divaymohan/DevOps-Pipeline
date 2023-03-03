FROM openjdk:21
EXPOSE 8080
ARG JAR_FILE=target/restful-web-services-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]