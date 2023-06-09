package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.app.entity.Task;
import com.app.entity.Tasks;


@Sql({ "classpath:schema.sql", "classpath:data.sql" })
@SpringBootTest(classes = BackconsolidadoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskControllerIntegrationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAddTask(){
		Task task = new Task((long)12,"Lokesh", "Gupta", "01-01-2023", "02-02-2023");

		ResponseEntity<Task> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/taskAPI/addtask", task, Task.class);

		assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
		assertEquals(task.getTaskName(), responseEntity.getBody().getTaskName());
	}
	
	@Test
	//@Sql({"/import_senior_employees.sql"})
	public void testAllTasks(){
		List<Task> tasks = this.restTemplate
		.getForObject("http://localhost:" + port + "/taskAPI/taskgetallju", Tasks.class)
		.getTaskList();
				
		assertTrue(tasks.size() >= 1); 
	}
	

	
	
	
	
	
	
	
	
	/*
	 
	 ResponseEntity<String> entity = template.getForEntity("http://example.com", String.class);
	 String body = entity.getBody();
	 MediaType contentType = entity.getHeaders().getContentType();
	 HttpStatus statusCode = entity.getStatusCode();
	 
	 https://crunchify.com/json-manipulation-in-java-examples/
	 https://www.geeksforgeeks.org/working-with-json-data-in-java/
	 https://www.tutorialspoint.com/json/json_java_example.htm
	 */
	
}
