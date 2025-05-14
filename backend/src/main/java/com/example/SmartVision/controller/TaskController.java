package com.example.SmartVision.controller;

import com.example.SmartVision.model.Task;
import com.example.SmartVision.repository.TaskRepository;
import com.example.SmartVision.service.TaskService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @GetMapping()
    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        return this.taskService.getAllTasks();
    }

    @GetMapping("one")
    public Optional<Task> getById(@RequestParam UUID id) {
        log.info("getById with id: {}", id);
        return this.taskRepository.findById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        log.info(task.toString());
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody Task task) {
        Task existing = taskRepository.findById(id).orElseThrow();
        existing.setTitle(task.getTitle());
        existing.setCompleted(task.isCompleted());
        return taskRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskRepository.deleteById(id);
    }
}
