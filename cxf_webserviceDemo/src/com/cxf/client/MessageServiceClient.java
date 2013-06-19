package com.cxf.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.cxf.service.MessageService;

public class MessageServiceClient {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean(); 
        factory.getInInterceptors().add( new LoggingInInterceptor()); 
        factory.getOutInterceptors().add( new LoggingOutInterceptor()); 
        factory.setServiceClass(MessageService. class); 
        factory.setAddress("http://127.0.0.1:9000/MessageService" ); 
        MessageService client = (MessageService) factory.create(); 
 
        String reply = client.getMessage( "ÕÅÈý" ); 
        System. out .println("Server said: " + reply); 

	}
}
