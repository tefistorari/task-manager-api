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
- PostgreSQL
- Lombok
- Bean Validation
- Maven

### Frontend
- Angular 19
- TypeScript
- CSS (dark mode + neon theme)

### Infrastructure
- Docker
- Docker Compose
- Nginx

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
- Docker
- Docker Compose

### Run with Docker
1. Clone the repository
2. Copy `application.properties.example` to `application.properties` in `src/main/resources/`
3. Set environment variables `DB_URL`, `DB_USERNAME` and `DB_PASSWORD`
4. Run:
```bash
docker compose up --build
```
5. Open `http://localhost:4200`

### Run locally (without Docker)
#### Backend
1. Install Java 21 and Maven
2. Configure `application.properties` with your database credentials
3. Run: `./mvnw spring-boot:run` or press the ▶ button in IntelliJ next to the `main` method

#### Frontend
1. Install Node.js and Angular CLI
2. Navigate to `frontend/`
3. Run: `npm install && ng serve`
4. Open `http://localhost:4200`