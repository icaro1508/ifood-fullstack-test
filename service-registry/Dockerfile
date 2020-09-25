FROM openjdk:11-jre-slim

COPY target/service-registry-0.0.1-SNAPSHOT.jar /opt/app/service-registry.jar

#ENV EUREKA_HOST http://localhost:8761/eureka

EXPOSE 8761

ENTRYPOINT ["java","-jar","/opt/app/service-registry.jar"]