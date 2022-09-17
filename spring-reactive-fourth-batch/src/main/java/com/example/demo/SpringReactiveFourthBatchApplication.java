package com.example.demo;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

//@EnableScheduling
//@EnableWebFlux
@SpringBootApplication
public class SpringReactiveFourthBatchApplication {

	 @Bean
	    RouterFunction<ServerResponse> another() {
	        return route().GET("/product", req -> ok().bodyValue("Hello"))
	                .build();
	    }

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveFourthBatchApplication.class, args);
	}

}
