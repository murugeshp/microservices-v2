FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD target/*.jar checkoutpurchase-0.0.2-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /checkoutpurchase-0.0.2-SNAPSHOT.jar"]