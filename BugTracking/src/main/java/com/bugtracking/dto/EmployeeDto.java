package com.bugtracking.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bugtracking.entities.Bug;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Employee Entity")
public class EmployeeDto{
	private long empId;
	@NotEmpty
	@ApiModelProperty("name should not empty")
	private String empName;
	@NotEmpty
	private String email;
	@NotEmpty
	private String contactNo;
	@Min(value=1)
	private long projectId;
	
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
	
	
	public EmployeeDto(long empId, String empName, String email, String contactNo, long projectId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.contactNo = contactNo;
		this.projectId = projectId;
	}
	
	public EmployeeDto() {
		
	}
}