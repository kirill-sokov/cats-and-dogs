# Server side openapi rest implementation

This repo contains the server side implementation of a defined cats and dogs spec.

## Use cases

* Admin is able to add, remove, search by a name, list all and update two kinds of animals - cats and dogs.
* A restriction should apply for write access - such as delete and update operations to be availible only for specific
  users that have access to this.
* API should be protected and only authorized users can access it

## Technologies used

* DB choice is made in favour of in-memory Spring H2 database to keep interactions simple/
* User authentication is implemented via Basic Authentication in the easiest way possible as well
* User authorization contains three possible roles - `Admin`, `Doglover` and `Catlover`
    * By default any authenticated user can read any data
    * `Catlover` and `Doglover` grants write access to the respective animals
    * `Admin` can do anything it wants
* The role is checked via Spring annotation `@PreAuthorize`
* All models are generated from the spec using openapi plugin, it also generates interfaces for the API implementation
  and takes care of the validation before it reaches Controller classes
* Spring JPA is used for managing Entities
* [Zalando Problem type library](https://github.com/zalando/problem) to support error formatting

## Running the sample

By default when you run the application, two users will be created as noted in [data.sql](src/main/resources/data.sql)
that can be then used for accessing the API at http://localhost:8080.

You can use [Postman](https://www.postman.com/) to import
the [cats-and-dogs-spec.yaml](src/main/resources/cats-and-dogs-spec.yaml) or just `curl` following it closely to check
out how it works. 