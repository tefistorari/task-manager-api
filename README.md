# Task Manager

Full-stack task management application built with Java 21, Spring Boot and Angular.

## Features

- Create tasks with title, description and priority (LOW, MEDIUM, HIGH)
- List all tasks
- Mark tasks as completed
- Delete tasks
- Filter by completed or pending tasks

## Technologies

### Backend
- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL
- Lombok
- Bean Validation
- Maven

### Frontend
- Angular 19
- TypeScript
- CSS (dark mode + neon theme)

## Backend Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /tasks | Get all tasks |
| POST | /tasks | Create a task |
| PUT | /tasks/{id}/complete | Mark as completed |
| DELETE | /tasks/{id} | Delete a task |
| GET | /tasks/completed | Get completed tasks |
| GET | /tasks/pending | Get pending tasks |

## Setup

### Prerequisites
- Java 21
- MySQL
- Node.js + Angular CLI

### Backend
1. Clone the repository
2. Copy `application.properties.example` to `application.properties`
3. Set environment variables `DB_USERNAME` and `DB_PASSWORD`
4. Run with `./mvnw spring-boot:run`

### Frontend
1. Navigate to the `frontend` folder
2. Run `npm install`
3. Run `ng serve`
4. Open `http://localhost:4200`
