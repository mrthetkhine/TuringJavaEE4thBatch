package com.example.demo;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

//@SpringBootTest
public class SimpleFluxFactoriesTest {

	@Test
	public void simple() 
	{
		System.out.println("Simple test run");
		
		Publisher<Integer> rangeOfIntegers = Flux.range(0, 10);
		
		rangeOfIntegers.subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				
				System.out.println("OnSubscribe "+s.toString());
				
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("OnNext "+t);
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("OnError "+t);
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("OnCompleted ");
			}
    
		});
	
		
	    StepVerifier.create(rangeOfIntegers).expectNextCount(10).verifyComplete();
	}
	@Test
	public void testJust()
	{
		Flux<String> letters = Flux.just("A", "B", "C");
	    StepVerifier.create(letters).expectNext("A", "B","C").verifyComplete();
	    
	    Flux<Integer> fromArray = Flux.fromArray(new Integer[] { 1, 2, 3 });
	    StepVerifier.create(fromArray).expectNext(1, 2, 3).verifyComplete();
	    
	    AtomicInteger integer = new AtomicInteger();
	    Supplier<Integer> supplier = integer::incrementAndGet;
	    Flux<Integer> integerFlux = Flux.fromStream(Stream.generate(supplier));
	    StepVerifier.create(integerFlux.take(3)).expectNext(1).expectNext(2).expectNext(3)
	            .verifyComplete();

	}
	@Test
	public void testMono()
	{
		long now = System.currentTimeMillis();
	    Mono<Date> greetingMono = Mono.just(new Date(now));
	    StepVerifier.create(greetingMono).expectNext(new Date(now)).verifyComplete();

	}
	
}
