package com.example.trainingmodulesystem.Entity;

//Each training module should have a name, description, and list of topics covered

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training_module")
public class TrainingModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @ElementCollection
    private List<String> topics = new ArrayList<>();
    @OneToMany(mappedBy = "trainingModule")
    private List<Employee> employees = new ArrayList<>();

    public TrainingModule() {
    }

    public TrainingModule(Long id, String name, String description, List<String> topics) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topics = topics;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}