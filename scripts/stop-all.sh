#!/bin/sh

jps  -lv | grep ordersystem | cut -d ' ' -f 1 | xargs  -n1 kill

echo "all services stopped"
