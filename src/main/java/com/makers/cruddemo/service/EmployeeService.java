package com.makers.cruddemo.service;

import com.makers.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findByID(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);
}
