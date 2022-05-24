package com.turing.javaee.controlller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.turing.javaee.controller.HelloController;
import com.turing.javaee.controller.HomeController;
import com.turing.javaee.dto.Message;
import com.turing.javaee.service.MessageService;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
	 @MockBean
	 MessageService service;
	  
	 @Test
	  public void testHelloPage() throws Exception
	  {
		 Message message = new Message("Message from business service");
		 doReturn(message).when(service).getMessage();
		 //assertEquals(message, service.getMessage());
		 mockMvc.perform(get("/view/hello"))
		 		.andExpect(status().isOk())
		 		.andExpect(view().name("hello"))
		 		.andExpect(content().string(containsString("Hello,")));
	 }
}
