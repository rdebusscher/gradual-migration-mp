# Java EE app calling Interest MicroService

Implementation on WebLogic with added MicroProfile Config implementation and using Atbash Rest Client

## installation

Remark : this is the same as in demo 2, so no need to do it twice.

* Download WebLogic Quick Installer https://www.oracle.com/technetwork/middleware/weblogic/downloads/wls-main-097127.html
* Create a domain (<ORACLE_HOME>/oracle_common/common/bin/config.sh)
* Copy geronimo-config-impl-1.2.jar and microprofile-config-api-1.3.jar into <ORACLE_HOME>/user_projects/domains/mp_domain/lib


## Interest service

Make sure the Interest service (by KumuluzEE ) is running (se directory interest-kumuluzee)  

## Test

Name : Test
Amount : 100000
years : 15

and

Name : Rudy
Amount : 100000
years : 15



