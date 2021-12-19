package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.TaskCreateException;
import com.example.demo.exception.TaskDeleteException;
import com.example.demo.exception.TaskReadException;
import com.example.demo.exception.TaskUpdateException;
import com.example.demo.model.Task;
import com.example.demo.repository.ITaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private ITaskRepository iTaskRepository;

	@Override
	public Task createTask(Task task) throws TaskCreateException {
		if (task == null) {
			throw new TaskCreateException("Cannot Create Task. Please Try Again.");
		} else {
			return this.iTaskRepository.save(task);
		}
	}

	@Override
	public List<Task> readAllTasks() throws TaskReadException {
		List<Task> taskList = this.iTaskRepository.findAll();
		if (taskList.isEmpty()) {
			throw new TaskReadException("Tasks Not Found.");
		} else {
			return taskList;
		}
	}

	@Override
	public Task readTaskById(long taskId) throws TaskReadException {
		Task task = this.iTaskRepository.findById(taskId).get();
		if (task == null) {
			throw new TaskReadException("Task Not Found.");
		} else {
			return task;
		}
	}

	@Override
	public Task updateTask(long taskId, Task task) throws TaskUpdateException {
		Task taskDb = this.iTaskRepository.findById(taskId).get();
		if (taskDb == null) {
			throw new TaskUpdateException("Cannot Update Task. Please Try Again.");
		} else {
			taskDb.setTaskTitle(task.getTaskTitle());
			taskDb.setTaskDescription(task.getTaskDescription());
			taskDb.setTaskStatus(task.getTaskStatus());
			taskDb.setTaskUpdateDate(task.getTaskUpdateDate());
			this.iTaskRepository.save(taskDb);
			return taskDb;
		}
	}

	@Override
	public Task deleteTask(long taskId) throws TaskDeleteException {
		Task task = iTaskRepository.findById(taskId).get();
		if (task == null) {
			throw new TaskDeleteException("Cannot Delete Task. Please Try Again.");
		} else {
			this.iTaskRepository.deleteById(taskId);
			return task;
		}
	}
}