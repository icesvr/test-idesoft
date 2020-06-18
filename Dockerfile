FROM openjdk:11.0.6-jre 
COPY "./target/spring-docker-app.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]