# myRetail apiApplication

This project demonstrates a server get call to an external source to retreive some data in json format and aggregates that data with the server database data then sends it out to the client.

## Dependencies

* spring-boot-starter-web 2.1.1
* spring-boot-starter-data-mongo 2.1.1
* jackson-databind
* modelmapper 2.3.2

### Setup Project
git clone https://github.com/vangxbg/myRetail.git

### install by using dotnet to restores the dependencies and tools of a project:
```bash
$ dotnet restore
```

## Serving the project

From the root of this project, run:

```bash
$ ./mvnw package && java -jar target/apiApplication.0.0.1-SNAPSHOT.jar
```

This will run the application

## Description of the web application
* A http get call to the server @ http://localhost:8080/api/products/13860428 will retreive the information of this product in json format.  Example below:
```
{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "price": {
        "value": 66,
        "currencyCode": "CAD"
    }
}
```
* A http put call to the server @ http://localhost:8080/api/products/13860428 will edit the value and currency code of the product.  See example Json format for put request below (make sure value and currencyCode are valid):
```
{
	"value": "66.55",
	"currencyCode": "CAD"
}
```


## Author

Xa Vang (https://itsxa.com)
