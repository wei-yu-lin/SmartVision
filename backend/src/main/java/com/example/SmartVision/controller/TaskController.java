package com.example.SmartVision.controller;

import com.example.SmartVision.model.Task;
import com.example.SmartVision.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable UUID id) {
        log.info("getById with id: {}", id);
        return taskRepository.findById(id);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        log.info("5555555");
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        log.info(task.toString());
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task existing = taskRepository.findById(id).orElseThrow();
        existing.setTitle(task.getTitle());
        existing.setCompleted(task.isCompleted());
        return taskRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
