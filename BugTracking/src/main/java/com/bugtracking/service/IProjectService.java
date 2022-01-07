package com.bugtracking.service;

import java.util.List;

import com.bugtracking.dto.ProjectDto;
import com.bugtracking.entities.Project;

public interface IProjectService {

	List<Project> getall();

	Project getproject(long projId);

	Project deleteproject(long projId);

	Project createproject(Project project);

	Project updateproject(long projId, Project p);

}
