package com.app.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.TeamMembers;

@Repository
@RepositoryRestResource(collectionResourceRel = "teamMemberss", path = "teamMemberss")
public interface TeamMembersCRUDRepository extends CrudRepository<TeamMembers, Long>{
	

}