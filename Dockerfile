FROM openjdk:8
EXPOSE 8080
ADD /root/.jenkins/workspace/AutoDeployDocker/back_end/quizbuzz/target/docker-jenkins-integration.jar docker-jenkins-integration.jar
ENTRYPOINT ["java","-jar","/docker-jenkins-integration.jar"]
