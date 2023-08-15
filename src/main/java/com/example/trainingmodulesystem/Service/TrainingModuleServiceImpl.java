package com.example.trainingmodulesystem.Service;

import com.example.trainingmodulesystem.Entity.TrainingModule;

import java.util.List;
import java.util.Optional;

public interface TrainingModuleServiceImpl {
    public List<TrainingModule> getModules();

    public TrainingModule postModule(TrainingModule trainingModule);

    public Optional<TrainingModule> getModule(Long idd);

    public String deleteModule(Long id);

    public TrainingModule updateTrainingModule(Long Id, TrainingModule trainingModule);

    public List<TrainingModule> serachModules(String search);
}
