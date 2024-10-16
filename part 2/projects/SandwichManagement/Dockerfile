FROM openjdk:8-jdk-alpine
COPY target/SandwichManagement-0.0.1-SNAPSHOT.jar SandwichManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-Dspring-boot.run.profiles=prod","-jar","/SandwichManagement-0.0.1-SNAPSHOT.jar"]