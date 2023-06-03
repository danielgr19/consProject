package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.ProjectType;

@Repository
@RepositoryRestResource(collectionResourceRel = "ProjectsTypes", path = "ProjectsTypes")
public interface ProjectTypeCRUDRepository extends CrudRepository<ProjectType, Long>{

}
