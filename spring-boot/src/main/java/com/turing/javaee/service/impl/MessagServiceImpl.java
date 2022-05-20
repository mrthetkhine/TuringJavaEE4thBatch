package com.turing.javaee.service.impl;

import org.springframework.stereotype.Service;

import com.turing.javaee.dto.Message;
import com.turing.javaee.service.MessageService;

@Service
public class MessagServiceImpl implements MessageService {

	@Override
	public Message getMessage() {
		
		return new Message("Message from business service");
	}

}
