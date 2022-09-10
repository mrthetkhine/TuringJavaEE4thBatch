package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ThenManyTest {
	@Test
    public void thenMany() {
		AtomicInteger letters = new AtomicInteger();
		AtomicInteger numbers = new AtomicInteger();
        Flux<String> lettersPublisher = Flux.just("a", "b", "c")
                .doOnNext(value -> {
                	System.out.println("Letter publisher value "+value);
                	letters.incrementAndGet();
                });
        Flux<Integer> numbersPublisher = Flux.just(1, 2, 3)
                .doOnNext(number -> {
                	System.out.println("Number publisher value "+number);
                	numbers.incrementAndGet();
                });
        Flux<Integer> thisBeforeThat = lettersPublisher.thenMany(numbersPublisher);
        StepVerifier.create(thisBeforeThat).expectNext(1, 2, 3).verifyComplete();
        assertEquals(letters.get(), 3);
        assertEquals(numbers.get(), 3);
	}
}
