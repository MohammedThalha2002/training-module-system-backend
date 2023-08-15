package com.example.trainingmodulesystem.Service;

import com.example.trainingmodulesystem.Entity.Employee;

import java.util.List;

public interface EmployeeServiceImpl {

    public List<Employee> getEmployees();

    public Employee addEmployee(Employee employee);

    public Employee assignCourse(Long employeeId, Long courseId);

    public Employee updateProgress(Long id, Integer progress);
}
