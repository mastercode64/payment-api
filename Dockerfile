FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /app

EXPOSE 8080

COPY ./target/payment-api.jar /app/payment-api.jar

ENV TIMEZONE=America/Sao_Paulo

RUN sh -c 'touch /app/payment-api.jar' && echo "${TIMEZONE}" > /etc/timezone

CMD java -Xmx2g -Dspring.profiles.active=development -jar payment-api.jar