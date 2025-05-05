package com.example.SmartVision.repository;

import com.example.SmartVision.model.Task;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TaskRepository")
public interface TaskRepository extends JpaRepository<Task, Long> {
  Task findById(UUID id);
}