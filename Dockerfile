FROM openjdk:8-jdk-alpine
EXPOSE 8181
ADD target/callapi.jar callapi.jar
ENTRYPOINT ["java","-jar","/callapi.jar"]