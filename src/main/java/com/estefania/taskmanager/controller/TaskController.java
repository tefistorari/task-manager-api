package com.estefania.taskmanager.controller;

import com.estefania.taskmanager.model.Task;
import com.estefania.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * List all tasks
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    /**
     * Create a new task
     * @param task
     * @return
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.status(201).body(taskService.createTask(task));
    }

    /**
     * Mark a task as complete
     * @param id
     * @return
     */
    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask (@PathVariable Long id) {
        Task task = taskService.completeTask(id);
        return ResponseEntity.ok(task);
    }

    /**
     * Delete a task
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask (@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompletedTasks() {
        return ResponseEntity.ok(taskService.getCompletedTasks());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Task>> getPendingTasks() {
        return ResponseEntity.ok(taskService.getPendingTasks());
    }
}
