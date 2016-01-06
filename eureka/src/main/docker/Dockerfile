
FROM ewolff/docker-java
ADD eureka-0.0.1-SNAPSHOT.jar /eureka.jar
RUN bash -c 'touch /eureka.jar'
EXPOSE 8762
ENTRYPOINT ["java","-jar","/eureka.jar"]
