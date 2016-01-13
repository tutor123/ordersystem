#!/bin/sh

start_all()
{

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

    echo "starting Shipping"
    cd ../shipping
    nohup mvn spring-boot:run & 2>&1 > /dev/null
    sleep 8

    echo "All service started"
}

start() 
{
    jps  -lv | grep "$1" | cut -d ' ' -f 1 | xargs  -n1 kill
    echo "starting $1"
    path="../$1"
    cd $path
    nohup mvn spring-boot:run & 2>&1 > /dev/null
    sleep 5
}

if [ $# -eq 0 ]; then
    start_all
else
    start $1
fi
