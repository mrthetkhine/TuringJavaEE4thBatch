package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Log4j2
public class ControlFlowTimeoutTest {
	@Test
    public void timeout() throws Exception {
        Flux<Integer> ids = Flux.just(1, 2, 3)
        		.delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofMillis(500))
                .onErrorResume(this::given);
        StepVerifier.create(ids)
        			.expectNext(0)
        			.verifyComplete();
	}
	private Flux<Integer> given(Throwable t) {
        assertTrue(t instanceof TimeoutException,"this exception should be a " + TimeoutException.class.getName());
        return Flux.just(0);
	}
	@Test
    public void first() {
        Flux<Integer> slow = Flux.just(1, 2, 3).delayElements(Duration.ofMillis(10));
        Flux<Integer> fast = Flux.just(4, 5, 6, 7).delayElements(Duration.ofMillis(2));
        Flux<Integer> first = Flux.first(slow, fast);
        StepVerifier.create(first).expectNext(4, 5, 6, 7).verifyComplete();
	}
}
