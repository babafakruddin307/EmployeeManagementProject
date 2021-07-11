package com.baba.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.baba.employee.model.Employee;
import com.baba.employee.service.EmployeeService;
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployess());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmloyee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmpolyee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdates/{id}")
	public String showFormForUpdates(@PathVariable("id")long id,Model model) {
		//get employee from the service
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id")long id) {
		this.employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
