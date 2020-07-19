#Multistaged docker build
ARG TOKEN
ARG URL

FROM maven:3.6-openjdk-8 AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -f pom.xml clean package

FROM java:8-jdk-alpine
ENV PACKAGE MeteoPaviaBot-*with-dependencies.jar
COPY --from=build /usr/src/app/target/$PACKAGE /usr/app/
ENTRYPOINT ["java","-jar","$PACKAGE", "$TOKEN", "$URL"]