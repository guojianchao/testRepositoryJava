package com.cxf.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MessageService {
	public String getMessage( @WebParam (name="text" ) String text); 
}
