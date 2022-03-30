## Build application

`./gradlew bootJar`

docker build from the root directory

`docker build -t app.jar .  `

## Start application

This will load the dashboard and one background job server

`docker compose up  `

A lot of load incoming - scale background job servers up: 

`docker compose up  --scale springboot-backend=3`

## Open dashboard
[http://localhost:8000/dashboard/overview](http://localhost:8000/dashboard/overview)


## Enqueue a lot of jobs via the API exposed on dashboard instance:
[http://localhost:8080/via-job-lambda/enqueue-example-job](http://localhost:8080/via-job-lambda/enqueue-example-job)

## Log output
```java
springboot-backend_2            | Executing sample job with input: Hello World
springboot-backend_3            | Executing sample job with input: Hello World
springboot-backend_3            | Executing sample job with input: Hello World
springboot-backend_1            | The recurring job has begun.
```



