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

import com.app.entity.ProjectType;
import com.app.entity.ProjectsTypes;

@Sql({ "classpath:schema.sql", "classpath:data.sql" })
@SpringBootTest(classes = BackconsolidadoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)

public class ProjectTypeControllerIntegrationTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	
	/*
	 * @Test //@Sql({"/import_senior_ProjectTypes.sql"}) public void
	 * testAllProjectTypes() { List<ProjectType> projectsTypes = this.restTemplate
	 * .getForObject("http://localhost:" + port +
	 * "/api/projectTypeCustomAPI/projectTypegetall", ProjectsTypes.class)
	 * .getProjectTypeList();
	 * 
	 * assertTrue(projectsTypes.size() >= 1); }
	 */

	/*
	 * @Test public void testAddProjectType() { ProjectType projectType = new
	 * ProjectType((long)12,"Lokesh", "abc@gmail.com");
	 * 
	 * ResponseEntity<ProjectType> responseEntity = this.restTemplate
	 * .postForEntity("http://localhost:" + port +
	 * "/api/projectTypeCustomAPI/addprojectType", projectType, ProjectType.class);
	 * 
	 * assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
	 * assertEquals(projectType.getTypeOfProyect(),
	 * responseEntity.getBody().getTypeOfProyect()); }
	 */
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
