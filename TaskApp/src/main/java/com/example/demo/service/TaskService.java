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
		if (task.getTaskTitle() == null || task.getTaskDescription() == null || task.getTaskStatus() == null
				|| task.getTaskCreateDate() == null || task.getTaskUpdateDate() == null) {
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
		if (this.readTaskByTaskId(taskId) == false) {
			throw new TaskReadException("Task Not Found.");
		} else {
			return this.iTaskRepository.findById(taskId).get();
		}
	}

	@Override
	public Task updateTask(long taskId, Task task) throws TaskUpdateException {
		if (this.readTaskByTaskId(taskId) == false || task.getTaskTitle() == null || task.getTaskDescription() == null
				|| task.getTaskStatus() == null || task.getTaskUpdateDate() == null) {
			throw new TaskUpdateException("Cannot Update Task. Please Try Again.");
		} else {
			Task taskDb = this.iTaskRepository.findById(taskId).get();
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
		if (this.readTaskByTaskId(taskId) == false) {
			throw new TaskDeleteException("Cannot Delete Task. Please Try Again.");
		} else {
			Task task = iTaskRepository.findById(taskId).get();
			this.iTaskRepository.deleteById(taskId);
			return task;
		}
	}

	@Override
	public boolean readTaskByTaskId(long taskId) {
		List<Task> taskList = iTaskRepository.findAll();
		for (Task task : taskList) {
			if (task.getTaskId() == taskId) {
				return true;
			}
		}
		return false;
	}
}