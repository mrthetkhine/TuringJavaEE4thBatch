package com.websocket.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy;



import lombok.extern.log4j.Log4j2;
@Log4j2
@SpringBootApplication
public class SpringWebsocketFourthBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebsocketFourthBatchApplication.class, args);
	}
	@Autowired
	private WebSocketHandler webSocketHandler;
	
	@Bean
	public WebSocketService webSocketService() {
	    return new HandshakeWebSocketService(new ReactorNettyRequestUpgradeStrategy());
	}
	@Bean
	public HandlerMapping webSocketHandlerMapping() {
		log.info("WebSocket mapping build");
	    Map<String, WebSocketHandler> map = new HashMap<>();
	    map.put("/ws/echo", webSocketHandler);

	    SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
	    handlerMapping.setOrder(-1);
	    handlerMapping.setUrlMap(map);
	    return handlerMapping;
	}
}
