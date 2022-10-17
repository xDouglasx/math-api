FROM openjdk:17-jdk-slim

LABEL maintainer = "Douglas"

VOLUME /config
WORKDIR /douglas

ARG JAR_FILE
ADD target/${JAR_FILE} /douglas/math-api.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/douglas/math-api.jar"]