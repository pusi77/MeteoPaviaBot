#Multistaged docker build
ARG TOKEN
ARG URL

FROM maven:3.6-openjdk-8 AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -f pom.xml clean package

FROM java:8-jdk-alpine
ENV PACKAGE MeteoPaviaBot-*with-dependencies.jar
COPY --from=build /usr/src/app/target/MeteoPaviaBot-1.0-jar-with-dependencies.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","MeteoPaviaBot-1.0-jar-with-dependencies.jar", "$TOKEN", "$URL"]