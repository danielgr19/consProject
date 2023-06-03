package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.app.entity.State;
import com.app.entity.States;

@Sql({ "classpath:schema.sql", "classpath:data.sql" })
@SpringBootTest(classes = BackconsolidadoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class StateControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	
/*	@Test*/
	//@Sql({"/import_senior_states.sql"})
	/*
	 * public void testAllState() { List<State> states = this.restTemplate
	 * .getForObject("http://localhost:" + port + "/api/stateCustomAPI/stategetall",
	 * States.class) .getStateList();
	 * 
	 * assertTrue(states.size() >= 1); }
	 */
	
/*	public void testAllState() {
	    States statesResponse = this.restTemplate
	        .getForObject("http://localhost:" + port + "/api/stateCustomAPI/stategetall", States.class);
	    
	    assertNotNull(statesResponse);
	    List<State> states = statesResponse.getStateList();
	    assertNotNull(states);
	    Porque esto?
	    assertTrue(states.size() >= 0);
	    // Add more specific assertions based on your requirements
	     * 
	     
	     
	}
	

	
	@Test
	public void testAddState() {
	    State state = new State((long) 12, "Lokesh", "Gupta");

	    ResponseEntity<State> responseEntity = this.restTemplate
	            .postForEntity("http://localhost:" + port + "/api/stateCustomAPI/addstate", state, State.class);

	    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

	    // Aquí puedes realizar otras verificaciones adicionales según tus necesidades.
	    // Por ejemplo, verificar algún mensaje de error en la respuesta si es relevante.

	    // assertEquals(state.getStateName(), responseEntity.getBody().getStateName());
	}

	*/
	/*Porque esta Mala esta parte?

	/*
	 * @Test public void testAddState() { State state = new State((long)12,"Lokesh",
	 * "Gupta");
	 * 
	 * ResponseEntity<State> responseEntity = this.restTemplate
	 * .postForEntity("http://localhost:" + port + "/api/stateCustomAPI/addstate",
	 * state, State.class);
	 * 
	 * assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
	 * 
	 * assertEquals(state.getStateName(), responseEntity.getBody().getStateName());
	 * }
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


