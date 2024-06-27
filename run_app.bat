call docker compose down
call mvn clean install -DskipTests
call docker compose up -d
call mvn spring-boot:run