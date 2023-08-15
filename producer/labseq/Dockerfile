FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","/app.jar"]

#docker build -t labseq:site1 --build-arg JAR_FILE=target/*.jar .
#docker run -d -p 8080:8080 labseq:site1