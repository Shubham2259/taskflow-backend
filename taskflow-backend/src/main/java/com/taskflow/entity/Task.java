package com.taskflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false,length = 150)
    private String title;
    @Column(columnDefinition = "Text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    private LocalDateTime dueDate;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="task_list_id",nullable = false)
    private TaskList taskList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_task_id")
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask",cascade = CascadeType.ALL)
    private List<Task> subtasks=new ArrayList<>();

    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
        if(this.status==null){
            this.status=TaskStatus.OPEN;
        }
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt=LocalDateTime.now();
    }
}
