package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.Project;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectQUERYRepository extends PagingAndSortingRepository<Project, Long>{
	List<Project> findByid(@Param("id") Long id);
}
