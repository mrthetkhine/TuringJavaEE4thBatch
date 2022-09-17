package com.functionalendpoint.demo.config;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler implements HandlerFunction<ServerResponse> {



	@Override
	public Mono<ServerResponse> handle(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		      .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
	}
}