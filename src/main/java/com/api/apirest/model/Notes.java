package com.api.apirest.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;
    private Date date;
    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}