package com.fis.FisFirstTestCase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.FisFirstTestCase.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findTop5ByOrderBySalaryDesc();

}
