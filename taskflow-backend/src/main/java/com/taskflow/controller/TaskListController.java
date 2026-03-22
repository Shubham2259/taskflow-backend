package com.taskflow.controller;

import com.taskflow.dto.TaskListRequestDto;
import com.taskflow.dto.TaskRequestDto;
import com.taskflow.entity.TaskList;
import com.taskflow.service.TaskListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks-lists")
@RequiredArgsConstructor
public class TaskListController {
    private final TaskListService taskListService;

    @PostMapping
    public ResponseEntity<TaskList> createTaskList(@Valid @RequestBody TaskListRequestDto dto){
        return new ResponseEntity<>(taskListService.createTaskList(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TaskList>> getAllTaskLists(){
        return ResponseEntity.ok(taskListService.getAllTaskLists());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskList> getTaskListById(@PathVariable UUID id){
        return ResponseEntity.ok(taskListService.getTaskListById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskList> updateTaskList(@PathVariable UUID id, @Valid @RequestBody TaskListRequestDto dto){
        return ResponseEntity.ok(taskListService.updateTaskList(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskList(@PathVariable UUID id){
        taskListService.deleteTaskList(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
