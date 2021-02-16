package com.example.basicCRUD.controllers;

import com.example.basicCRUD.controllers.data.Employee;
import com.example.basicCRUD.controllers.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RootController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/")
	public String boom(Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addEmployee(Model model){
		return "add";
	}

	@PostMapping("/edit")
	public String editEmployee(Model model,@RequestParam("id") String id, String name, String age, String gender){
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		return "edit";
	}

	@GetMapping("/delete")
	public String deleteEmployee(Model model, @RequestParam("id") String id){
		Long employeeId = Long.parseLong(id);
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if(employeeOptional.isPresent()){
			Employee employee = employeeOptional.get();
			employeeRepository.delete(employee);
		}
		return "redirect:/";
	}

	@PostMapping("/save")
	public String save_update(Model model,
	                             @RequestParam(required = false, defaultValue = "null", name = "id") String id,
	                             @RequestParam("name") String name,
	                             @RequestParam("age") String age,
	                             @RequestParam("gender") String gender){
		if(id.equals("null")){
			employeeRepository.save(new Employee(name, age, gender));
		}else{
			Long employeeId = Long.parseLong(id);
			Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
			if(employeeOptional.isPresent()){
				Employee employee = employeeOptional.get();
				employee.setEmployeeName(name);
				employee.setEmployeeAge(age);
				employee.setEmployeeGender(gender);
				employeeRepository.save(employee);
			}
		}
		return "redirect:/";
	}
}
