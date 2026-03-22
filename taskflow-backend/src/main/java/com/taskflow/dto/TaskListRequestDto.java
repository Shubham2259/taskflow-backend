package com.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskListRequestDto {

    @NotBlank(message = "Task List name is required")
    private String name;

    private String description;
}
