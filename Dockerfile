FROM amazoncorretto:21-alpine3.17

LABEL author="kelvosk"

COPY ./build/libs/*.jar app.jar

EXPOSE 8080

ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV PATH=$PATH:/usr/lib/jvm/default-jvm/bin

ENTRYPOINT ["java", "-jar", "app.jar"]