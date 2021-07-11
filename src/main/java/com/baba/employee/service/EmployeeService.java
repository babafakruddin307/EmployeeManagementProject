package com.baba.employee.service;

import java.util.List;

import com.baba.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployess();
	
	void saveEmpolyee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployee(long id);
}
