package com.fis.FisFirstTestCase.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fis.FisFirstTestCase.entity.Employee;
import com.fis.FisFirstTestCase.exception.ResourceNotFoundException;
import com.fis.FisFirstTestCase.repository.EmployeeRepository;
import com.fis.FisFirstTestCase.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setId(id);
        return repository.save(employee);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> getTop5Salaries() {
        return repository.findTop5ByOrderBySalaryDesc();
    }

    @Override
    public Map<String, List<Employee>> groupByDepartment() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));
    }

}
