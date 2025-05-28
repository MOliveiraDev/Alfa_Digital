FROM ubuntu:latest AS builder
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:21-slim
COPY --from=builder /app/target/ab_API-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
