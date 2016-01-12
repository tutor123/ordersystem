FROM ewolff/docker-java


ADD target/order-0.0.1-SNAPSHOT.jar order.jar

RUN mkdir /resources
ADD src/main/resources/static /resources/static  
ADD src/main/resources/templates /resources/templates

ENTRYPOINT ["java", "-jar", "/order.jar"]
CMD [""]

EXPOSE 8081
