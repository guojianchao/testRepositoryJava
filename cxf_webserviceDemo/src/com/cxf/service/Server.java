package com.cxf.service;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.cxf.service.impl.MessageServiceImpl;

public class Server {
	protected Server(){
		MessageService helloWord = new MessageServiceImpl(); //Endpoint���ṩ�ľ�̬���������Ժ����׵ķ���WebService��JettyĬ�϶˿���9000
		String address = "http://127.0.0.1:9000/MessageService";
		Endpoint.publish(address, helloWord);
	}
	public static void main(String[] args) {
		//new Server();
		//System.out.println("����");
	JaxWsServerFactoryBean server = new 	JaxWsServerFactoryBean();
	server.setAddress("http://127.0.0.1:9000/MessageService");
	server.setServiceClass(MessageServiceImpl.class);
	//server.getInInterceptors().add(new LoggingInInterceptor());	//server.getOutInterceptors().add(new LoggingOutInterceptor());
	server.create().start();
	}

}
