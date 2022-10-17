# spring-boot math-api

Api with mathematical operations
- /max - (http://localhost:8080/math/max?numbers=1,5,4,7,8&quantity=3)
- /min - (http://localhost:8080/math/min?numbers=1,5,4,7,8&quantity=3)
- /average - (http://localhost:8080/math/average?numbers=1,5,4,7,8)
- /median - (http://localhost:8080/math/median?numbers=67,70,75,76,77,78,80,83,85,87,88,89,90,93,95)
- /percentile (http://localhost:8080/math/percentile?numbers=67,70,75,76,77,78,80,83,85,87,88,89,90,93,95&rank=66)

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org/download.cgi)
- [Docker (Optional)](https://www.docker.com/)

## Running the application locally with spring-boot plugin

```shell
mvn spring-boot:run
```

## Deploying on docker container locally

```shell
mvn package
docker run --rm -d  -p 8080:8080/tcp douglas/math-api:0.0.1-SNAPSHOT
```