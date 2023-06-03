package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Project;

@Repository
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectCRUDRepository extends CrudRepository<Project, Long>{
	

}