FROM openjdk:17-jdk-alpine
WORKDIR app
COPY target/plant-care-tracker-3.3.0.jar /app/plant-care-tracker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "plant-care-tracker.jar"]