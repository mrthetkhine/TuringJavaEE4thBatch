package com.example.demo;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import java.time.Duration;

import org.junit.jupiter.api.Test;
public class ControlFlowMergeTest {
	@Test
    public void merge() {
		Flux<Integer> fastest = Flux.just(5, 6);
        Flux<Integer> secondFastest = Flux.just(1, 2)
        								.delayElements(Duration.ofMillis(2));
        Flux<Integer> thirdFastest = Flux.just(3, 4).delayElements(Duration.ofMillis(20));
        
        Flux<Flux<Integer>> streamOfStreams = Flux.just(secondFastest, thirdFastest,
                fastest);
        Flux<Integer> merge = Flux.merge(streamOfStreams);
        StepVerifier.create(merge)
        			.expectNext(5, 6, 1, 2, 3, 4)
        			.verifyComplete();
	}
	@Test
    public void zip() {
        Flux<Integer> first = Flux.just(1, 2, 3);
        Flux<String> second = Flux.just("a", "b", "c");
        Flux<String> zip = Flux.zip(first, second)
                .map(tuple -> this.from(tuple.getT1(), tuple.getT2()));
        StepVerifier.create(zip)
        			.expectNext("1:a", "2:b", "3:c")
        			.verifyComplete();
	}
    private String from(Integer i, String s) {
        return i + ":" + s;
	}
    @Test 
    public void concat()
    {
    	 Flux<Integer> first = Flux.just(1, 2, 3)
    			 			.delayElements(Duration.ofMillis(10));
         Flux<Integer> second = Flux.just(4,5,6);
         
         Flux<Integer> conact = Flux.concat(first,second);
         StepVerifier.create(conact)
			.expectNext(1,2,3,4,5,6)
			.verifyComplete();
    }
}
