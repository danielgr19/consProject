package com.app.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.ProjectType;

@RepositoryRestResource(collectionResourceRel = "ProjectsTypes", path = "ProjectsTypes")
public interface ProjectTypeQUERYRepository extends PagingAndSortingRepository<ProjectType, Long>{
	List<ProjectType> findBytypeOfProyect(@Param("typeOfProyect") String typeOfProyect);

}
