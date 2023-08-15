# labseq-api
labseq rest api

The labseq application is a RESTful API that calculates the labseq function. The labseq function is defined as follows:

```
labseq(n) = 
    0 if n <= 3
    labseq(n - 4) + labseq(n - 3) if n > 3
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

The labseq application also includes a caching layer. The cache is used to store the results of previously calculated labseq values. This can improve performance for subsequent requests for the same value.

The cache is implemented using the `LabseqCaching` class. The `LabseqCaching` class provides methods for storing and retrieving values from the cache.

The `LabseqService` class is responsible for calculating the labseq value. The `LabseqService` class first checks the cache to see if the value has already been calculated. If the value is not in the cache, the `LabseqService` class calculates the value and stores it in the cache.

The `LabseqController` class is responsible for handling requests for the labseq function. The `LabseqController` class uses the `LabseqService` class to calculate the labseq value and returns the result to the client.
