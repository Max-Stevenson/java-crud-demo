package com.makers.cruddemo.dao;

import com.makers.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();
        return employees;
    }
}