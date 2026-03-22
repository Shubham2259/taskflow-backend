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
- Tables:
    - task_lists
    - tasks

---

## ▶️ How to Run the Project

1. Clone the repository:
```bash
git clone your-repo-link

---

## 🧠 Why this README is strong

It includes:

| Section | Why needed |
|--------|----------|
| Overview | Explains project purpose |
| Features | Shows your skills |
| Tech stack | Shows technologies used |
| APIs | Shows backend capability |
| Database | Shows DB knowledge |
| Run steps | Shows usability |

---

# ✅ Step 32: Push to GitHub

Now we upload project to GitHub.

---

# 🔷 Step-by-step Git commands (with explanation)

Open terminal in IntelliJ or CMD.

---

## 🟢 Step 1: Initialize Git

```bash
git init