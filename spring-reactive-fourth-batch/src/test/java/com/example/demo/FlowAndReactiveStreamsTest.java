package com.example.demo;

import java.util.concurrent.Flow;

import org.junit.jupiter.api.Test;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FlowAndReactiveStreamsTest {

	@Test
	public void convert()
	{
		Flux<Integer> original = Flux.range(0, 10);
        Flow.Publisher<Integer> rangeOfIntegersAsJdk9Flow = FlowAdapters
                .toFlowPublisher(original);
        Publisher<Integer> rangeOfIntegersAsReactiveStream = FlowAdapters
                .toPublisher(rangeOfIntegersAsJdk9Flow);
        StepVerifier.create(original).expectNextCount(10).verifyComplete();
        StepVerifier.create(rangeOfIntegersAsReactiveStream).expectNextCount(10)
                .verifyComplete();
	}
}
