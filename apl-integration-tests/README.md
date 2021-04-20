# Apollo Blockchain API tests 

## How run on localhost
Comand: mvn clean test allure:serve 

allure:serve - report after tests

## How run on test
mvn clean test -Dtest.env=n1 allure:serve 

n1 - Testnet 1
n2 - Testnet 2
n3 - Testnet 3

If you use parameter test.env:
Test get random peer from test.

### Forging 
Tests start forging on APL-NZKH-MZRE-2CTT-98NP (if only any peer doesn't forging)


## Requirements
Java 11 is required to run the tests.
