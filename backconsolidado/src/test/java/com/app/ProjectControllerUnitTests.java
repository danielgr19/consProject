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

import com.app.controller.ProjectController;
import com.app.entity.Project;
import com.app.entity.Projects;
import com.app.repository.ProjectCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class ProjectControllerUnitTests {
	
	@InjectMocks
	ProjectController projectController;

	@Mock
	ProjectCRUDRepository projectRepositoryMock;

	@Test
	public void testAddProject() {

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Project project = new Project();
		project.setId((long) 1);

		// When alguna Accion Requerida Entonces....
		when( // Insertando un empleado
				projectRepositoryMock.save(any(Project.class))).thenReturn(project

		);

		// Entonces Realizo la prueba si es verdadera
		Project projectToAdd = new Project((long) 0, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		ResponseEntity<Object> responseEntity = projectController.addProject(projectToAdd);

		assertThat(responseEntity.getStatusCode().toString()).isEqualTo("201 CREATED");
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/");

	}

	@Test
	public void testFindAll() {
		// given
		Project Project1 = new Project((long) 0, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		Project Project2 = new Project((long) 0, "Alex", "Gussin", "example@gmail.com");
		List<Project> list = new ArrayList<Project>();
		list.addAll(Arrays.asList(Project1, Project2));

		when(projectRepositoryMock.findAll()).thenReturn(list);

		
		// when
		Projects result = projectController.getProjects();

		// then
		assertThat(result.getProjectList().size()).isEqualTo(2);

		assertThat(result.getProjectList().get(0).getprojectName()).isEqualTo(Project1.getprojectName());

		assertThat(result.getProjectList().get(1).getprojectName()).isEqualTo(Project2.getprojectName());
	}

	
	
	@Test
	public void updateProjectTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Project project = new Project();
		project.setId((long) 1);

		when(projectRepositoryMock.save(any(Project.class))).thenReturn(project);

		// Entonces Realizo la prueba si es verdadera
		Project projectToAdd = new Project((long) 0, "Dua", "Lipa", "superman@gmail.com");
		ResponseEntity<Object> responseEntityCreate = projectController.addProject(projectToAdd);
		
		Project projectToUpdate = new Project((long) 0, "Super", "Man", "howtodoinjava@gmail.com");
		Project responseEntityUpdate = projectController.updateProject(projectToUpdate);
		
		assertThat(responseEntityUpdate.equals(projectToUpdate));
		
	}

	
	@Test
	public void deleteProjectTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Project projectBase = new Project();
		projectBase.setId((long) 1);
		
		when(projectRepositoryMock.save(any(Project.class))).thenReturn(projectBase);

		// Entonces Realizo la prueba si es verdadera
		Project project = new Project((long) 0, "Dua", "Lipa", "dualipa@gmail.com");
		ResponseEntity<Object> responseEntityCreate = projectController.addProject(project);
		
		ResponseEntity<String> responseEntityUpdate = projectController.deleteProjectApi(project);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		
	}
	
	
	
}
