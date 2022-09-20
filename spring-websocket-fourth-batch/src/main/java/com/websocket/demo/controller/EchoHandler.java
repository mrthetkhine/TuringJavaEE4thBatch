package com.websocket.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class EchoHandler implements WebSocketHandler {

	
	@Override
    public Mono<Void> handle(WebSocketSession session) {

			log.info("Handle invoked");
			
            Flux<WebSocketMessage> output = session.receive()
                    .doOnNext(message -> {
                            log.info("Get ws socket");
                    })
                    .map(value -> session.textMessage("Echo " + value.getPayloadAsText()));

            return session.send(output);
    }
	 

}
