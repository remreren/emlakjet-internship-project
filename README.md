# Emlakjet Internship Project
I developed two applications in the domain of the project.
In the first project named [panel-api](panel-api), you can do advert related operations (like create, update, remove, approve or disapprove and show the adverts).

When the panel-api publishes a message that needs to index or un-index the advert, the second project named [search-consumer](search-consumer) reacts to the messages published and indexes or un-indexes the advert.

## Aim of the project
The aim of the project was creating a project with state-of-the-art-tools, microservices architecture and Hexagonal architecture.

I tried to use best known technologies in the project. The list of technologies will be listed below.

## Getting started
These instructions will give you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on deploying the project on a live system.

### System design
![System Design](https://github.com/remreren/emlakjet-internship-project/raw/master/doc/System%20Design.jpg)

### Prerequisites
#### For installation / trial purpose
* Docker

#### For development purpose
* JDK 17+
* Maven

### Installation
```shell
docker-compose up
```

### Development
First run the stack (Elasticsearch, Kibana, Postgresql, Kafka)
```shell
docker-compose -f docker-compose.stack.yml up
```
Then start development, run everything locally without creating images.

### Running tests
```shell
mvn clean test
```

# Deployment

# Built With
* Java 17
* Spring Boot
* Kafka
* Postgresql
* Elasticsearch
* Kibana
* Protobuf
* Testcontainers

