package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

public class OnErrorMapTest {
	@Test
    public void onErrorMap() throws Exception {
        
		class GenericException extends RuntimeException {
        }
        
        var counter = new AtomicInteger();
        Flux<Integer> resultsInError = Flux.error(new IllegalArgumentException("oops!"));
        Flux<Integer> errorHandlingStream = resultsInError
                .onErrorMap(IllegalArgumentException.class, ex -> new GenericException())
                .doOnError(GenericException.class, ge -> counter.incrementAndGet());
        StepVerifier.create(errorHandlingStream)
        			.expectError()
        			.verify();
        assertEquals(counter.get(), 1);
	}
}
