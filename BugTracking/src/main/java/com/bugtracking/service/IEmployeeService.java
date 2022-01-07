package com.bugtracking.service;

import java.util.List;

import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.entities.Employee;

public interface IEmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto updateEmployee(long empId, EmployeeDto employeeDto);
	public EmployeeDto deleteEmployee(long empId);
	public EmployeeDto getEmployee(long empId);
	public  List<EmployeeDto> getAllEmployees();

}
