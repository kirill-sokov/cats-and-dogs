# Client side OpenAPI Rest implementation

This repo contains the client side implementation of a defined cats and dogs spec.

## Use Case

Client application should be able to reach out to server and execute available operations defined in [OpenAPI
specification](src/main/resources/cats-and-dogs-spec.yaml)

## Technologies used

* Much like [server side](../openapi-rest-server), client side uses the same openapi plugin, but with client
  configuration, instructing the plugin to create the required models and API Client code for communication
* Sample `TestService` class illustrates how easy the API usage becomes provided the beans are properly configured

## Testing

Once the [server side](../openapi-rest-server) application is running, you can build and run the client side as well and
observe in logs how sample
animals are created and listed