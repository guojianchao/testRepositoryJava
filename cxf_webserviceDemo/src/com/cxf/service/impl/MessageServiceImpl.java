package com.cxf.service.impl;

import javax.jws.WebService;

import com.cxf.service.MessageService;

@WebService (endpointInterface = "com.cxf.service.MessageService" , serviceName = "MessageService" ) 
public class MessageServiceImpl implements MessageService {
	
	public String getMessage(String text) {
		
		return "<User><name>"+text+"<name></User>";
	}

}
