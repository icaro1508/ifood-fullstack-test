FROM openjdk:11-jre

COPY ./target/order-service-0.0.1-SNAPSHOT.jar /opt/app/order-service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","/opt/app/order-service.jar"]
