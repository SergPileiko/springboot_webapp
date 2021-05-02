package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeDaoTest {
    private EmployeeDao dao;

    @Before
    public void setUp() throws Exception{
        this.dao = new EmployeeDaoImpl();

    }

    @Test
    public void getEmployeeById_Should_Return_True(){
        Employee emp = dao.getEmployeeById(1l);
        assertThat(emp).isNotNull();
        assertThat(emp.getFirstName()).isEqualTo("Alex");
    }

    @Test
    public void getEmployeeById_Null_Employee(){
        Employee emp = dao.getEmployeeById(10000000000l);
        assertThat(emp).isNull();
    }

}
