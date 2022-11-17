FROM openjdk:8
WORKDIR /app
ADD target/challenge.jar /app/challenge.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "challenge.jar"]