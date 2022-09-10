package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.test.StepVerifier;

@Log4j2
public class AsyncApiIntegrationTest {
	private final ExecutorService executorService = Executors.newFixedThreadPool(1);
	
	
	@Test
	public void async() {
		//Flux<Integer> integers = Flux.create(emitter -> this.launch(emitter, 5));
		Flux<Integer> integers = Flux.create(emitter -> {
			emitter.next(1);
			emitter.next(2);
			emitter.next(3);
			emitter.next(4);
			emitter.next(5);
			emitter.complete();
		});
		StepVerifier.create(
					integers.doFinally(
							signalType -> this.executorService.shutdown())
					)
					.expectNextCount(5)
					.verifyComplete();
	}
	private void launch(FluxSink<Integer> integerFluxSink, int count) {
        this.executorService.submit(() -> {
        		AtomicInteger integer = new AtomicInteger();
	           
	            while (integer.get() < count) 
	            {
	            	double random = Math.random(); 
	            	System.out.println("Item "+integer.incrementAndGet());
	            	integerFluxSink.next(integer.get());
	            	this.sleep((long) (random * 1_000));
	            }
	            integerFluxSink.complete();  
        });
        
	}
	private void sleep(long s) {
        try {
            Thread.sleep(s);
        }
        catch (Exception e) {
            log.error(e);
} }
}
