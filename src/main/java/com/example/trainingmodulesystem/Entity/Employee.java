package com.example.trainingmodulesystem.Entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private TrainingModule trainingModule;
    private Integer Progress;

    public Employee() {
    }

    public Employee(Long id, String name, TrainingModule trainingModule, Integer progress) {
        this.id = id;
        this.name = name;
        this.trainingModule = trainingModule;
        Progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingModule getTrainingModule() {
        return trainingModule;
    }

    public void setTrainingModule(TrainingModule trainingModule) {
        this.trainingModule = trainingModule;
    }

    public Integer getProgress() {
        return Progress;
    }

    public void setProgress(Integer progress) {
        Progress = progress;
    }
}
