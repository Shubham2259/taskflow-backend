package com.taskflow.repository;

import com.taskflow.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
}
