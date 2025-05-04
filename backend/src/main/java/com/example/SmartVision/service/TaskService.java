package com.example.SmartVision.service;

import com.example.SmartVision.model.Task;
import com.example.SmartVision.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository TaskRepository;

    public TaskService(TaskRepository TaskRepository) {
        this.TaskRepository = TaskRepository;
    }

    public List<Task> getAllTasks() {
        return TaskRepository.findAll();
    }

    public Task createTask(Task Task) {
        return TaskRepository.save(Task);
    }
}
