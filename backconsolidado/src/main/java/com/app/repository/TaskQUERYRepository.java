package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.Task;

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TaskQUERYRepository extends PagingAndSortingRepository<Task, Long>{
	List<Task> findBytaskId(@Param("taskId") Long taskId);
}