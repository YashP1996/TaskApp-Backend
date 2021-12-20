package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ProjectReadException;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class ProjectController {

	@Autowired
	public ProjectService projectService;

	@GetMapping("projects")
	public ResponseEntity<List<Project>> getAllProjects() throws ProjectReadException {
		return new ResponseEntity<List<Project>>(this.projectService.getProjects(), HttpStatus.OK);
	}

	@GetMapping("project/{projectId}")
	public ResponseEntity<Project> getProjectById(@PathVariable long projectId) throws ProjectReadException {
		return new ResponseEntity<Project>(this.projectService.getProjectById(projectId), HttpStatus.OK);
	}
}