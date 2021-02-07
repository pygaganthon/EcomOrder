FROM openjdk:12
EXPOSE 8080
ADD target/spring-boot-docker2.jar spring-boot-docker2.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker2.jar"]
