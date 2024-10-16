FROM openjdk:8-jdk-alpine
COPY target/PromotionManagement-0.0.1-SNAPSHOT.jar PromotionManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-Dspring-boot.run.profiles=prod","-jar","/PromotionManagement-0.0.1-SNAPSHOT.jar"]