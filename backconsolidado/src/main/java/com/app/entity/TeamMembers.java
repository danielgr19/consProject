package com.app.entity;

import java.util.Objects;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TeamMembers {
	@Id @GeneratedValue (strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native" , strategy = "native")
	private  Long id;
	private String name;
	private String lastName;
	private String rol;
	
	public TeamMembers() {}

	public TeamMembers(Long id, String name, String lastName, String rol) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.rol = rol;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		TeamMembers teamMembers = (TeamMembers) o;
			return Objects.equals(id, teamMembers.id) &&
			Objects.equals(name, teamMembers.name) &&
			Objects.equals(lastName, teamMembers.lastName) &&
			Objects.equals(rol, teamMembers.rol);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, lastName, name, rol);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "TeamMembers [id=" + id + ", name=" + name + ", lastName=" + lastName + ", rol=" + rol + "]";
	}
	
	
	
}
	
	
	
