package com.example.demo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
public class OnErrorResumeTest {
	private final Flux<Integer> resultsInError = Flux.just(1, 2, 3).flatMap(counter -> {
	        if (counter == 2) {
	            return Flux.error(new IllegalArgumentException("Oops!"));
	        }
	        else {
	            return Flux.just(counter);
	        } 
        });
	
	@Test
    public void onErrorResume() {
        Flux<Integer> integerFlux = resultsInError
                					.onErrorResume(IllegalArgumentException.class, e ->{
                						System.out.println("Error "+e.getMessage());
                						return Flux.just(3, 2, 1);
                					});
        StepVerifier.create(integerFlux)
        			.expectNext(1, 3, 2, 1)
        			.verifyComplete();
	}
	@Test
    public void onErrorReturn() {
        Flux<Integer> integerFlux = resultsInError
        							.onErrorReturn(0);
        StepVerifier.create(integerFlux)
        			.expectNext(1, 0)
        			.verifyComplete();
	}
}
