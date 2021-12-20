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

import com.example.demo.exception.TaskCreateException;
import com.example.demo.exception.TaskDeleteException;
import com.example.demo.exception.TaskReadException;
import com.example.demo.exception.TaskUpdateException;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("task")
	public ResponseEntity<Task> addTask(@RequestBody Task task) throws TaskCreateException {
		if (task.getTaskTitle() == null || task.getTaskDescription() == null || task.getTaskStatus() == null
				|| task.getTaskCreateDate() == null || task.getTaskUpdateDate() == null) {
			throw new TaskCreateException("Cannot Create Task. Please Try Again.");
		} else {
			return new ResponseEntity<Task>(this.taskService.createTask(task), HttpStatus.OK);
		}
	}

	@GetMapping("tasks")
	public ResponseEntity<List<Task>> getAllTasks() throws TaskReadException {
		List<Task> taskList = this.taskService.readAllTasks();
		if (taskList.isEmpty()) {
			throw new TaskReadException("Tasks Not Found.");
		} else {
			return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
		}
	}

	@GetMapping("task/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable long taskId) throws TaskReadException {
		if (taskId == 0) {
			throw new TaskReadException("Task Not Found.");
		} else {
			return new ResponseEntity<Task>(this.taskService.readTaskById(taskId), HttpStatus.OK);
		}
	}

	@PutMapping("task/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable long taskId, @RequestBody Task task)
			throws TaskUpdateException {
		if (taskId == 0 || task.getTaskTitle() == null || task.getTaskDescription() == null
				|| task.getTaskStatus() == null || task.getTaskUpdateDate() == null) {
			throw new TaskUpdateException("Cannot Update Task. Please Try Again.");
		} else {
			return new ResponseEntity<Task>(this.taskService.updateTask(taskId, task), HttpStatus.OK);
		}
	}

	@DeleteMapping("task/{taskId}")
	public ResponseEntity<Task> deleteTask(@PathVariable long taskId) throws TaskDeleteException {
		if (taskId == 0) {
			throw new TaskDeleteException("Cannot Delete Task.");
		} else {
			return new ResponseEntity<Task>(this.taskService.deleteTask(taskId), HttpStatus.OK);
		}
	}
}