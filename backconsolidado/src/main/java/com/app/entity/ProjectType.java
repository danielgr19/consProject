package com.app.entity;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectType {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private  Long id;
	private String typeOfProyect;
	private String description;


	public ProjectType(Long id, String typeOfProyect, String description){
		super();
		this.id = id;
		this.typeOfProyect = typeOfProyect;
		this.description = description;
	}

	public ProjectType() {
//		 TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectType projectType = (ProjectType) o;
		return Objects.equals(id, projectType.id) &&
			Objects.equals(typeOfProyect, projectType.typeOfProyect) &&
			Objects.equals(description, projectType.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, typeOfProyect, description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeOfProyect() {
		return typeOfProyect;
	}

	public void setTypeOfProyect(String typeOfProyect) {
		this.typeOfProyect = typeOfProyect;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProjectType{" +
			"id=" + id +
			", typeOfProyect='" + typeOfProyect + '\'' +
			", description='" + description + '\'' +
			'}';
	}



}
