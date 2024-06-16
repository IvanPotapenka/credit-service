FROM openjdk:17-jdk-alpine3.14
COPY ./build/libs/credit-service-1.0.0.jar credit-service.jar
ENTRYPOINT ["java", "-jar", "credit-service.jar"]
