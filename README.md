# Cats and Dogs

Simple library of templates that I'm using to bootstrap an often used solution

## Projects

### Rest API

Rest API is often used together with formalized [OpenAPI specification](https://swagger.io/specification/)/ There are
two sides of it - client implementation and server side implementation.

* [Client side](openapi-rest-client) Rest implementation
* [Server side](openapi-rest-server) Rest implementation

### Kafka

Kafka comes with a sample consumer and producer, to make things serious, the project samples helm chart generation and
[Avro message format](https://avro.apache.org/docs/current/) used in between.

* [Kafka Avro producer](kafka-avro-producer)
* [Kafka Avro consumer](kafka-avro-consumer)

### GraphQL

[GraphQL](https://graphql.org/) server and client implementation

* [GraphQL server](graphql-server)
* [GraphQL client](graphql-client)

### Cucumber testing framework

[Cucumber](https://cucumber.io/) testing framework used outside of the actual code to create a cycle of tests that
verify the API works as expected.

* [Cucumber tests project](cucumber-external-test-cycle)