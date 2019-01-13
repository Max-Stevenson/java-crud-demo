package com.makers.cruddemo.dao;

import com.makers.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
