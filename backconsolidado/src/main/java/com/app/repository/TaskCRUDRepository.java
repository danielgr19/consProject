package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Task;

@Repository
@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TaskCRUDRepository extends CrudRepository<Task, Long>{
	
}
