package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.TaskCreateException;
import com.example.demo.exception.TaskDeleteException;
import com.example.demo.exception.TaskReadException;
import com.example.demo.exception.TaskUpdateException;
import com.example.demo.model.Task;

@Service
public interface ITaskService {

	public Task createTask(Task task) throws TaskCreateException;

	public List<Task> readAllTasks() throws TaskReadException;

	public Task readTaskById(long taskId) throws TaskReadException;

	public Task updateTask(long taskId, Task task) throws TaskUpdateException;

	public Task deleteTask(long taskId) throws TaskDeleteException;
}