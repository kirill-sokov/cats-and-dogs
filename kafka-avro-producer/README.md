# Kafka avro producer

This repo contains the [server side implementation](../openapi-rest-server) of OpenAPI spec extended with
Kafka [Avro message format](https://avro.apache.org/docs/current/) communication.

## Use cases

* Upon creating a new pet or updating it, an advertisement should be sent to everyone to have a look at it
* Once the cat or dog is removed from the registry, it should be immediately marked as adopted and the notification
  should as well be sent to everyone

## Technologies used

* Avro schema is defined as [`CatAdvertised.avsc`](src/main/avro/PetAdvertised.avsc)
* All models are generated from the spec using openapi plugin, it also generates interfaces for the API implementation
  and takes care of the validation before it reaches Controller classes
* [Zalando Problem type library](https://github.com/zalando/problem) to support error formatting

## Running the sample

* You can use [Postman](https://www.postman.com/) to import
  the [cats-and-dogs-adoption-spec.yaml](src/main/resources/cats-and-dogs-adoption-spec.yaml) or just `curl` following it closely to check
  out how it works.
* create a new pet and observe it is advertised properly by running the
  counterpart [consumer application](../kafka-avro-consumer)
