
FROM maven:3.5-jdk-8-slim AS build
WORKDIR /home/app
COPY src /home/app/src

COPY pom.xml /home/app/

RUN mvn clean package -DskipTests 

FROM openjdk:8-alpine
COPY --from=0 /home/app/target/QPrimeNTTConnectionTest-0.0.1-SNAPSHOT.jar /tmp/qprimenttconnectiontest.jar


EXPOSE 80/tcp
ENTRYPOINT ["java","-jar","/tmp/qprimenttconnectiontest.jar"]
