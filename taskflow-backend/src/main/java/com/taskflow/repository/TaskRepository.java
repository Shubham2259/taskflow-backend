package com.taskflow.repository;

import com.taskflow.entity.Priority;
import com.taskflow.entity.Task;
import com.taskflow.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID TaskListId);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByPriority(Priority priority);
}
