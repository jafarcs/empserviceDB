package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public  Employee getEmployeeById(@PathVariable Long employeeId){
            return employeeRepository.findById(employeeId).get();
    }

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee){
            employeeRepository.save(employee);
    }
}
