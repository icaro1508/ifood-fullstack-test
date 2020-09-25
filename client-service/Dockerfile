FROM openjdk:11-jre

COPY target/client-service-0.0.1-SNAPSHOT.jar /opt/app/client-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/opt/app/client-service.jar"]