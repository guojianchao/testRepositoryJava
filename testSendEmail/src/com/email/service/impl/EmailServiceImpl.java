package com.email.service.impl;

import java.util.List;

import com.email.dao.EmailDao;
import com.email.model.CollectEmailInfo;
import com.email.model.EmailInfo;
import com.email.model.Emailserver;
import com.email.service.EmailService;

public class EmailServiceImpl implements EmailService{

	private EmailDao emailDao;
	
	
	public EmailDao getEmailDao() {
		return emailDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public boolean sendMail(EmailInfo email) {
		return this.emailDao.sendMail(email);
	}

	public EmailInfo receiveMail(EmailInfo email) {
		return this.receiveMail(email);
	}

	public boolean addEmailServer(Emailserver emailserver) {
		return this.emailDao.addEmailServer(emailserver);
	}

	public List<Emailserver> getEmailserverList() {
		return this.emailDao.getEmailserverList();
	}

	public boolean sendMultipleMail(List<EmailInfo> list) {
		boolean flag=false;
		
		try {
			
			flag=true;
		} catch (Exception e) {
		}
		
		return flag;
	}

	public List<CollectEmailInfo> getEmailList(EmailInfo emailInfo) {
		return this.emailDao.getEmailList(emailInfo);
	}

}
