package com.taskflow.dto;

import com.taskflow.entity.Priority;
import com.taskflow.entity.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskRequestDto {

    @NotBlank(message = "Task title is required")
    private String title;

    private String description;

    @NotNull(message = "Priority is required")
    private Priority priority;

    private TaskStatus status;

    @FutureOrPresent(message = "Due date must be in present or future")
    private LocalDateTime dueDate;

    @NotNull(message = "Task List Id is required")
    private UUID taskListId;

    private UUID parentTaskId;
}
