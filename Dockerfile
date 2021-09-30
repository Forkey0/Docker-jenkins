FROM openjdk:11
EXPOSE 8383
ADD target/docker=Jenkins-docker-integration.jar docker=Jenkins-docker-integration.jar
ENTRYPOINT ["java","-jar","Jenkins-docker-integration.jar"]