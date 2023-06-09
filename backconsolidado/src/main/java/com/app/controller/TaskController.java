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

import com.app.entity.Task;
import com.app.entity.Tasks;
import com.app.repository.TaskCRUDRepository;
import com.app.repository.TaskQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //https://www.baeldung.com/spring-cors
@RequestMapping("/taskAPI")
public class TaskController {
	@Autowired
	private TaskCRUDRepository taskRepository;
	@Autowired
	private TaskQUERYRepository taskRepositoryQuery;
	
	//***API Final Front
  @CrossOrigin(origins = "*")
	@PostMapping(path="/addtask", consumes = "application/json", produces = "application/json")	
		public Task addNewTaskApi(@RequestBody Task task) {
		//add source
		task = taskRepository.save(task);
		return task;
	}

  ////***API Final for Front
	@CrossOrigin(origins = "*")
	@GetMapping(path="/taskgetall", produces = "application/json")
	public Tasks getAllTaskApi() {
		Tasks response = new Tasks();
		ArrayList<Task> list = new ArrayList<>();
		taskRepository.findAll().forEach(e -> list.add(e));
		response.setTaskList(list);
		return response;
	}
  
	//***API Final Front
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/updatetask", consumes = "application/json", produces = "application/json")
	public Task updateTask(@RequestBody Task task) {
		//add resource
		taskRepository.save(task);
		return task;
	}

	
	//***API Final Front
	@CrossOrigin(origins = "*")
	@PostMapping(path="/taskremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteTaskApi(@RequestBody Task task){
		taskRepository.deleteById(task.getTaskId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
 // Otras formas pero Bajo JUnit Testing
	@GetMapping(path ="/taskgetallju", produces = "application/json")
	public Tasks getTasks() {
		Tasks response = new Tasks();
		ArrayList<Task> list = new ArrayList<>();
		taskRepository.findAll().forEach(e -> list.add(e));
		response.setTaskList(list);
		return response;
	}
	
	@PostMapping(path="/tasks", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addTask(@RequestBody Task task){
		task = taskRepository.save(task);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(task.getTaskName()).toUri();
		
		//Send location in response
		return ResponseEntity.created(location).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
