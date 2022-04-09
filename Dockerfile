FROM openjdk:17.0.2-slim
WORKDIR /aqua
COPY ./target/aqua.jar /aqua/
ENTRYPOINT ["java","-jar","/aqua/aqua.jar"]
