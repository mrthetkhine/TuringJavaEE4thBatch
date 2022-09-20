package com.example.demo.controller.rest;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.CountAndString;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("consume")
public class ConsumeRestController {
	
	 WebClient webClient;
	 
	 @PostConstruct
	 void init()
	 {
		 System.out.println("PostConstruct");
		 this.webClient = WebClient.builder()
				  .baseUrl("https://mocki.io")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  .defaultUriVariables(Collections.singletonMap("url", "https://mocki.io"))
				  .build();
	 }
	 @GetMapping("/sync")
	 public String getDummyData() {
	        RestTemplate restTemplate = new RestTemplate();

	        String resourceUrl
	          = "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";

	        // Fetch JSON response as String wrapped in ResponseEntity
	        ResponseEntity<String> response
	          = restTemplate.getForEntity(resourceUrl, String.class);
	        
	        String productsJson = response.getBody();
	        
	        System.out.println(productsJson);
	        return productsJson;
	    }
	 @GetMapping("/async")
	 public Mono<String> getAsyncData() {
		
		 WebClient.ResponseSpec responseSpec = webClient.get()
				    .uri("https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8")
				    .retrieve();
		 return responseSpec.bodyToMono(String.class);
	       
	 }
	 @GetMapping("/todo")
	 public Mono<String> getToDo() {
		
		 WebClient.ResponseSpec responseSpec = webClient.get()
				    .uri("https://jsonplaceholder.typicode.com/todos/2")
				    .retrieve();
		 return responseSpec.bodyToMono(String.class);
	       
	 }
	 @GetMapping("/todo/sync")
	 public String getTwoToDoSync() {
		    long start = System.currentTimeMillis();
	        RestTemplate restTemplate = new RestTemplate();

	        String resourceUrl = "https://jsonplaceholder.typicode.com/todos/1";
	        ResponseEntity<String> response
	          = restTemplate.getForEntity(resourceUrl, String.class);
	        
	        String todDo1 = response.getBody();
	        
	        resourceUrl = "https://jsonplaceholder.typicode.com/todos/2";
	        response = restTemplate.getForEntity(resourceUrl, String.class);
	        
	        String toDo2 = response.getBody();
	        //System.out.println(productsJson);
	        long end = System.currentTimeMillis();
	        long time = end - start;
	        System.out.println("Sync Time "+time);
	        return todDo1+toDo2;
	    }
	 @GetMapping("/todo/async")
	 public Flux<String> getTwoToDoAsync()
	 {
		 long start = System.currentTimeMillis();
		 WebClient.ResponseSpec responseSpec = webClient.get()
				    .uri("https://jsonplaceholder.typicode.com/todos/1")
				    .retrieve();
		 Mono<String> toDoOne = responseSpec.bodyToMono(String.class);
		 responseSpec = webClient.get()
				    .uri("https://jsonplaceholder.typicode.com/todos/2")
				    .retrieve();
		 Mono<String> toDoTwo = responseSpec.bodyToMono(String.class);
		 Flux<String> twoToDos = Flux.concat(toDoOne,toDoTwo);
		 
		 twoToDos.subscribe((data)->{
			 	//System.out.println(data);
			 	long end = System.currentTimeMillis();
		        long time = end - start;
		        System.out.println("Async Time "+time);
		 });
		 return twoToDos.onErrorReturn("Empty Value");
		 //return twoToDos;
	 }
	 @GetMapping("/todo/block")
	 public String getTwoToDoBlock()
	 {
		 long start = System.currentTimeMillis();
		 WebClient.ResponseSpec responseSpec = webClient.get()
				    .uri("https://jsonplaceholder.typicode.com/todos/1")
				    .retrieve();
		 String toDoOne = responseSpec.bodyToMono(String.class).block();
		 responseSpec = webClient.get()
				    .uri("https://jsonplaceholder.typicode.com/todos/2")
				    .retrieve();
		 String toDoTwo = responseSpec.bodyToMono(String.class).block();
		 long end = System.currentTimeMillis();
         long time = end - start;
         System.out.println("Block Time "+time);
		 return toDoOne+toDoTwo;
		 //return twoToDos;
	 }
	 @GetMapping(value="/interval",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	 public Flux<CountAndString> getIntervalData()
	 {
		 var counter = new AtomicLong();
		 return Flux.interval(Duration.ofMillis(300))
				 	.map(i -> new CountAndString(counter.incrementAndGet()));
	 }
	
}
