package com.email.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.email.dao.EmailDao;
import com.email.model.CollectEmailInfo;
import com.email.model.EmailInfo;
import com.email.model.Emailserver;
import com.email.util.MailHelper;
import com.email.util.ReciveOneMail;

public class EmailDaoImpl extends HibernateDaoSupport  implements EmailDao {
	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public EmailInfo receiveMail(EmailInfo email) {
		return null;
	}

	public boolean sendMail(EmailInfo email) {
		boolean flag=false;
		try {
			MailHelper.sendMail(email.getServerAddress(), email.getUser(), email.getPwd(), email.getFrom(), email.getEmailReceiver(), email.getSubject(), email.getHtmlContents());
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}

	public boolean addEmailServer(Emailserver emailserver) {
		boolean flag=false;
		try {
			this.getHibernateTemplate().save(emailserver);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Emailserver> getEmailserverList() {
		return (List<Emailserver>)this.ht.find("from Emailserver");
	}

	public List<CollectEmailInfo> getEmailList(EmailInfo emailInfo) {
		List<CollectEmailInfo> list=new ArrayList<CollectEmailInfo>();
		try {
			 list=ReciveOneMail.getEmailList(emailInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
