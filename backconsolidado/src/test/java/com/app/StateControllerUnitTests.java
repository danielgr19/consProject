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

import com.app.controller.StateController;
import com.app.entity.State;
import com.app.entity.States;
import com.app.repository.StateCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class StateControllerUnitTests {

	@InjectMocks
	StateController stateController;

	@Mock
	StateCRUDRepository stateRepositoryMock;

	@Test
	
	public void testAddState() {

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		State state = new State();
		state.setId((long) 1);

		// When alguna Accion Requerida Entonces....
		when( // Insertando un empleado
				stateRepositoryMock.save(any(State.class))).thenReturn(state);

		// Entonces Realizo la prueba si es verdadera
		State stateToAdd = new State((long) 0, "Activo", "Proyecto en estado activo");
		ResponseEntity<Object> responseEntity = stateController.addState(stateToAdd);

		assertThat(responseEntity.getStatusCode().toString()).isEqualTo("201 CREATED");
		//assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

	}

	@Test
	
	public void testFindAll() {
		// given
		State state1 = new State((long)  0, "Activo", "Proyecto en estado activo");
		State state2 = new State((long)  1, "Cancelado", "Proyecto en estado cancelado");
		List<State> list = new ArrayList<State>();
		list.addAll(Arrays.asList(state1, state2));

		when(stateRepositoryMock.findAll()).thenReturn(list);

		
		// when
		States result = stateController.getStates();

		// then
		assertThat(result.getStateList().size()).isEqualTo(2);

		assertThat(result.getStateList().get(0).getStateName()).isEqualTo(state1.getStateName());

		assertThat(result.getStateList().get(1).getStateName()).isEqualTo(state2.getStateName());
	}

	
	
	@Test
	public void updateEmployeeTest() {

			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		State state = new State();
		state.setId((long) 1);

		when(stateRepositoryMock.save(any(State.class))).thenReturn(state);

		// Entonces Realizo la prueba si es verdadera
		State stateToAdd = new State((long) 1, "Cancelado", "Proyecto en estado cancelado");
		ResponseEntity<Object> responseEntityCreate = stateController.addState(stateToAdd);
		
		State stateToUpdate = new State((long) 1, "Cancelado", "Proyecto en estado cancelado");
		State responseEntityUpdate = stateController.updateState(stateToUpdate);
		
		assertThat(responseEntityUpdate.equals(stateToUpdate));
		
	}

	
	@Test
	public void deleteEmployeeTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		State stateBase = new State();
		stateBase.setId((long) 1);
		
		when(stateRepositoryMock.save(any(State.class))).thenReturn(stateBase);

		// Entonces Realizo la prueba si es verdadera
		State state = new State((long) 1, "Cancelado", "Proyecto en estado cancelado");
		ResponseEntity<Object> responseEntityCreate = stateController.addState(state);
		
		ResponseEntity<String> responseEntityUpdate = stateController.deleteStateApi(state);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		
	}
}
