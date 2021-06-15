package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public List<Employee> empList() {
		return repo.findAll();
	}
	@PostMapping("/emp")
	public Employee empPost(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	@DeleteMapping("/emp")
	public String empDelete(@RequestParam Long id) {	
		repo.deleteById(id);
		return "Record No. "+id+" has been Deleted";
	}
	@PutMapping("/emp")
	public Employee empPut(@RequestBody Employee employee) {
		return repo.save(employee);
	}
}

