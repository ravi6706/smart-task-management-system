package com.example.demo.service;

import com.example.demo.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    public ResponseEntity<List<Task>> findAllByCompleted(boolean completed);
    public ResponseEntity<List<Task>> findAllByAssignedTo(String assignedTo);
    public void addTask(Task task);
    public void updateTask(Task task);
    public void deleteTask(Task task);
    public void deleteTaskById(Long id);
}
