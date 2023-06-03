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

import com.app.entity.Project;
import com.app.entity.Projects;

@Sql({ "classpath:schema.sql", "classpath:data.sql" })
@SpringBootTest(classes = BackconsolidadoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectControllerIntegrationTests 
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	//@Sql({"/import_senior_projects.sql"})
	public void testAllProjects() 
	{
		List<Project> projects = this.restTemplate
		.getForObject("http://localhost:" + port + "/api/projectCustomAPI/projectgetall", Projects.class)
		.getProjectList();
				
		assertTrue(projects.size() >= 1);
}

	@Test
	public void testAddProject() 
	{
		Project project = new Project((long)12,"Lokesh", "Gupta", "abc@gmail.com");	

		ResponseEntity<Project> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/api/projectCustomAPI/addproject", project, Project.class);

		assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
		assertEquals(project.getprojectName(), responseEntity.getBody().getprojectName());
	}
	
	



	
	
	
	
	
	
	
}

