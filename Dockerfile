FROM eclipse-temurin:17-jdk-focal
VOLUME /tmp
ARG JAR_FILE
COPY ./build/libs/Project-1.0.2.jar Project_Backend.jar
ENTRYPOINT ["java","-jar","/Project_Backend.jar"]