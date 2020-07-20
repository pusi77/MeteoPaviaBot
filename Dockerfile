# Multistaged docker build
# ARG cannot be used in ENTRYPOINT, but ENV can
ARG TOKEN
ENV TOKEN_ENV=$TOKEN
ARG URL
ENV URL_ENV=$URL

FROM maven:3.6-openjdk-8 AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.1.1:go-offline
COPY . .
RUN mvn -B -e -o -T 1C verify

FROM java:8-jdk-alpine
COPY --from=build /usr/src/app/target/MeteoPaviaBot-1.0-jar-with-dependencies.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","MeteoPaviaBot-1.0-jar-with-dependencies.jar", "${TOKEN_ENV}", "${URL_ENV}"]