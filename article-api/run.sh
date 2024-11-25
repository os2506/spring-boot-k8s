#!/bin/bash

declare dc_infra="/Users/dnaprodudction/workspace2025/spring-boot-application/article-api/docker-compose.yml"
declare dc_app="/Users/dnaprodudction/workspace2025/spring-boot-application/article-api/docker-compose-app.yml"


function build_api() {
    cd /Users/dnaprodudction/workspace2025/spring-boot-application/article-api
    ./mvnw clean package -DskipTests
}

function start_infra() {
    echo "Starting infra docker containers..."
    docker-compose -f ${dc_infra} up -d
    docker-compose -f ${dc_infra} logs -f
}

function stop_infra() {
    echo "Stopping infra docker containers..."
    docker-compose -f ${dc_infra} down
}

function start() {
    build_api
    echo "Starting all docker containers..."
    docker-compose -f ${dc_infra} -f ${dc_app} up --build -d
    docker-compose -f ${dc_infra} -f ${dc_app} logs -f
}

function stop() {
    echo "Stopping all docker containers..."
    docker-compose -f ${dc_infra} -f ${dc_app} down
}

function restart() {
    stop
    sleep 3
    start
}

action="start"

if [[ "$#" != "0"  ]]; then
    action=$@
fi

eval ${action}
