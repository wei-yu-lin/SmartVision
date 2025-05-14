package com.example.SmartVision.service;

import com.example.SmartVision.model.Task;
import com.example.SmartVision.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository TaskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.TaskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> taskData = this.TaskRepository.findAll();
        taskData.forEach(task -> {
            task.setTitle("hello " + task.getTitle());
            task.setCompleted(task.isCompleted());
        });
        return this.TaskRepository.findAll();
    }

    public Task createTask(Task Task) {
        return this.TaskRepository.save(Task);
    }
}
