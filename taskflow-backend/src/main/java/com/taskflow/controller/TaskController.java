package com.taskflow.controller;

import com.taskflow.dto.TaskRequestDto;
import com.taskflow.entity.Task;
import com.taskflow.entity.TaskStatus;
import com.taskflow.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequestDto dto){
        return new ResponseEntity<>(taskService.createTask(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable UUID id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID id,@Valid @RequestBody TaskRequestDto dto){
        return ResponseEntity.ok(taskService.updateTask(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
    @GetMapping("/task-list/{taskListId}")
    public ResponseEntity<List<Task>> getTasksByTaskList(@PathVariable UUID taskListId){
        return ResponseEntity.ok(taskService.getTasksByTaskList(taskListId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable TaskStatus status){
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }
}
