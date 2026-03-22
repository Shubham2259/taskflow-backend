package com.taskflow.service;

import com.taskflow.dto.TaskListRequestDto;
import com.taskflow.entity.Task;
import com.taskflow.entity.TaskList;
import com.taskflow.exception.ResourceNotFoundException;
import com.taskflow.repository.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskListService {
    private final TaskListRepository taskListRepository;

    public TaskList createTaskList(TaskListRequestDto dto) {
        TaskList taskList = TaskList.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        return taskListRepository.save(taskList);
    }
    public List<TaskList> getAllTaskLists(){
        return taskListRepository.findAll();
    }
    public TaskList getTaskListById(UUID id){
        return taskListRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Task List not found with id "+id));
    }
    public TaskList updateTaskList(UUID id,TaskListRequestDto dto){
        TaskList taskList=getTaskListById(id);
        taskList.setName(dto.getName());
        taskList.setDescription(dto.getDescription());
        return taskListRepository.save(taskList);
    }
    public void deleteTaskList(UUID id){
        TaskList taskList=getTaskListById(id);
        taskListRepository.delete(taskList);
    }
}
