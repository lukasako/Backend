FROM amazoncorretto:8-alpine-jdk
MAINTAINER LucasMorales
COPY target/LucasMorales-0.0.1-SNAPSHOT.jar LucasMorales-app.jar
ENTRYPOINT ["java","-jar","/LucasMorales-app.jar"]