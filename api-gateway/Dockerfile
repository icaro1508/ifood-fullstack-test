FROM openjdk:11-jre-slim

COPY target/api-gateway-0.0.1-SNAPSHOT.jar /opt/app/api-gateway.jar

#ENV EUREKA_URI http://localhost:8761/eureka

EXPOSE 8080

ENTRYPOINT ["java","-jar","/opt/app/api-gateway.jar"]