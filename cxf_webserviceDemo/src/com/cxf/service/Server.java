package com.cxf.service;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.cxf.service.impl.MessageServiceImpl;

public class Server {
	protected Server(){
		MessageService helloWord = new MessageServiceImpl(); //Endpoint类提供的静态方法，可以很容易的发布WebService，Jetty默认端口是9000
		String address = "http://127.0.0.1:9000/MessageService";
		Endpoint.publish(address, helloWord);
	}
	public static void main(String[] args) {
		//new Server();
		//System.out.println("发布");
	JaxWsServerFactoryBean server = new 	JaxWsServerFactoryBean();
	server.setAddress("http://127.0.0.1:9000/MessageService");
	server.setServiceClass(MessageServiceImpl.class);
	//server.getInInterceptors().add(new LoggingInInterceptor());	//server.getOutInterceptors().add(new LoggingOutInterceptor());
	server.create().start();
	}

}
