package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.TeamMembers;

@RepositoryRestResource(collectionResourceRel = "teamMemberss", path = "teamMemberss")
public interface TeamMembersQUERYRepository extends PagingAndSortingRepository<TeamMembers, Long>{
	List<TeamMembers> findByid(@Param("id") Long id);
}
