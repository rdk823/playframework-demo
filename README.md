# Playframework Webservice

- This is a simple Scala and Playframework RESTful API's service template


## Prerequisites

## How to run the application
  - sbt run - [Instructions to install sbt](https://www.scala-sbt.org/1.x/docs/Setup.html) 
  
  - Docker [Instructions to install Docker](https://docs.docker.com/get-docker/)

### Publish docker and run docker container
   - To create docker image run `sbt docker:publishLocal`
   - To run the docker container `docker run -it -p 5000:5000 imageid`
   - Visit http://localhost:9000/ and it will display `Application is up and running`
   - Health check endpoint
            - GET Request to http://localhost:9000/health
               - Response : `{"Status":"up"}`
   
## Other useful links
   - [Play 2.8.x documentation](https://www.playframework.com/documentation/2.8.x/Home)
   - [SBT](https://www.scala-sbt.org)