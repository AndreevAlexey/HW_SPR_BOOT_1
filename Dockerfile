FROM adoptopenjdk/openjdk11:jdk-11.0.13_8-alpine
EXPOSE 8080
ADD target/HW_SPR_BOOT_1-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]