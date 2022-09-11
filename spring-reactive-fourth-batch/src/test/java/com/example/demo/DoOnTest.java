package com.example.demo;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Signal;
import reactor.core.publisher.SignalType;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

@Log4j2
public class DoOnTest {
	@Test
    public void doOn() {
		ArrayList<Signal<Integer>> signals = new ArrayList<Signal<Integer>>();
		ArrayList<Integer> nextValues = new ArrayList<Integer>();
		ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();
		ArrayList<Throwable> exceptions = new ArrayList<Throwable>();
		ArrayList<SignalType> finallySignals = new ArrayList<SignalType>();
		
		Flux<Integer> on = Flux//
                .<Integer>create(sink -> {
                    sink.next(1);
                    sink.next(2);
                    sink.next(3);
                    sink.error(new IllegalArgumentException("oops!"));
                    sink.complete();
                })//
                .doOnNext(nextValues::add) //
                .doOnEach(signals::add)//
                .doOnSubscribe(subscriptions::add)//
                .doOnError(IllegalArgumentException.class, exceptions::add)//
                .doFinally(finallySignals::add);
		StepVerifier//
        .create(on)//
        .expectNext(1, 2, 3)//
        .expectError(IllegalArgumentException.class)//
        .verify();
		
		 signals.forEach(log::info);
		 assertEquals(4, signals.size());
		 
         finallySignals.forEach(log::info);
         assertEquals(finallySignals.size(), 1);
         
         subscriptions.forEach(log::info);
         assertEquals(subscriptions.size(), 1);
         
         exceptions.forEach(log::info);
         assertEquals(exceptions.size(), 1);
         
         assertTrue(exceptions.get(0) instanceof IllegalArgumentException);
         
         nextValues.forEach(log::info);
         assertEquals(Arrays.asList(1, 2, 3), nextValues);

	}
}
