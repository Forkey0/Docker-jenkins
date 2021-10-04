FROM openjdk:11
EXPOSE 8383
ADD target/Jenkins-docker-integration.jar Jenkins-docker-integration.jar
ENTRYPOINT ["java","-jar9698+56","/Jenkins-docker-integration.jar"]