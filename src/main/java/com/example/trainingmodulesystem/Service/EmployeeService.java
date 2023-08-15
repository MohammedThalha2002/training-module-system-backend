package com.example.trainingmodulesystem.Service;

import com.example.trainingmodulesystem.Entity.Employee;
import com.example.trainingmodulesystem.Entity.TrainingModule;
import com.example.trainingmodulesystem.Repository.EmployeeRepository;
import com.example.trainingmodulesystem.Repository.TrainingModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TrainingModuleRepository trainingModuleRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee assignCourse(Long employeeId, Long courseId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        TrainingModule trainingModule = trainingModuleRepository.findById(courseId).get();
        employee.setTrainingModule(trainingModule);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateProgress(Long id, Integer progress) {
        Employee employee = employeeRepository.findById(id).get();
        if(employee != null)
            employee.setProgress(progress);
        return employeeRepository.save(employee);
    }
}
