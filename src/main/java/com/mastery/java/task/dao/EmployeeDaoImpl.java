package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        javax.persistence.Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }


    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        employee.setEmployeeId(newEmployee.getEmployeeId());
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Query query = entityManager.createQuery("delete from Employee " +
                "where employee_id =:employeeId");
        query.setParameter("employeeId", employeeId);
        query.executeUpdate();

    }
}
