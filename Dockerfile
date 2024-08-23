FROM openjdk:21-jdk
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/app.jar"]