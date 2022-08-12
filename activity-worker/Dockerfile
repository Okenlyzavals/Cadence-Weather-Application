FROM amazoncorretto:17
COPY ./build/libs/activity-worker-1.0.0.jar activity-worker-1.0.0.jar
ENTRYPOINT ["java","--add-opens=java.base/java.time=ALL-UNNAMED","--add-opens=java.base/java.util=ALL-UNNAMED","--add-opens=java.base/java.lang=ALL-UNNAMED","-jar","activity-worker-1.0.0.jar"]