package com.example.SmartVision.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private UUID id;
    

    private String title;

    private boolean completed;

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}