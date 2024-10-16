FROM openjdk:8-jdk-alpine
COPY target/ShopManagement-0.0.1-SNAPSHOT.jar ShopManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-Dspring-boot.run.profiles=prod","-jar","/ShopManagement-0.0.1-SNAPSHOT.jar"]