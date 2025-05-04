package com.example.SmartVision.repository;

import com.example.SmartVision.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}