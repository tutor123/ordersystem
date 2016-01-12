#!/bin/sh

echo "starting Eureka"
cd ../eureka
nohup mvn spring-boot:run & 2>&1 > /dev/null
sleep 5


echo "starting Customer"
cd ../customer
nohup mvn spring-boot:run & 2>&1 > /dev/null
sleep 8

echo "starting Item"
cd ../item
nohup mvn spring-boot:run & 2>&1 > /dev/null
sleep 8

echo "starting Order"
cd ../order
nohup mvn spring-boot:run & 2>&1 > /dev/null
sleep 8

echo "starting Bill"
cd ../bill
nohup mvn spring-boot:run & 2>&1 > /dev/null
sleep 8

echo "All service started"
