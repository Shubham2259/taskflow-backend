package com.taskflow.service;

import com.taskflow.dto.TaskListRequestDto;
import com.taskflow.dto.TaskRequestDto;
import com.taskflow.entity.Task;
import com.taskflow.entity.TaskList;
import com.taskflow.entity.TaskStatus;
import com.taskflow.exception.ResourceNotFoundException;
import com.taskflow.repository.TaskListRepository;
import com.taskflow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public Task createTask(TaskRequestDto dto){
        TaskList taskList=taskListRepository.findById(dto.getTaskListId())
                .orElseThrow(()-> new ResourceNotFoundException("Task list not found with id: "+dto.getTaskListId()));

        Task parentTask=null;
        if(dto.getParentTaskId()!=null){
            parentTask=taskRepository.findById(dto.getParentTaskId())
                    .orElseThrow(()-> new ResourceNotFoundException("Parent task not found with id: "+dto.getParentTaskId()));
        }

        Task task=Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(dto.getPriority())
                .status(dto.getStatus()!=null?dto.getStatus(): TaskStatus.OPEN)
                .dueDate(dto.getDueDate())
                .taskList(taskList)
                .parentTask(parentTask)
                .build();
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task getTaskById(UUID id){
        return taskRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Task not found with id: "+id));
    }
    public Task updateTask(UUID id, TaskRequestDto dto) {
        Task task=getTaskById(id);
        TaskList taskList=taskListRepository.findById(dto.getTaskListId())
                .orElseThrow(()->new ResourceNotFoundException("Task list not found with id: "+dto.getTaskListId()));
        Task parentTask=null;
        if(parentTask!=null){
            parentTask=taskRepository.findById(dto.getParentTaskId())
                    .orElseThrow(()-> new ResourceNotFoundException("Parent task not found with id: "+dto.getParentTaskId()));
        }

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus()!=null?dto.getStatus():TaskStatus.OPEN);
        task.setDueDate(dto.getDueDate());
        task.setTaskList(taskList);
        task.setParentTask(parentTask);

        return taskRepository.save(task);
    }
    public void deleteTask(UUID id){
        Task task=getTaskById(id);
        taskRepository.delete(task);
    }
    public List<Task> getTasksByTaskList(UUID taskListId){
        return taskRepository.findByTaskListId(taskListId);
    }
    public List<Task> getTasksByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }
}
