package com.email.dao;

import java.util.List;

import com.email.model.CollectEmailInfo;
import com.email.model.EmailInfo;
import com.email.model.Emailserver;

public interface EmailDao {
	public boolean sendMail(EmailInfo email);
	
	public EmailInfo receiveMail(EmailInfo email);
	
	public boolean addEmailServer(Emailserver emailserver);
	
	public List<Emailserver> getEmailserverList();
	
	public List<CollectEmailInfo> getEmailList(EmailInfo emailInfo);
}
