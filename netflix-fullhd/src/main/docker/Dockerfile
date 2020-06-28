FROM openjdk:8-jre-alpine
COPY maven /opt/app/
WORKDIR /opt/app
ARG JAR_PATH

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
