FROM openjdk:8
EXPOSE 8080

ENTRYPOINT ["java","-jar","/docker-jenkins-integration.jar"]
