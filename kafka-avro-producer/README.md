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

### Prerequisites

Setup a running kafka instance using Rancher Desktop or alike emulator

1. Assuming you have helm installed, install a few charts for kafka and schema registry in your k8s:
```bash
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo add confluentinc https://confluentinc.github.io/cp-helm-charts/

helm install kafka bitnami/kafka --set externalAccess.enabled=true,externalAccess.service.type=NodePort,externalAccess.service.nodePorts[0]=31390,externalAccess.service.domain=localhost
helm install --set cp-kafka-rest.enabled=false,cp-kafka-connect.enabled=false,cp-control-center.enabled=false,cp-ksql-server.enabled=false,cp-kafka.enabled=false,cp-zookeeper.enabled=false,cp-schema-registry.prometheus.jmx.enabled=false,cp-schema-registry.kafka.bootstrapServers=kafka:9092 schema confluentinc/cp-helm-charts
```
2. Wait for the pods to start up and then expose schema registry:
```bash
kubectl.exe port-forward svc/schema-cp-schema-registry 31000:8081
```
After that you can run the application itself and call the APi it provides.


* You can use [Postman](https://www.postman.com/) to import
  the [cats-and-dogs-adoption-spec.yaml](src/main/resources/cats-and-dogs-adoption-spec.yaml) or just `curl` following
  it closely to check
  out how it works.
* create a new pet and observe it is advertised properly by running the
  counterpart [consumer application](../kafka-avro-consumer)
