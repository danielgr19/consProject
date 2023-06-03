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

import com.app.controller.ProjectTypeController;
import com.app.entity.ProjectType;
import com.app.entity.ProjectsTypes;
import com.app.repository.ProjectTypeCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class ProyectTypeControllerUnitTest {

	@InjectMocks
	ProjectTypeController ProjectTypeController;

	@Mock
	ProjectTypeCRUDRepository projectTypeRepositoryMock;

	@Test
		
	public void testAddProjectType() {

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		ProjectType projectType = new ProjectType();
		projectType.setId((long) 1);

		// When alguna Accion Requerida Entonces....
		when( // Insertando un empleado
				projectTypeRepositoryMock.save(any(ProjectType.class))).thenReturn(projectType);

		// Entonces Realizo la prueba si es verdadera
		ProjectType projectTypeToAdd = new ProjectType((long) 0, "Activo", "Proyecto en estado activo");
		ResponseEntity<Object> responseEntity = ProjectTypeController.addProjectType(projectTypeToAdd);

		assertThat(responseEntity.getStatusCode().toString()).isEqualTo("201 CREATED");
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

	}

	@Test
		
	public void testFindAll() {
		// given
		ProjectType ProjectType1 = new ProjectType((long)  0, "Activo", "Proyecto en estado activo");
		ProjectType ProjectType2 = new ProjectType((long)  1, "Cancelado", "Proyecto en estado cancelado");
		List<ProjectType> list = new ArrayList<ProjectType>();
		list.addAll(Arrays.asList(ProjectType1,ProjectType2));

		when(projectTypeRepositoryMock.findAll()).thenReturn(list);

			
		// when
		ProjectsTypes result = ProjectTypeController.getProjectsTypes();

		// then
		assertThat(result.getProjectTypeList().size()).isEqualTo(2);

		assertThat(result.getProjectTypeList().get(0).getTypeOfProyect()).isEqualTo(ProjectType1.getTypeOfProyect());

		assertThat(result.getProjectTypeList().get(1).getTypeOfProyect()).isEqualTo(ProjectType2.getTypeOfProyect());
	}

		
		
	@Test
	public void updateProjectTypeTest() {

			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		ProjectType ProjectType = new ProjectType();
		ProjectType.setId((long) 1);
	when(projectTypeRepositoryMock.save(any(ProjectType.class))).thenReturn(ProjectType);

	// Entonces Realizo la prueba si es verdadera
	ProjectType projectTypeToAdd = new ProjectType((long) 1, "Cancelado", "Proyecto en estado cancelado");
	ResponseEntity<Object> responseEntityCreate = ProjectTypeController.addProjectType(projectTypeToAdd);
			
	ProjectType ProjectTypeToUpdate = new ProjectType((long) 1, "Cancelado", "Proyecto en estado cancelado");
	ProjectType responseEntityUpdate = ProjectTypeController.updateProjectType(ProjectTypeToUpdate);
		
	assertThat(responseEntityUpdate.equals(ProjectTypeToUpdate));
			
	}

	
	@Test
	public void deleteProjectTypeTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		ProjectType projectTypeBase = new ProjectType();
		projectTypeBase.setId((long) 1);
		
		when(projectTypeRepositoryMock.save(any(ProjectType.class))).thenReturn(projectTypeBase);
		// Entonces Realizo la prueba si es verdadera
		ProjectType projectType = new ProjectType((long) 1, "Cancelado", "Proyecto en estado cancelado");
		ResponseEntity<Object> responseEntityCreate = ProjectTypeController.addProjectType(projectType);
		
		ResponseEntity<String> responseEntityUpdate = ProjectTypeController.deleteProjectTypesApi(projectType);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		}
}
