# spring-boot math-api

Api with mathematical operations
- /max
- /min
- /average
- /median
- /percentile

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