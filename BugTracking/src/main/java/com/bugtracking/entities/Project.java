package com.bugtracking.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Project {
	@Id
	@Min(value = 1, message = "value must atleast be one")
	private long projId;
	@ApiModelProperty("Project Name should not be empty")
	@NotEmpty
	private String projname;
	@OneToMany
	private List<Employee> members;
	@NotEmpty
	@ApiModelProperty("Project status should not be empty")
	private String projstatus;

	public long getProjId() {
		return projId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}

	public List<Employee> getMembers() {
		return members;
	}

	public void setMembers(List<Employee> members) {
		this.members = members;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public String getProjstatus() {
		return projstatus;
	}

	public void setProjstatus(String projstatus) {
		this.projstatus = projstatus;
	}

	public Project() {

	}

	public Project(long projId, String projname, List<Employee> members, String projstatus) {
		super();
		this.projId = projId;
		this.projname = projname;
		this.members = members;
		this.projstatus = projstatus;
	}

}
