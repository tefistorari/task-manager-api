package com.estefania.taskmanager.service;

import com.estefania.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task createTask(Task task) {
        task.setId(nextId++);
        task.setCompleted(false);
        task.setCreatedAt(LocalDate.now());

        tasks.add(task);
        return task;
    }

    public Task completeTask(Long id) {
        for (Task task : tasks) {
            if(task.getId().equals(id)) {
                task.setCompleted(true);
                return task;
            }
        }
        return null;
    }

    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(task -> Boolean.TRUE.equals(task.getCompleted()))
                .toList();
    }

    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !Boolean.TRUE.equals(task.getCompleted()))
                .toList();
    }
}
