FROM openjdk:17-jdk-alpine
WORKDIR app
COPY target/plant-care-planner-3.3.0.jar /app/plant-care-planner.jar
ENTRYPOINT ["java", "-jar", "plant-care-planner.jar"]