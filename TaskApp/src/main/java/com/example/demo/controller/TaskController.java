package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Task addTask(@RequestBody Task task) {
		return this.taskService.createTask(task);
	}

	@GetMapping("tasks")
	public List<Task> getAllTasks() {
		return this.taskService.readAllTasks();
	}

	@GetMapping("task/{taskId}")
	public Task getTaskById(@PathVariable long taskId) {
		return this.taskService.readTaskById(taskId);
	}

	@PutMapping("task/{taskId}")
	public Task updateTask(@PathVariable long taskId, @RequestBody Task task) {
		return this.taskService.updateTask(taskId, task);
	}

	@DeleteMapping("task/{taskId}")
	public String deleteTask(@PathVariable long taskId) {
		return this.taskService.deleteTask(taskId);
	}
}