FROM openjdk:11
ADD build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 8080