package com.fis.FisFirstTestCase.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.FisFirstTestCase.entity.Employee;
import com.fis.FisFirstTestCase.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeService service;

	
	@PostMapping("/saveEmployee")
    public Employee create(@Valid @RequestBody Employee employee) {
        return service.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/top5-salaries")
    public List<Employee> getTop5() {
        return service.getTop5Salaries();
    }

    @GetMapping("/group-by-department")
    public Map<String, List<Employee>> groupByDept() {
        return service.groupByDepartment();
    }

}
