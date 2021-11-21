FROM openjdk:11-jdk
COPY target/ddco-0.0.1-SNAPSHOT.jar ddco-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ddco-0.0.1-SNAPSHOT.jar"]