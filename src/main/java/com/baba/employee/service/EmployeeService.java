package com.baba.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.baba.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployess();
	
	void saveEmpolyee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployee(long id);
	Page<Employee> findPaginated(int pageNo,int pageSize, String sortField, String sortDir);
}
