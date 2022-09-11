package com.example.demo;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class ColdStreamTest {

	@Test
	void coldStream()
	{
		Flux<Integer> flux = Flux.just(1,2,3);
				//.delayElements(Duration.ofMillis(6));
		flux.subscribe(i->System.out.println("Sub1>> "+i));
	
		flux.subscribe(i->System.out.println("Sub2>> "+i));
	}
}
