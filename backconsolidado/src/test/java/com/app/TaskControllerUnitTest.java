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

import com.app.controller.TaskController;
import com.app.entity.Task;
import com.app.entity.Tasks;
import com.app.repository.TaskCRUDRepository;


@ExtendWith(MockitoExtension.class)
public class TaskControllerUnitTest {

	@InjectMocks
	TaskController taskController;
	
	@Mock
	TaskCRUDRepository taskRepositoryMock;
	
	//Test for create
	@Test
	public void testAddTask() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Task task = new Task();
		task.setTaskId((long) 1);
		
		when(taskRepositoryMock.save(any(Task.class))).thenReturn(task);
		

		Task taskToAdd = new Task((long) 0, "CRUD1", "CRUD XYZ", "01-01-2022", "02-02-2022");
		ResponseEntity<Object> responseEntity = taskController.addTask(taskToAdd);

		assertThat(responseEntity.getStatusCode().toString()).isEqualTo("201 CREATED");
		//assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/");
	}
	
	//Test for read
	@Test
	public void testFindAll() {
		// given

		Task task1 = new Task((long) 0, "Lokesh", "Gupta", "02-02-2024", "03-03-2024");
		Task task2 = new Task((long) 0, "Alex", "Gussin", "20-10-2023", "11-11-2023");
		List<Task> list = new ArrayList<Task>();
		list.addAll(Arrays.asList(task1, task2));

		when(taskRepositoryMock.findAll()).thenReturn(list);

	
		Tasks result = taskController.getTasks();

		assertThat(result.getTaskList().size()).isEqualTo(2);

		assertThat(result.getTaskList().get(0).getTaskName()).isEqualTo(task1.getTaskName());

		assertThat(result.getTaskList().get(1).getTaskName()).isEqualTo(task2.getTaskName());
	}
	
	//Test for update
	@Test
	public void updateTaskTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Task task = new Task();
		task.setTaskId((long) 1);

		when(taskRepositoryMock.save(any(Task.class))).thenReturn(task);

		// Entonces Realizo la prueba si es verdadera
		Task taskToAdd = new Task((long) 0, "Dua", "Lipa", "01-02-2022", "02-03-2022");
		ResponseEntity<Object> responseEntityCreate = taskController.addTask(taskToAdd);

		Task taskToUpdate = new Task((long) 0, "Super", "Man", "05-05-2023", "05-07-2023");
		Task responseEntityUpdate = taskController.updateTask(taskToUpdate);
		
		assertThat(responseEntityUpdate.equals(taskToUpdate));
		
	}
	
	//Test for remove
	@Test
	public void deleteTaskTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Task taskBase = new Task();
		taskBase.setTaskId((long) 1);
		
		when(taskRepositoryMock.save(any(Task.class))).thenReturn(taskBase);

		// Entonces Realizo la prueba si es verdadera
		Task task = new Task((long) 0, "Dua", "Lipa", "01-02-2024" , "03-03-2023");
		ResponseEntity<Object> responseEntityCreate = taskController.addTask(task);
		
		ResponseEntity<String> responseEntityUpdate = taskController.deleteTaskApi(task);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		
	}
	
}


