package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("task")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(this.taskService.createTask(task), HttpStatus.OK);
	}

	@GetMapping("tasks")
	public ResponseEntity<List<Task>> getAllTasks() {
		return new ResponseEntity<List<Task>>(this.taskService.readAllTasks(), HttpStatus.OK);
	}

	@GetMapping("task/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable long taskId) {
		return new ResponseEntity<Task>(this.taskService.readTaskById(taskId), HttpStatus.OK);
	}

	@PutMapping("task/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable long taskId, @RequestBody Task task) {
		return new ResponseEntity<Task>(this.taskService.updateTask(taskId, task), HttpStatus.OK);
	}

	@DeleteMapping("task/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable long taskId) {
		return new ResponseEntity<String>(this.taskService.deleteTask(taskId), HttpStatus.OK);
	}
}