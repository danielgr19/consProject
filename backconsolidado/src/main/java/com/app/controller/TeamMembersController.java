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

import com.app.entity.TeamMembers;
import com.app.entity.TeamMemberss;
import com.app.repository.TeamMembersCRUDRepository;
import com.app.repository.TeamMembersQUERYRepository;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //https://www.baeldung.com/spring-cors
@RequestMapping("/api/teamMembersCustomAPI")

public class TeamMembersController {
	
	@Autowired
	private TeamMembersCRUDRepository teamMembersRepository;
	@Autowired
	private TeamMembersQUERYRepository teamMembersRespositoryQuery;
	
	//***Api Final Front
	
	  @CrossOrigin(origins = "*")
	  
	  @PostMapping(path= "/addteamMembers", consumes = "application/json", produces = "application/json") 
	  public TeamMembers addNewTeamMembersApi(@RequestBody TeamMembers teamMembers) { 
		  //add resource 
		  teamMembers = teamMembersRepository.save(teamMembers); 
		  return teamMembers; 
		  }
	 
	    
//Debe ir el otro metodo getall
	       
	    //***Api Final Front
		@CrossOrigin(origins = "*")
	    @PostMapping(path= "/updateteamMembers", consumes = "application/json", produces = "application/json")
		public TeamMembers updateTeamMembers(@RequestBody TeamMembers teamMembers) {
	        //add resource
			teamMembersRepository.save(teamMembers);
			return teamMembers;
		}
		
//	    //***Api Final Front
		@CrossOrigin(origins = "*")
		@PostMapping(path = "/teamMembersremove", consumes = "application/json")
		public @ResponseBody ResponseEntity<String> deleteTeamMembersApi(@RequestBody TeamMembers teamMembers) {
			teamMembersRepository.deleteById(teamMembers.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	    
	      	
		/* Otras Formas  pero Bajo jUnit Testing*/
		@GetMapping(path="/teamMembersgetall", produces = "application/json")
	    public TeamMemberss getTeamMemberss() 
	    {
			TeamMemberss response = new TeamMemberss();
			ArrayList<TeamMembers> list = new ArrayList<>();
			teamMembersRepository.findAll().forEach(e -> list.add(e));
			response.setTeamMembersList(list);
	        return response;
	    }
	    
	    @PostMapping(path= "/teamMemberss", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Object> addTeamMembers(@RequestBody TeamMembers teamMembers) {       
	        //add resource
	    	teamMembers = teamMembersRepository.save(teamMembers);
	        //Create resource location
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                                    .path("/{id}")
	                                    .buildAndExpand(teamMembers.getId())
	                                    .toUri();
	        //Send location in response
	        return ResponseEntity.created(location).build();
	    }

}
