package com.baba.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baba.employee.model.Employee;
import com.baba.employee.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployess() {
		
		return repository.findAll();
	}

	@Override
	public void saveEmpolyee(Employee employee) {
		this.repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=repository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("employee not found for id ::"+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployee(long id) {
		this.repository.deleteById(id);
	}

}
