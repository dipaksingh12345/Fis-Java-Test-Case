package com.fis.FisFirstTestCase.service;

import java.util.List;
import java.util.Map;

import com.fis.FisFirstTestCase.entity.Employee;

public interface EmployeeService {
	Employee create(Employee employee);
    Employee update(Long id, Employee employee);
    void delete(Long id);
    Employee getById(Long id);
    List<Employee> getAll();
    List<Employee> getTop5Salaries();
    Map<String, List<Employee>> groupByDepartment();

}
