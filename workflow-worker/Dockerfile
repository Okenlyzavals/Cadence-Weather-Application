FROM amazoncorretto:17
COPY ./build/libs/workflow-worker-1.0.0.jar workflow-worker-1.0.0.jar
ENTRYPOINT ["java","--add-opens=java.base/java.time=ALL-UNNAMED","--add-opens=java.base/java.util=ALL-UNNAMED","--add-opens=java.base/java.lang=ALL-UNNAMED","-jar","workflow-worker-1.0.0.jar"]