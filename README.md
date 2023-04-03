# postcodeAPI Backend Project

A backend API project developed using Spring and Java.

![postCodeApi](https://user-images.githubusercontent.com/119549394/229388338-b510837b-78db-45b0-8606-a7d7e140777c.PNG)

## Overview

This project involved creating a backend API using Spring Boot and Java which would enable a consumer of the API to do some CRUD (GET and POST) operations. It is also designed to be RESTful so that it can scale.

## Running the Application

1. Initialise MySQL database with name employee_creator_backend

       CREATE DATABASE postcode_backend
       
2. Set up the API in Spring in production/src/main/resources/application.properties

       spring.datasource.url=jdbc:mysql://localhost:3306/postcode_backend
       spring.datasource.username=root
       spring.datasource.password=<YOUR_ROOT_PASSWORD>
       spring.jpa.hibernate.ddl-auto=update
       spring.jpa.generate-ddl=true
       
3. Run the Spring API using an IDE of your choice

## Tech Stack

Spring Boot: To build and test the backend with the relevant dependancies. 
MySQL: To build a scalable and reliable relational database.
Java: To build the backend, used for it's scalability and integration of other frameworks/technologies (i.e. Spring Boot).

## MVP

The requirements of the project were to:

- To create an API in Java that would allow mobile clients to retrieve and add suburb/postcode combinations.
- To have a secured API endpoint to add new suburb and postcode combinations
- To have persistence
- To have tests for controller/service layers

## Features
- POST and GET of postcode data
- Allows a user to Get by suburb and/or Get by postcode
- RESTful
- Persistence through MySQL workbench database
- Testing

