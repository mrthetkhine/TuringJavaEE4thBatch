package com.websocket.demo;

import java.net.URI;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import reactor.core.publisher.Mono;

public class ReactiveJavaClientWebSocketTest {
	@Test
	public void testWebSocket()
	{
		 WebSocketClient client = new ReactorNettyWebSocketClient();
	        client.execute(
	          URI.create("ws://127.0.0.1:8080/ws/echo"), 
	          session -> session.send(
	            Mono.just(session.textMessage("hello")))
	            .thenMany(session.receive()
	              .map(WebSocketMessage::getPayloadAsText)
	              .log())
	            .then())
	            .block(Duration.ofSeconds(10L));
	}
}
