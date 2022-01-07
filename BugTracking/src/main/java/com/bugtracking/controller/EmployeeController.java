package com.bugtracking.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.entities.Bug;
import com.bugtracking.entities.Employee;
import com.bugtracking.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class EmployeeController {
	@Autowired
	IEmployeeService es;
	
	@ApiOperation("Used to fetch all employees")
	@GetMapping("/employees")
	public List<EmployeeDto> allemployees(){
		return es.getAllEmployees();		
	}
	@ApiOperation("Used to fetch employee with particular id")
	@GetMapping("/employees/{empId}")
	public EmployeeDto getemployee(@PathVariable long empId) {
		return es.getEmployee(empId);
	}
	@ApiOperation("Used to delete employee with particular id")
	@DeleteMapping("/employees/{empId}")
	public EmployeeDto deleteemployee(@PathVariable long empId) {
		return es.deleteEmployee(empId);
	}
	@ApiOperation("Used to create employee")
	@PostMapping("/employees")
	public EmployeeDto createemployee(@Valid @RequestBody EmployeeDto employeeDto){
		return es.createEmployee(employeeDto);	
	}
	@ApiOperation("Used to update employees")
	@PutMapping("/employees/{empId}")
	public EmployeeDto updateemployee(@PathVariable("empId")long empId,@Valid @RequestBody EmployeeDto e){
		return es.updateEmployee(empId,e);		
	}
	@GetMapping("/employees/bystatus/{status}")
	public List<Bug> bugsbystatus(@PathVariable("status") String status){
		String endpoint="http://localhost:8094/bugs/bystatus/"+status;
		RestTemplate rt=new RestTemplate();
		List<Bug> m=Arrays.asList(rt.getForObject(endpoint,Bug[].class));
		return m;	
	}
	
}
