package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.FluxSink;
@Log4j2
public class HotStreamTest1 {
	@Test
    public void hot() throws Exception {
        var first = new ArrayList<Integer>();
        var second = new ArrayList<Integer>();
        
        EmitterProcessor<Integer> emitter = EmitterProcessor.create(2);
        FluxSink<Integer> sink = emitter.sink();
        emitter.subscribe(collect(first));
        sink.next(1);
        sink.next(2);
        
        emitter.subscribe(collect(second));
        sink.next(3);
        sink.complete();
        assertTrue(first.size() > second.size()); 
        
        first.forEach(log::info);
        
        log.info("-----");
        second.forEach(log::info);
	}
	Consumer<Integer> collect(List<Integer> collection) 
	{
        return collection::add;
	}
}
