package com.app.entity;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Task {

	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long taskId;
	private String taskName;
	private String taskDescription;
	private String startDate;
	private String finishDate; 
	
	public Task() {
		//Null
	}
	
	public Task(long taskId, String taskName, String taskDescription, String startDate, String finishDate) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Task task = (Task) o;
		return Objects.equals(taskName, task.taskName) &&
				Objects.equals(taskDescription, task.taskDescription) &&
				Objects.equals(startDate, task.startDate) &&
				Objects.equals(finishDate, task.finishDate);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(taskName, taskDescription, startDate, finishDate);
	}
	
	//Getter and Setter of taskId
	public long getTaskId() {
		return taskId;
	}
	
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
	//Getter and Setter of Task Name
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	//Getter and Setter of Task Description
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	//Getter and Setter of starting date
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	//Getter and Setter of finishing date
	public String getFinishDate() {
		return finishDate;
	}
	
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", taskDescription=" + taskDescription 
				+ ", startDate=" + startDate
				+ ", finishDate=" + finishDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
