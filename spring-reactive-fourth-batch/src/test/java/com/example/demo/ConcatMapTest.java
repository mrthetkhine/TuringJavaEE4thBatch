package com.example.demo;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ConcatMapTest {
	@Test
    public void concatMap() {
        Flux<Integer> data = Flux
                .just(new Pair(1, 300), new Pair(2, 200), new Pair(3, 100))//
                .concatMap(id -> this.delayReplyFor(id.id, id.delay));
        StepVerifier//
                .create(data)//
                .expectNext(1, 2, 3)//
                .verifyComplete();
	}
	private Flux<Integer> delayReplyFor(Integer i, long delay) {
        return Flux.just(i).delayElements(Duration.ofMillis(delay));
}
    @AllArgsConstructor
    static class Pair {
        private int id;
        private long delay;
    }
}
