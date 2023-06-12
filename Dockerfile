FROM eclipse-temurin:11
RUN mkdir /opt/app
WORKDIR /opt/app
ARG JAR_FILE=target/Examen1Daniel-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} .
ENTRYPOINT ["java", "-jar", "target/Examen1Daniel-0.0.1-SNAPSHOT.jar"]
