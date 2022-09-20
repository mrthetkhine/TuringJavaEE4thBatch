package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
@Configuration
public class SimpleFunctionalEndpointConfiguration {


   
	/*
	@Bean
    WebSocketHandlerAdapter webSocketHandlerAdapter() {
        return new WebSocketHandlerAdapter();
	}	
	*/
   
	/*
    @Bean
    RouterFunction<ServerResponse> simple(GreetingsHandlerFunction handler)
    {
        return route() //
                .GET("/functional/{name}", request -> {
                    var namePathVariable = request.pathVariable("name");
                    var message = String.format("Hello %s!", namePathVariable);
                    return ok().bodyValue(message);
                }) //
                .GET("/hodor", handler)
                .GET("/sup", handler::handle)
                .build();
    }
    @Bean
    RouterFunction<ServerResponse> hello(GreetingHandler greetingHandler) {

        return route().GET("/hello", greetingHandler)
                .build();
    }
    */
}
