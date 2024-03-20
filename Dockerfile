FROM eclipse-temurin:17-jdk-alpine

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

USER appuser

WORKDIR /app

COPY target/develfood-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
