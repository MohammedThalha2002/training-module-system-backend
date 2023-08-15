package com.example.trainingmodulesystem.Controller;

import com.example.trainingmodulesystem.Entity.TrainingModule;
import com.example.trainingmodulesystem.Service.TrainingModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("module")
public class TrainingModuleController {

    @Autowired
    private TrainingModuleService trainingModuleService;

    @GetMapping("/get-modules")
    public List<TrainingModule> getModules(){
            return trainingModuleService.getModules();
    }

    @PostMapping("/post-module")
    public TrainingModule postModules(@RequestBody TrainingModule trainingModule){
        return trainingModuleService.postModule(trainingModule);
    }

    @GetMapping("/get-module/{id}")
    public Optional<TrainingModule> getModule(@PathVariable("id") Long Id){
        return trainingModuleService.getModule(Id);
    }

    @DeleteMapping("/delete-module/{id}")
    public String deleteModule(@PathVariable("id") Long Id){
          return trainingModuleService.deleteModule(Id);
    }

    @PutMapping("/update-module/{id}")
    public TrainingModule updateModule(@PathVariable("id") Long id, @RequestBody TrainingModule trainingModule){
        return trainingModuleService.updateTrainingModule(id, trainingModule);
    }

    @GetMapping("/search")
    public List<TrainingModule> searchModules(@RequestParam("query") String query){
            return trainingModuleService.serachModules(query);
    }
}
