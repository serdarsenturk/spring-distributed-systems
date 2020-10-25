#Maven Build
FROM maven:3.6-jdk-11 AS build
COPY . /usr/src/app/
WORKDIR /usr/src/app/
RUN mvn -f /usr/src/app/pom.xml clean package


#Package build
FROM openjdk:11.0-jre
WORKDIR /
COPY --from=build /usr/src/app/target/*.jar /app.jar
CMD java -jar app.jar