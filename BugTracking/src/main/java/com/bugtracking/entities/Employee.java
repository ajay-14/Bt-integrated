package com.bugtracking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee {
	@Id
	@Min(value = 1, message = "minimum value must be 1")
	private long empId;
	@NotEmpty
	@ApiModelProperty("Employee name should not be empty")
	private String empName;
	@NotEmpty
	@ApiModelProperty("Employee email should not be empty")
	private String email;
	@NotEmpty
	@ApiModelProperty("Employee contactNo should not be empty")
	private String contactNo;
	@Min(value = 1, message = "minimum value must be 1")
	private long projectId;

	public Employee(long empId, String empName, String email, String contactNo, long projectId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.contactNo = contactNo;
		this.projectId = projectId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public Employee() {

	}
}
