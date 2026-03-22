# 🚀 TaskFlow Backend - Task Management API

## 📌 Project Overview
TaskFlow is a backend application built using Spring Boot that provides RESTful APIs for managing tasks and task lists. It supports priority levels, status tracking, due dates, and hierarchical subtasks.

---

## ✨ Features
- Create, update, delete Task Lists
- Create, update, delete Tasks
- Task status tracking (OPEN / CLOSED)
- Priority management (LOW / MEDIUM / HIGH)
- Due date handling
- Subtask (parent-child) hierarchy
- Global exception handling
- Input validation
- Swagger API documentation

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Lombok
- Swagger (OpenAPI)

---

## 📡 API Endpoints

### Task List APIs
- `POST /api/task-lists` → Create task list
- `GET /api/task-lists` → Get all task lists
- `GET /api/task-lists/{id}` → Get task list by ID
- `PUT /api/task-lists/{id}` → Update task list
- `DELETE /api/task-lists/{id}` → Delete task list

### Task APIs
- `POST /api/tasks` → Create task
- `GET /api/tasks` → Get all tasks
- `GET /api/tasks/{id}` → Get task by ID
- `PUT /api/tasks/{id}` → Update task
- `DELETE /api/tasks/{id}` → Delete task
- `GET /api/tasks/status/{status}` → Filter by status
- `GET /api/tasks/task-list/{taskListId}` → Filter by task list

---

## 🗄️ Database
- PostgreSQL
- UUID used as primary keys

Tables:
- task_lists
- tasks

---

## ▶️ How to Run the Project

1. Clone the repository:
<<<<<<< HEAD
```bash
git clone https://github.com/Shubham2259/taskflow-backend.git

2. Open the project in IntelliJ IDEA
3. Configure database in application.properties:
    spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
4. Make sure PostgreSQL is running and database taskflow_db is created
5. Run the application:
    mvn spring-boot:run
6. Open Swagger UI in browser:
    http://localhost:8080/swagger-ui/index.html
📌 Future Improvements
Add pagination and sorting
Implement search functionality
Add authentication (Spring Security + JWT)
👨‍💻 Author

=======

```bash
git clone https://github.com/Shubham2259/taskflow-backend.git
```
2. Open the project in IntelliJ IDEA
3. Configure database in application.properties:
```
    spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
```
4. Make sure PostgreSQL is running and database taskflow_db is created
5. Run the application:
   ```
    mvn spring-boot:run
6. Open Swagger UI in browser:
    http://localhost:8080/swagger-ui/index.html


---
📌 Future Improvements
---
Add pagination and sorting
  
Implement search functionality

Add authentication (Spring Security + JWT)

---
👨‍💻 Author
---
Shubham Kumar
