#!/bin/sh

BASEDIR=$(dirname "$0")
docker stop transit
docker rm transit
docker rmi transit
docker build -t transit ${BASEDIR}
docker run --name transit -d -p 80:80 transit
