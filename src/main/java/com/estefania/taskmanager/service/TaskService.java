package com.estefania.taskmanager.service;

import com.estefania.taskmanager.Repository.TaskRepository;
import com.estefania.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask (Task task) {
        task.setCompleted(false);
        task.setCreatedAt(LocalDate.now());
        return taskRepository.save(task);
    }

    public Task completeTask (Long id) {
        return taskRepository.findById(id).map(task -> {
            task.setCompleted(true);
            return taskRepository.save(task);
        }).orElse(null);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    public List<Task> getPendingTasks() {
        return taskRepository.findByCompleted(false);
    }
}
