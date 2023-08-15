package com.example.trainingmodulesystem.Service;

import com.example.trainingmodulesystem.Entity.TrainingModule;
import com.example.trainingmodulesystem.Repository.TrainingModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingModuleService implements TrainingModuleServiceImpl{

    @Autowired
    private TrainingModuleRepository trainingModuleRepository;
    @Override
    public List<TrainingModule> getModules() {
        return trainingModuleRepository.findAll();
    }

    @Override
    public TrainingModule postModule(TrainingModule trainingModule) {
        return trainingModuleRepository.save(trainingModule);
    }

    @Override
    public Optional<TrainingModule> getModule(Long id) {
        return trainingModuleRepository.findById(id);
    }

    @Override
    public String deleteModule(Long id) {
        try {
            trainingModuleRepository.deleteById(id);
            return "Deleted Successfully";
        } catch (Exception e) {
            return "Failed to Delete";
        }
    }

    @Override
    public TrainingModule updateTrainingModule(Long id, TrainingModule trainingModule) {
        TrainingModule updateModule = trainingModuleRepository.findById(id).get();
        if(trainingModule.getName() != null)
            updateModule.setName(trainingModule.getName());
        if(trainingModule.getDescription() != null)
            updateModule.setDescription(trainingModule.getDescription());
        if(trainingModule.getTopics() != null)
            updateModule.setTopics(trainingModule.getTopics());
        return trainingModuleRepository.save(updateModule);
    }

    @Override
    public List<TrainingModule> serachModules(String query) {
        return trainingModuleRepository.search(query);
    }


}
