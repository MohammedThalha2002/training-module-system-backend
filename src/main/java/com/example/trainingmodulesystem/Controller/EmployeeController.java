package com.example.trainingmodulesystem.Controller;

import com.example.trainingmodulesystem.Entity.Employee;
import com.example.trainingmodulesystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/assign-course")
    public Employee assignCourse(@RequestParam("empId") Long employeeId, @RequestParam("courseId") Long courseId){
        return employeeService.assignCourse(employeeId, courseId);
    }

    @PostMapping("/update-progress/{id}")
    public Employee updateProgress(@PathVariable("id") Long id, @RequestParam("progress") Integer progress){
        return employeeService.updateProgress(id, progress);
    }
}
