FROM openjdk:17-oracle

EXPOSE 8081

COPY build/libs/AuthorizationServiceSpring-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

