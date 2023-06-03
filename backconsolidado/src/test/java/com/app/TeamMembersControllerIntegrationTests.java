package com.app;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.app.entity.TeamMembers;
import com.app.entity.TeamMemberss;

@Sql({ "classpath:schema.sql", "classpath:data.sql" })
@SpringBootTest(classes = BackconsolidadoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TeamMembersControllerIntegrationTests 
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	//@Sql({"/import_senior_teamMemberss.sql"})
	public void testAllTeamMemberss() 
	{
		List<TeamMembers> teamMemberss = this.restTemplate
		.getForObject("http://localhost:" + port + "/api/teamMembersCustomAPI/teamMembersgetall", TeamMemberss.class)
		.getTeamMembersList();
				
		assertTrue(teamMemberss.size() >= 1);
	}

	@Test
	public void testAddTeamMembers() 
	{
		TeamMembers teamMembers = new TeamMembers((long)12,"Lokesh", "Gupta", "admin");	

		ResponseEntity<TeamMembers> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/api/teamMembersCustomAPI/addteamMembers", teamMembers, TeamMembers.class);

		assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
		
		assertEquals(teamMembers.getName(), responseEntity.getBody().getName()); 
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
