package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class GreetingRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void givenARequest_WhenEmptyName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting?name=Aloha Snow"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("content", equalTo("Hello, Aloha Snow!")));
		}
	@Test
	public void givenARequest_whenProvidedName_thenHelloName() throws Exception {
		this.mockMvc.perform(get("/greeting?name=Jhon"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("content", equalTo("Hello, Jhon!")));
		}
	@Test
	public void givenARequest_whenNullName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting?name=''"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("content", equalTo("Hello, word")));
		}
	}