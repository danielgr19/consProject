package com.app.entity;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.http.HttpHeaders;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Project {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private  Long id;
	private String projectName;
	private String codeID;
	private String descripcion;

	public Project() {}



	public Project(Long id, String projectName, String codeID, String descripcion) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.codeID = codeID;
		this.descripcion = descripcion;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Project project = (Project) o;
		return Objects.equals(id, project.id) &&
			Objects.equals(projectName, project.projectName) &&
			Objects.equals(codeID, project.codeID) &&
			Objects.equals(descripcion, project.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projectName, codeID, descripcion);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getprojectName() {
		return projectName;
	}

	public void setprojectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLastName() {
		return codeID;
	}

	public void setLastName(String codeID) {
		this.codeID = codeID;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Project{" +
			"id=" + id +
			", projectName='" + projectName + '\'' +
			", codeID='" + codeID + '\'' +
			", descripcion='" + descripcion + '\'' +
			'}';
	}




}