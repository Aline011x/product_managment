FROM openjdk:22-jdk 

#set working directory
WORKDIR /app
COPY target/inventarios-0.0.1-SNAPSHOT.jar /app/invent-app.jar
#expose backend port
EXPOSE 8080
#point to exec
ENTRYPOINT [ "java", "-jar", "/app/invent-app.jar" ]
