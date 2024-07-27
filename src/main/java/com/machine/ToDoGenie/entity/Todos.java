package com.machine.ToDoGenie.entity;


import jakarta.persistence.*;
@Entity
@Table(name="todos")
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="completed")
    private int completed;

    @Column(name="user_id")
    private Long userId; // Changed to Long to match with database type

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", userId=" + userId +
                '}';
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
