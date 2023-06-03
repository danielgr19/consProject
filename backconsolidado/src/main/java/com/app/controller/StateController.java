package com.app.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.entity.State;
import com.app.entity.States;
import com.app.repository.StateCRUDRepository;
import com.app.repository.StateQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // https://www.baeldung.com/spring-cors
@RequestMapping("/api/stateCustomAPI")
public class StateController {

	@Autowired
	private StateCRUDRepository stateRepository;
	@Autowired
	private StateQUERYRepository stateRepositoryQuery;

	// ***Api Final Front

	@CrossOrigin(origins = "*")

	@PostMapping(path = "/addstate", consumes = "application/json", produces = "application/json")
	public State addNewStateApi(@RequestBody State state) {
		// add resource
		state = stateRepository.save(state);
		return state;
	}

	// ***API Final Para FRONT
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/stategetall", produces = "application/json")
	public States getAllstatesApi() {
		States response = new States();
		ArrayList<State> list = new ArrayList<>();
		stateRepository.findAll().forEach(e -> list.add(e));
		response.setStateList(list);
		return response;
	}

	// ***Api Final Front

	@CrossOrigin(origins = "*")

	@PostMapping(path = "/updatestate", consumes = "application/json", produces = "application/json")
	public State updateState(@RequestBody State state) {
		// add resource
		stateRepository.save(state);
		return state;
	}

	// ***Api Final Front

	@CrossOrigin(origins = "*")

	@PostMapping(path = "/stateremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteStateApi(@RequestBody State state) {
		stateRepository.deleteById(state.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	// Otras Formas pero Bajo jUnit Testing

	@GetMapping(path = "	", produces = "application/json")
	public States getStates() {
		States response = new States();
		ArrayList<State> list = new ArrayList<>();
		stateRepository.findAll().forEach(e -> list.add(e));
		response.setStateList(list);
		return response;
	}
	
	

	
	
	@PostMapping(path = "/states", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addState(@RequestBody State state) {
		// add resource
		state = stateRepository.save(state);

		// Create resource location

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(state.getId())
				.toUri();

		// Send location in response 
		return ResponseEntity.created(location).build();
	}

}
