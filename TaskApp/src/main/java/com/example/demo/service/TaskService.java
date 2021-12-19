package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.ITaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private ITaskRepository iTaskRepository;

	@Override
	public Task createTask(Task task) {
		if (task != null) {
			return this.iTaskRepository.save(task);
		} else {
			return null;
		}
	}

	@Override
	public List<Task> readAllTasks() {
		List<Task> taskList = this.iTaskRepository.findAll();
		if (!taskList.isEmpty()) {
			return taskList;
		} else {
			return null;
		}
	}

	@Override
	public Task readTaskById(long taskId) {
		Task task = this.iTaskRepository.findById(taskId).get();
		if (task != null) {
			return task;
		} else {
			return null;
		}
	}

	@Override
	public Task updateTask(long taskId, Task task) {
		Task taskDb = this.iTaskRepository.findById(taskId).get();
		if (taskDb != null) {
			taskDb.setTaskTitle(task.getTaskTitle());
			taskDb.setTaskDescription(task.getTaskDescription());
			taskDb.setTaskStatus(task.getTaskStatus());
			this.iTaskRepository.save(taskDb);
			return taskDb;
		} else {
			return null;
		}
	}

	@Override
	public String deleteTask(long taskId) {
		if (taskId != 0) {
			this.iTaskRepository.deleteById(taskId);
			return "Task Deleted.";
		} else {
			return "Task Not Deleted.";
		}
	}
}