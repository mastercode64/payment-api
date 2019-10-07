FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080

ENV TIMEZONE=America/Sao_Paulo

# Add the application's jar to the container
ADD target/payment-api.jar payment-api.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/payment-api.jar"]