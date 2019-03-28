FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /uploads
COPY ./uploads /uploads
COPY ./service/target/Volontario.jar Volontario.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Volontario.jar"]