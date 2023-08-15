# labseq-api
labseq rest api

The labseq application is a RESTful API that calculates the labseq function. The labseq function is defined as follows:

```
Definition:
n=0 => l(0) = 0
n=1 => l(1) = 1
n=2 => l(2) = 0
n=3 => l(3) = 1
n>3 => l(n) = l(n-4) + l(n-3)

Code:
LabseqCaching cache = new LabseqCaching();

    public int labSeq(int n){
        
        // if value is in cache, return the cached value
        if(cache.valueIsCached(n)) return cache.getCachedKey(n);
        
        if(n <= 3) return (n % 2 == 0) ? 0 : 1;
        
        int newValue = labSeq(n - 4) + labSeq(n - 3);
        
        cache.putCachedKey(n, newValue);

        return newValue;
    }
```

The application is built using the Spring Boot framework. To run the application, you can use the following command:

```
mvn spring-boot:run
```

The application will be available on port 8080. You can test the application using the following curl command:

```
curl -X GET http://localhost:8080/labseq/5
```

This command will return the following response:

```
{"LabseqN": 4}
```

In case you are running a frontend, make sure its on :4200 since its what is configured as expected.

```
registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/")
                .allowedMethods("GET");
```

Swagger URL 

```
http://localhost:8080/swagger-ui/index.html#/
```

The labseq application also includes a caching layer. The cache is used to store the results of previously calculated labseq values. This can improve performance for subsequent requests for the same value.

The cache is implemented using the `LabseqCaching` class. The `LabseqCaching` class provides methods for storing and retrieving values from the cache.

The `LabseqService` class is responsible for calculating the labseq value. The `LabseqService` class first checks the cache to see if the value has already been calculated. If the value is not in the cache, the `LabseqService` class calculates the value and stores it in the cache.

The `LabseqController` class is responsible for handling requests for the labseq function. The `LabseqController` class uses the `LabseqService` class to calculate the labseq value and returns the result to the client.

#Docker

 Dockerfile for the Spring Boot application:

```
FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

This Dockerfile will create an image that is based on the openjdk:19-jdk-alpine image. The image will have the app.jar file copied into the /app directory. The port 8080 will be exposed, and the image will be configured to run the java -jar command to start the app.jar file.

To build the image, you can use the following command:


```
docker build -t labseq:site1 --build-arg JAR_FILE=target/*.jar .
```


To run the image, you can use the following command:


```
docker run -d -p 8080:8080 labseq:site1
```

 Dockerfile for the angular application:
```
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install --silent
RUN npm run build 

FROM nginx:latest

COPY --from=node /app/dist/consumer /usr/share/nginx/html
COPY ./config/nginx.conf /etc/ngix/conf.d/default.conf
```

Angular docker commands:


```
docker build -t frontend:site1 .
docker run -d -p 4200:80 frontend:site1
docker stop $(docker ps -a -q)
