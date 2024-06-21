package com.example.task_management_app.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    private String priority;

    private String status;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    private String category;

    // Constructors, getters, setters, toString (if needed)
    // Omitted for brevity
}
