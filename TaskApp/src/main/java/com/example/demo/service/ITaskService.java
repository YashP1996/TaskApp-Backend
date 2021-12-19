package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Task;

@Service
public interface ITaskService {

	public Task createTask(Task task);

	public List<Task> readAllTasks();

	public Task readTaskById(long taskId);

	public Task updateTask(long taskId, Task task);

	public String deleteTask(long taskId);
}