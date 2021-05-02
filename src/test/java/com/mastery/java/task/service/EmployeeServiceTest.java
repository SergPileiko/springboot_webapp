package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class EmployeeServiceTest {

    @Mock
    private EmployeeDao dao;

    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.initMocks(this);
        this.dao = dao;
        this.employeeService = new EmployeeServiceImpl(dao);
    }

    @Test
    public void getEmployeeById_Should_Return_True() {

        given(dao.getEmployeeById(1l)).willReturn(
                new Employee("Test", "Test", 1, "middle", Gender.MALE, Date.valueOf("1990-01-01")));

        boolean result = employeeService.getEmployeeById(1l).getFirstName().equals("Test");

        assertThat(result).isTrue();
    }

    @Test
    public void getEmployeeById_Should_Return_False() {

        given(dao.getEmployeeById(1l)).willReturn(null);

        boolean result = (employeeService.getEmployeeById(1l) != null);

        assertThat(result).isFalse();

        verify(dao).getEmployeeById(1l);
    }

    @Test(expected = Exception.class)
    public void getEmployeeById_Should_Throw_Exception() {

        given(dao.getEmployeeById(anyLong())).willThrow(Exception.class);

        employeeService.getEmployeeById(1l);

    }

}
