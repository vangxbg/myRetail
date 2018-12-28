# myRetail apiApplication

This project demonstrates the ability of an application that can retreive product price information from a NOSQL mongo database and product name from an external api and aggregates the information to then send to the client who requested an http get from the server.  The user can also edit the product price information by sending an http put but cannot edit the product name (because the name is stored on an external api only).

## Dependencies

* spring-boot-starter-web 2.1.1
* spring-boot-starter-tomcat 2.1.1
* spring-webmvc 5.1.3
* spring-boot-starter-data-mongo 2.1.1
* jackson-databind 2.9.7
* modelmapper 2.3.2

### Setup Project
You can clone this project using git clone https://github.com/vangxbg/myRetail.git

### install by using dotnet to restores the dependencies and tools of a project:

To download the dependencies, run this from the root of the project:

```bash
$ dotnet restore
```

## Serving the project

From the root of this project, run:

```bash
$ ./mvnw package && java -jar target/apiApplication.0.0.1-SNAPSHOT.jar
```

This will run the application on:

* http://localhost:8080
* Also please make sure you download mongodb and that it is listening on port 27017

## Description of the web application

* Models folder contains the domain objects that will directly map to the database.  Resource folders contain the domain transfer objects that will communicate with request and response.  Repository folder will contain the methods for making calls to the mongo database.  Controller class will be routing and handling the client request as well as retrieving data from an external api.  The service folder contains the methods that the controller can use to communicate with the repository.

* A client http get call to the server @ http://localhost:8080/api/products/13860428 will retreive the information of this product in json format.  If the product does not exist you will get a 400 bad request.  Example below for response:
```
{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "price": {
        "value": 66.99,
        "currencyCode": "CAD"
    }
}
```
* A http put call to the server @ http://localhost:8080/api/products/13860428 will edit the value and currency code of the product.  See example Json body for put request below (make sure value and currencyCode are valid, other wise a 400 bad request will be returned):
```
{
	"value": "66.55",
	"currencyCode": "CAD"
}
```
* Example of a bad request:
![alt text](https://github.com/vangxbg/myRetail/blob/master/putRequest.png)<br>

* You can also make a get call to http://localhost:8080/api/async/products to retrieve all the products and this is based on an asynchronous architecture.  The idea is that a products collection is also stored in mongo db so that you don't have to constantly make calls to the external api at each request.  (This implementation is not yet completed but you can retrieve sample products from this endpoint)


## Author

Xa Vang (https://itsxa.com)
