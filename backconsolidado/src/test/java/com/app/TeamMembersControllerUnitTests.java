package com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.controller.TeamMembersController;
import com.app.entity.TeamMembers;
import com.app.entity.TeamMemberss;
import com.app.repository.TeamMembersCRUDRepository;



@ExtendWith(MockitoExtension.class)
public class TeamMembersControllerUnitTests {
	
	@InjectMocks
	TeamMembersController teamMembersController;

	@Mock
	TeamMembersCRUDRepository teamMembersRepositoryMock;

	@Test
	public void testAddTeamMembers() {

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest(); 
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		// When alguna Accion Requerida Entonces....
		TeamMembers teamMembers = new TeamMembers();
		teamMembers.setId((long) 1);
		when( // Insertando un empleado
				teamMembersRepositoryMock.save(any(TeamMembers.class))).thenReturn(teamMembers);

		// Entonces Realizo la prueba si es verdadera
		TeamMembers teamMembersToAdd = new TeamMembers((long) 0, "Lokesh", "Gupta", "Usuario");
		ResponseEntity<Object> responseEntity = teamMembersController.addTeamMembers(teamMembersToAdd);

		assertThat(responseEntity.getStatusCode().toString()).isEqualTo("201 CREATED");
		//assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/");

	}

	@Test
	public void testFindAll() {
		// given
		TeamMembers teamMembers1 = new TeamMembers((long) 0, "Lokesh", "Gupta", "Administrador");
		TeamMembers teamMembers2 = new TeamMembers((long) 1, "Alex", "Gussin", "Usuario");
		List<TeamMembers> list = new ArrayList<TeamMembers>();
		list.addAll(Arrays.asList(teamMembers1, teamMembers2));

		when(teamMembersRepositoryMock.findAll()).thenReturn(list);

		
		// when
		TeamMemberss result = teamMembersController.getTeamMemberss();

		// then
		assertThat(result.getTeamMembersList().size()).isEqualTo(2);

		assertThat(result.getTeamMembersList().get(0).getName()).isEqualTo(teamMembers1.getName());

		assertThat(result.getTeamMembersList().get(1).getName()).isEqualTo(teamMembers2.getName());
	}

	
	
	@Test
	public void updateTeamMembersTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		TeamMembers teamMembers = new TeamMembers();
		teamMembers.setId((long) 1);

		when(teamMembersRepositoryMock.save(any(TeamMembers.class))).thenReturn(teamMembers);

		// Entonces Realizo la prueba si es verdadera
		TeamMembers teamMembersToAdd = new TeamMembers((long) 0, "Dua", "Lipa", "superman@gmail.com");
		ResponseEntity<Object> responseEntityCreate = teamMembersController.addTeamMembers(teamMembersToAdd);
		
		TeamMembers teamMembersToUpdate = new TeamMembers((long) 0, "Super", "Man", "howtodoinjava@gmail.com");
		TeamMembers responseEntityUpdate = teamMembersController.updateTeamMembers(teamMembersToUpdate);
		
		assertThat(responseEntityUpdate.equals(teamMembersToUpdate));
		
	}

	
	@Test
	public void deleteTeamMembersTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		TeamMembers teamMembersBase = new TeamMembers();
		teamMembersBase.setId((long) 1);
		
		when(teamMembersRepositoryMock.save(any(TeamMembers.class))).thenReturn(teamMembersBase);

		// Entonces Realizo la prueba si es verdadera
		TeamMembers teamMembers = new TeamMembers((long) 0, "Dua", "Lipa", "dualipa@gmail.com");
		ResponseEntity<Object> responseEntityCreate = teamMembersController.addTeamMembers(teamMembers);
		
		ResponseEntity<String> responseEntityUpdate = teamMembersController.deleteTeamMembersApi(teamMembers);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		
	}
	
	
	
}
