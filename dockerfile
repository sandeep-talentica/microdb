FROM openjdk:8-jdk-alpine
COPY target/microdb-0.0.1-SNAPSHOT.jar microdb.jar
ENTRYPOINT ["java","-jar", "microdb.jar"]