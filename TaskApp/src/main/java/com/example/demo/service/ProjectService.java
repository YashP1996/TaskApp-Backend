package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProjectReadException;
import com.example.demo.model.Project;
import com.example.demo.repository.IProjectRepository;

@Service
public class ProjectService implements IProjectService {

	@Autowired
	private IProjectRepository iProjectRepository;

	@Override
	public List<Project> getProjects() throws ProjectReadException {
		List<Project> projectList = iProjectRepository.findAll();
		if (projectList.isEmpty()) {
			throw new ProjectReadException("Projects Not Found.");
		} else {
			return projectList;
		}
	}

	@Override
	public Project getProjectById(long projectId) throws ProjectReadException {
		if (this.readProjectByProjectId(projectId) == false) {
			throw new ProjectReadException("Project Not Found.");
		}
		return this.iProjectRepository.findById(projectId).get();
	}

	@Override
	public boolean readProjectByProjectId(long projectId) {
		List<Project> projectList = iProjectRepository.findAll();
		for (Project project : projectList) {
			if (project.getProjectId() == projectId) {
				return true;
			}
		}
		return false;
	}
}