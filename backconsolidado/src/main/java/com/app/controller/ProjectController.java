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

import com.app.entity.Project;
import com.app.entity.Projects;
import com.app.repository.ProjectCRUDRepository;
import com.app.repository.ProjectQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //https:www.baeldung.com/spring-cors
@RequestMapping("/api/projectCustomAPI")
public class ProjectController 
{
	@Autowired
    private ProjectCRUDRepository projectRepository;
	@Autowired
	private ProjectQUERYRepository projectRepositoryQuery;


	//***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/addproject", consumes = "application/json", produces = "application/json")
	public Project addNewProjectApi(@RequestBody Project project) {
        //add resource
     	project = projectRepository.save(project);
		return project;
	}
    

       
	//***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/updateproject", consumes = "application/json", produces = "application/json")
	public Project updateProject(@RequestBody Project project) {
		//add resource
     	projectRepository.save(project);
		return project;
	}
    //***Api Final Front
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/projectremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteProjectApi(@RequestBody Project projec) {
		projectRepository.deleteById(projec.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
      	
	/* Otras Formas  pero Bajo jUnit Testing*/
	@GetMapping(path="/projectgetall", produces = "application/json")
    public Projects getProjects() 
    {
		Projects response = new Projects();
		ArrayList<Project> list = new ArrayList<>();
		projectRepository.findAll().forEach(e -> list.add(e));
		response.setProjectList(list);
        return response;
    }
    
    @PostMapping(path="/projects", consumes ="aplication/json", produces= "aplication/json")
    public ResponseEntity<Object>addProject(@RequestBody Project project){
    	project = projectRepository.save(project);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(project.getprojectName()).toUri();
		
		//Send location in response
		return ResponseEntity.created(location).build();
    }


    
    
    
    
    
    
      
}
//---
//package com.app.controller;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.entity.Project;
//import com.app.entity.Projects;
//import com.app.repository.ProjectRepository;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping(path = "/projectAPI")
//public class ProjectController {
//	@Autowired
//	private ProjectRepository projectRepository;
//
//	// ***Api Final Front
//	@PostMapping(path = "/addproject", consumes = "application/json", produces = "application/json")
//	public Project addNewProjectApi(@RequestBody Project project) {
//		// add resource
//		project = projectRepository.save(project);
//		return project;
//	}
//
//	// ***Api Final Para FRONT
//	@GetMapping(path = "/projectgetall", produces = "application/json")
//	public Projects getAllProjectsApi() {
//		Projects response = new Projects();
//		ArrayList<Project> list = new ArrayList<>();
//		projectRepository.findAll().forEach(e -> list.add(e));
//		response.setProjectList(list);
//		return response;
//	}
//
//	// ***Api Final Front
//	@PostMapping(path = "/updateproject", consumes = "application/json", produces = "application/json")
//	public Project saveProjectApi(@RequestBody Project project) {
//		// add resource
//		projectRepository.save(project);
//		return project;
//	}
//
//	// ***Api Final Front
//	@PostMapping(path = "/projectremove", consumes = "application/json")
//	public @ResponseBody ResponseEntity<String> deleteProjectApi(@RequestBody Project project) {
//		projectRepository.deleteById(project.getId());
//		return new ResponseEntity<String>(HttpStatus.OK);
//	}
//
//}






