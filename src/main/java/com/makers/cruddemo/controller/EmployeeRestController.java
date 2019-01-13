package com.makers.cruddemo.controller;

import com.makers.cruddemo.entity.Employee;
import com.makers.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public  Employee getEmployee(@PathVariable int employeeID) {

        Employee theEmployee = employeeService.findByID(employeeID);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees/")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }
}
