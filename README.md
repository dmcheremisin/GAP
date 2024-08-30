# Getting Started

## Requirements:
1. JDK 17
2. Maven
3. Docker

## Build
1. cd springapp
2. mvn clean package

## Run
1. cd <project root>
2. docker-compose up -d --build

## Endpoints for test
1. Get Fibonacci  
GET http://localhost:8081/fibo/78  
2. Prometheus actuator   
GET http://localhost:8081/actuator/prometheus   

## Prometheus
1. Get prebuilt metric  
Example: jdbc_connections_idle  
Result: jdbc_connections_idle{instance="springapp:8081", job="springapp", name="dataSource"} 10    

2. Custom metric - total controller request  
Example: fibo_controller_requests_total  
Result: fibo_controller_requests_total{controller="fibo", instance="springapp:8081", job="springapp"} 7    

3. Custom metric - input parameter gauge  
Example: fibo_controller_input  
Result: fibo_controller_input{instance="springapp:8081", job="springapp"} 456      

4. Custom metric - execution time   
Example: fibo_execution_time_seconds_count  
Result: fibo_execution_time_seconds_count{class="com.example.springapp.service.FiboDataService", exception="none", instance="springapp:8081", job="springapp", method="getFibo"} 7

## Grafana
Username: admin  
Password: admin  
Grafana is preconfigured with 2 dashboards: Fibo requests and PostgreSQL Database
- Fibo requests is custom dashboard for visualisation of 3 metrics: total requests(counter), input request parameter(gauge), fibo_execution_time_seconds_count(counter)
- PostgresSQL Database is dashboard that gets metrics about Postgres with help of exporter https://github.com/prometheus-community/postgres_exporter