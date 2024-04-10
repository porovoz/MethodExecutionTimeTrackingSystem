### (RU)
# Method execution time tracking system

## Описание проекта:
Система учета времени выполнения методов в приложении с использованием Spring Boot и Spring AOP.
Данная система способна синхронно и асинхронно логировать и анализировать данные о времени выполнения методов, помеченных специальными аннотациями.

## REST API
URL: http://localhost:8080

- GET /method-execution-time-tracking - получение всех данных учета времени выполнения методов по всем методам
- GET /method-execution-time-tracking/all-stats - получение статистики по среднему и общему времени выполнения методов

Подробнее: http://localhost:8080/swagger-ui/index.html

## Запуск приложения:
- клонировать проект в среду разработки;
- настроить подключение к базе данных в файле application.properties;
- аннотировать методы аннотациями @TrackTime и @TrackAsyncTime, время выполнения которых нужно отслеживать.
- запустить метод main в файле MethodExecutionTimeTrackingSystemApplication.java

После этого будет доступен OpenAPI http://localhost:8080/swagger-ui/index.html.

## Технологии, используемые в проекте:
- Java 17;
- Spring Boot;
- Spring AOP;
- Spring Data JPA;
- SpringDoc;
- Maven;
- REST API;
- Lombok;
- PostgreSQL,
- Liquibase.

### (EN)
# Method execution time tracking system

## Project description:
A system for tracking the execution time of methods in an application using Spring Boot and Spring AOP.
This system is capable of synchronously and asynchronously logging and analyzing data on the execution time of methods marked with special annotations.

## REST API
URL: http://localhost:8080

- GET /method-execution-time-tracking - getting all method execution time tracking data for all methods.
- GET /method-execution-time-tracking/all-stats - getting statistics on the average and total execution time of methods.

More detailed: http://localhost:8080/swagger-ui/index.html

## How to run an application:
- clone the project into the development environment;
- configure the connection to the database in the application.properties file;
- annotate methods with @TrackTime and @TrackAsyncTime annotations, the execution time of which needs to be monitored;
- run the main method in the file MethodExecutionTimeTrackingSystemApplication.java.

After doing that OpenAPI by this URL http://localhost:8080/swagger-ui/index.html will be available.

## Technologies:
- Java 17;
- Spring Boot;
- Spring AOP;
- Spring Data JPA;
- SpringDoc;
- Maven;
- REST API;
- Lombok;
- PostgreSQL.