package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.State;

@Repository
@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StateCRUDRepository extends CrudRepository<State, Long>{



}
