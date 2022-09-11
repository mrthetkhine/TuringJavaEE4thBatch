package com.example.demo.controller.rest;

import java.time.Duration;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@CrossOrigin	
@RequestMapping("/event-loop")
public class EventLoopDemo {
	@GetMapping(path="blocking")
	Flux<Integer> blockCall()
	{
		return Flux.just(1,2,3)
				.delayElements(Duration.ofMillis(500));
	}
	
}
