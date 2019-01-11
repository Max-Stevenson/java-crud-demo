package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
