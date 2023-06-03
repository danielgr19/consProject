package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.State;

@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StateQUERYRepository extends PagingAndSortingRepository<State, Long>{
	List<State> findByStateName(@Param("stateName") String stateName);
}
