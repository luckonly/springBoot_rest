FROM  openjdk:8-jdk-alpine
EXPOSE 80
ADD /target/springBoot_rest-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java", "-jar","/myapp.jar"]