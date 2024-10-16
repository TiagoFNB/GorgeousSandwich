FROM openjdk:8-jdk-alpine
COPY target/UserManagement-0.0.1-SNAPSHOT.jar UserManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-Dspring-boot.run.profiles=prod","-jar","/UserManagement-0.0.1-SNAPSHOT.jar"]