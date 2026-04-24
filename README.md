# Task Manager API

Simple REST API built with Java 21 and Spring Boot.

## Features

- Create tasks
- List all tasks
- Mark task as completed
- Delete task
- View completed tasks
- View pending tasks

## Technologies

- Java 21
- Spring Boot
- Maven
- Lombok
- Bean Validation

## Endpoints

GET /tasks  
POST /tasks  
PUT /tasks/{id}/complete  
DELETE /tasks/{id}  
GET /tasks/completed  
GET /tasks/pending

## Notes

This project uses in-memory storage (ArrayList), no database required.