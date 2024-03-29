package com.example.demo.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Controller
public class HomeController {
	
	/*
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path="/")
	public Mono<String> index()
	{
		
		Flux<String> x = Flux.just("x1","x2","x3");
		Flux<String> y = Flux.just("y1","y2");
		
		Flux<String> another = Flux.concat(x,y);
		another.subscribe(
				str->System.out.println("Result "+str));
		another.subscribe(
				str->System.out.println("Result2 "+str));
		
		Flux.merge(x,y).subscribe(
				str->System.out.println("Merge "+str));
		Flux.zip(x, y).subscribe(
				str->System.out.println("Zip "+str));
		
		
		return Mono.just("It works");
	}
	*/
	 @RequestMapping("/websocket")
	 public String webSocket()
	 {
		 log.info("WebSocket html");
		 return "websocket";
	 }
}
