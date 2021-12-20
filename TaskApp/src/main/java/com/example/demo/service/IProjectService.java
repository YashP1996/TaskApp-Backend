package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ProjectReadException;
import com.example.demo.model.Project;

@Service
public interface IProjectService {

	public List<Project> getProjects() throws ProjectReadException;

	public Project getProjectById(long projectId) throws ProjectReadException;

	public boolean readProjectByProjectId(long projectId);
}