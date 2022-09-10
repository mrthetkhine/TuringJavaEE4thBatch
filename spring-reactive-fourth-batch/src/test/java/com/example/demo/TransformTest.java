package com.example.demo;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class TransformTest {
	@Test
    public void transform() {
		AtomicBoolean finished = new AtomicBoolean();
        Flux<String> letters = Flux.just("a", "b", "c").transform(
                stringFlux -> stringFlux.doFinally(signal -> finished.set(true)));
        Flux<String> lettersUpper = letters.map(str->str.toUpperCase());
        StepVerifier.create(letters).expectNextCount(3).verifyComplete();
        
        StepVerifier.create(lettersUpper).expectNext("A")
        								 .expectNext("B")
        								 .expectNext("C")
        								 .verifyComplete();
	}
                
}
