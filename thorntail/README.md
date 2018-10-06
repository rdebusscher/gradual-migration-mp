# Mortgage application as set of MicroServices


## blacklist-service-api

Contains the return value of the rest endpoint and the definition of the blacklist service as an interface.

## blacklist-service

Implementation of the blacklist service.

You can test it by starting the service with **start-blacklist.sh** and calling _http://localhost:8180/data/blacklist/<name>_.

## interest-service-api
 
Contains the return value of the rest endpoint and the definition of the interest service as an interface.

## interest-service

Implementation of the interest service.

You can test it by starting the service with **start-interest.sh** and calling _http://localhost:8280/data/interest/<value>?years=<nbr>

## mortgage-service-api
 
Contains the return value of the rest endpoint and the definition of the mortgage service as an interface.

## mortgage-service

Implementation of the interest service.

You can test it by starting the service with **start-mortgage.sh** and performing a POST to _http://localhost:8080/data/mortgage with

    {"name":"test","value":100000,"years":15}
    
## view

Implementation of the JSF View.

## Start all services

All the services can be started by the **start.sh** and application can be accessed by the URL _http://localhost:8080/index.xhtml_

## Test

Name : Test
Amount : 100000
years : 15

and

Name : Rudy
Amount : 100000
years : 15



