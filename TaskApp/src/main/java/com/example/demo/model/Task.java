package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taskId;

	@Column(name = "Title")
	private String taskTitle;

	@Column(name = "Description")
	private String taskDescription;

	@Column(name = "Status")
	private String taskStatus;

	@Column(name = "CreateDate")
	private Date taskCreateDate;

	@Column(name = "UpdateDate")
	private Date taskUpdateDate;

	public Task() {
		super();
	}

	public Task(long taskId, String taskTitle, String taskDescription, String taskStatus, Date taskCreateDate,
			Date taskUpdateDate) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.taskCreateDate = taskCreateDate;
		this.taskUpdateDate = taskUpdateDate;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getTaskCreateDate() {
		return taskCreateDate;
	}

	public void setTaskCreateDate(Date taskCreateDate) {
		this.taskCreateDate = taskCreateDate;
	}

	public Date getTaskUpdateDate() {
		return taskUpdateDate;
	}

	public void setTaskUpdateDate(Date taskUpdateDate) {
		this.taskUpdateDate = taskUpdateDate;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription
				+ ", taskStatus=" + taskStatus + ", taskCreateDate=" + taskCreateDate + ", taskUpdateDate="
				+ taskUpdateDate + "]";
	}
}