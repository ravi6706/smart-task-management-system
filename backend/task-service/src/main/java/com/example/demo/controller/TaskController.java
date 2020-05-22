package com.example.demo.controller;

import com.example.demo.dao.TaskDao;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;
    
    @Autowired
    TaskDao taskDao;

    @GetMapping("tasksByStatus/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable boolean status)
    {
        return taskService.findAllByCompleted(status);
    }
    @GetMapping("tasksByAssignedTo/{assignedTo}")
    public ResponseEntity<List<Task>> getTaskByUser(@PathVariable String assignedTo)
    {
        return taskService.findAllByAssignedTo(assignedTo);
    }
    @PostMapping("/addTask")
    public void createTask(@RequestBody Task task)
    {
        taskService.addTask(task);
    }
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(value="id") Long id,@RequestBody Task task)
    {
        Task task1 = taskDao.findById(id).orElse(null);
        task1.setCompleted(true);
        
        final Task updatedTask = taskDao.save(task1);
        
		return ResponseEntity.ok(updatedTask);
    }

	/*
	 * @DeleteMapping("/deleteTask") public void deleteTask(@RequestBody Task task){
	 * taskService.deleteTask(task);
	 */
    
    @DeleteMapping("/deleteTask/{id}")
    public Map<String, Boolean> deletetask(@PathVariable(value = "id") Long id)
             {
           Task task = taskDao.findById(id).orElse(null);
           taskDao.delete(task);
           Map<String, Boolean> response = new HashMap<>();
           response.put("deleted", Boolean.TRUE);
           return response;
    
    }
	@GetMapping("/tasks")
    public List<Task> getAllTask() {
        return taskDao.findAll();
    }

}
