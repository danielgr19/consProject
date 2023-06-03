package com.app.entity;


import java.util.Objects;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class State {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	
	private  Long id;
	private String stateName;
	private String descripcion;
	
	public State() {}


	public State(Long id, String stateName, String descripcion) {
		super();
		this.id = id;
		this.stateName = stateName;
		this.descripcion = descripcion;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(this == o) return true;
		if(o == this || getClass() != o.getClass()) return false;
		
		State state = (State) o;
		
		return Objects.equals(id, state.id) &&
				Objects.equals(stateName, state.stateName) &&
				Objects.equals(descripcion, state.descripcion);
		
		
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(id, stateName, descripcion);
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getdescripcion() {
		return descripcion;
	}


	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "State [id=" + id + ", stateName=" + stateName + ", descripcion=" + descripcion + "]";
	}


	
	
	
}
