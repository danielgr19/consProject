package com.app.controller;

import java.net.URI;
import java.util.ArrayList;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
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

import com.app.entity.ProjectType;
import com.app.entity.ProjectsTypes;
import com.app.repository.ProjectTypeCRUDRepository;
import com.app.repository.ProjectTypeQUERYRepository;



//////
//import java.util.ArrayList;
//import org.springframework.http.MediaType;
//import com.app.entity.ProjectType;
//import com.app.entity.ProjectsTypes;
//import com.app.repository.ProjectTypeCRUDRepository;
//import com.app.repository.ProjectTypeQUERYRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//////



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // https://www.baeldung.com/spring-cors
@RequestMapping("/api/projectTypeCustomAPI")
public class ProjectTypeController{

	@Autowired
	private ProjectTypeCRUDRepository projectTypeRepository;
	@Autowired
	private ProjectTypeQUERYRepository projectTypeRepositoryQuery;

	// ***Api Final Front
	
	@CrossOrigin(origins = "*")
	
	@PostMapping(path = "/addprojectType", consumes = "application/json", produces = "application/json")
	public ProjectType addNewProjectTypeApi(@RequestBody ProjectType projectType) {
		// add resource
		projectType = projectTypeRepository.save(projectType);
		return projectType;
	}

	// ***Api Final Para FRONT
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/projectTypegetall", produces = "application/json")
	public ProjectsTypes getAllProjectTypeApi() {
		ProjectsTypes response = new ProjectsTypes();
		ArrayList<ProjectType> list = new ArrayList<>();
		projectTypeRepository.findAll().forEach(e -> list.add(e));
		response.setProjectTypeList(list);
		return response;
	}
	
	  //***Api Final Front
	  
	  @CrossOrigin(origins = "*")
	  
	  @PostMapping(path= "/updateprojectType", consumes = "application/json", produces = "application/json") 
	  public ProjectType updateProjectType(@RequestBody ProjectType projectType) { 
	  //add resource
	  projectTypeRepository.save(projectType); 
	  return projectType; 
	  } 
	  
	  //***Api FinalvFront
	  
	  @CrossOrigin(origins = "*")
	  
	  @PostMapping(path = "/projectTyperemove", consumes = "application/json")
	  public @ResponseBody ResponseEntity<String> deleteProjectTypesApi(@RequestBody ProjectType projectType) {
		  projectTypeRepository.deleteById(projectType.getId());
	  return new ResponseEntity<String>(HttpStatus.OK); 
	  }
	  
	  //***Otras Formas pero Bajo jUnit Testing
	  
	  @GetMapping(path="	", produces = "application/json") 
	  public ProjectsTypes getProjectsTypes(){ 
		  ProjectsTypes response = new ProjectsTypes();
		  ArrayList<ProjectType> list = new ArrayList<>();
		  projectTypeRepository.findAll().forEach(e -> list.add(e));
		  response.setProjectTypeList(list); 
		  return response; 
	  }
	  
	  @PostMapping(path= "/projectType", consumes = "application/json", produces =
	  "application/json") public ResponseEntity<Object> addProjectType(@RequestBody ProjectType projectType) { 
		  
	//add resource 
		  projectType = projectTypeRepository.save(projectType); 
	  
	  //Create resource location 
		  URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(projectType.getId()).toUri(); 
	  
	  //Send location in response
	  return ResponseEntity.created(location).build(); 
	  
	  }
	  
	  
	  


//	  	@InjectMocks
//	  	private ProjectTypeController controller;
//
//	  	@Mock
//	  	private ProjectTypeCRUDRepository mockCRUDRepository;
//
//	  	@Mock
//	  	private ProjectTypeQUERYRepository mockQUERYRepository;
//
//	  	private MockMvc mockMvc;
//
//
//		@Test
//		void testAddNewProjectTypeApi() throws Exception {
//			// Given
//			ProjectType projectType = new ProjectType();
//			projectType.setId(1L);
//			projectType.setName("Project Type 1");
//
//			when(mockCRUDRepository.save(any(ProjectType.class))).thenReturn(projectType);
//
//			mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//			// When
//			mockMvc.perform(post("/api/projectTypeCustomAPI/addprojectType")
//					.content(asJsonString(projectType))
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON))
//					// Then
//					.andExpect(status().isOk())
//					.andExpect(jsonPath("$.id").value(projectType.getId()))
//
//		}
//
//		@Test
//		void testGetAllProjectTypeApi() throws Exception {
//			// Given
//			ProjectType projectType1 = new ProjectType();
//			projectType1.setId(1L);
//
//			ProjectType projectType2 = new ProjectType();
//			projectType2.setId(2L);
//
//
//			ArrayList<ProjectType> projectTypes = new ArrayList<>();
//			projectTypes.add(projectType1);
//			projectTypes.add(projectType2);
//
//			ProjectsTypes projectsTypes = new ProjectsTypes();
//			projectsTypes.setProjectTypeList(projectTypes);
//
//			when(mockCRUDRepository.findAll()).thenReturn(projectTypes);
//
//			mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//			// When
//			mockMvc.perform(get("/api/projectTypeCustomAPI/projectTypegetall")
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON))
//					// Then
//					.andExpect(status().isOk())
//					.andExpect(jsonPath("$.projectTypeList.length()").value(2))
//					.andExpect(jsonPath("$.projectTypeList[0].id").value(projectType1.getId()))
//					.andExpect(jsonPath("$.projectTypeList[1].id").value(projectType2.getId()));
//
//		}
//
//		@Test
//		void testUpdateProjectType() throws Exception {
//			// Given
//			ProjectType projectType = new ProjectType();
//			projectType.setId(1L);
//			projectType.setName("Project Type 1");
//
//			when(mockCRUDRepository.save(any(ProjectType.class))).thenReturn(projectType);
//
//			mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//		
//	  
//	 
//}
}