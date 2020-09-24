#For Java 11
FROM maven:3.6-jdk-11 as builder
WORKDIR /build
#Copy pom.xml
COPY pom.xml .
COPY src ./src
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package
CMD exec java $JAVA_OPTS -jar /app/my-app.jar
COPY --from=target /build/target/*jar-with-dependencies.jar /app/hello.jar