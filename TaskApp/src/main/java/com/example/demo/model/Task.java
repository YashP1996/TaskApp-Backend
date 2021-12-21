package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private LocalDateTime taskCreateDate;

	@Column(name = "UpdateDate")
	private LocalDateTime taskUpdateDate;

//	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ProjectId")
	private Project project;

	public Task() {
		super();
	}

	public Task(long taskId, String taskTitle, String taskDescription, String taskStatus, LocalDateTime taskCreateDate,
			LocalDateTime taskUpdateDate, Project project) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.taskCreateDate = taskCreateDate;
		this.taskUpdateDate = taskUpdateDate;
		this.project = project;
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

	public LocalDateTime getTaskCreateDate() {
		return taskCreateDate;
	}

	public void setTaskCreateDate(LocalDateTime taskCreateDate) {
		this.taskCreateDate = taskCreateDate;
	}

	public LocalDateTime getTaskUpdateDate() {
		return taskUpdateDate;
	}

	public void setTaskUpdateDate(LocalDateTime taskUpdateDate) {
		this.taskUpdateDate = taskUpdateDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription
				+ ", taskStatus=" + taskStatus + ", taskCreateDate=" + taskCreateDate + ", taskUpdateDate="
				+ taskUpdateDate + ", project=" + project + "]";
	}
}