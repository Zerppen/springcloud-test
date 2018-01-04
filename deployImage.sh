#!/bin/bash

cd api-gateway

mvn -Dmaven.test.skip=true clean package docker:build

docker push hub.ac.chainnova.com:5000/test-docker

