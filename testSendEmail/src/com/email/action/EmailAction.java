package com.email.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import sun.org.mozilla.javascript.internal.ContextAction;

import com.email.model.CollectEmailInfo;
import com.email.model.EmailInfo;
import com.email.model.Emailserver;
import com.email.service.EmailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;

public class EmailAction extends ActionSupport{
	private EmailService emailService;
	
	private EmailInfo emailInfo;
	
	private Emailserver emailserver;
	
	private String suffix;
	
	
	public String getSuffix() {
		return suffix;
	}


	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	public Emailserver getEmailserver() {
		return emailserver;
	}


	public void setEmailserver(Emailserver emailserver) {
		this.emailserver = emailserver;
	}


	public EmailInfo getEmailInfo() {
		return emailInfo;
	}


	public void setEmailInfo(EmailInfo emailInfo) {
		this.emailInfo = emailInfo;
	}


	public EmailService getEmailService() {
		return emailService;
	}


	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("执行成功！！"+emailInfo.getServerAddress());
		emailInfo.setEmailReceiver(new String(emailInfo.getEmailReceiver().getBytes("ISO-8859-1"),"utf-8"));
		emailInfo.setFrom(new String(emailInfo.getUser().getBytes("ISO-8859-1"),"utf-8")+suffix);
		emailInfo.setHtmlContents(new String(emailInfo.getHtmlContents().getBytes("ISO-8859-1"),"utf-8"));
//		emailInfo.setHtmlContents("<p class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto'><span style='font-family:宋体;color:red'>您好！</span><span lang=EN-US style='color:red'><o:p></o:p></span></p>");
		emailInfo.setPwd(new String(emailInfo.getPwd().getBytes("ISO-8859-1"),"utf-8"));
		emailInfo.setServerAddress(new String(emailInfo.getServerAddress().getBytes("ISO-8859-1"),"utf-8"));
		emailInfo.setSubject(new String(emailInfo.getSubject().getBytes("ISO-8859-1"),"utf-8"));
		emailInfo.setUser(new String(emailInfo.getUser().getBytes("ISO-8859-1"),"utf-8")+suffix);
		System.out.println(emailInfo.getHtmlContents());
		this.emailService.sendMail(emailInfo);
		
		return SUCCESS;
	}
	
	public String addEmailserver(){
		try {
			String str=new String(emailserver.getEmailservername().getBytes("ISO-8859-1"),"utf-8");
			System.out.println(str);
			str=new String(str.getBytes("utf-8"),"gbk");
			emailserver.setEmailservername(str);
			this.emailService.addEmailServer(emailserver);
			
			System.out.println(this.emailService.getEmailserverList().get(1).getEmailservername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	}
	
	public String collectEmail(){
		emailInfo.setSubject(suffix.substring(1, suffix.length()));
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		
		List<CollectEmailInfo> list= this.emailService.getEmailList(emailInfo);
		List<CollectEmailInfo> listCollectEmailInfo= this.emailService.getEmailList(emailInfo);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSubject(list.get(i).getSubject().substring(0, 6)+"......");
			if(list.get(i).getMessageId()==null||list.get(i).getMessageId().equals("")){
				listCollectEmailInfo.get(i).setMessageId("无");
				list.get(i).setMessageId("无");
			}
		}
		session.put("listCollectEmailInfo", listCollectEmailInfo);
		session.put("list", list);
		
		return SUCCESS;
	}
	
	
	public String readEmail(){
		String str=ServletActionContext.getRequest().getParameter("messageId");
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		List<CollectEmailInfo> list=(List<CollectEmailInfo>) session.get("listCollectEmailInfo");
		CollectEmailInfo ce=new CollectEmailInfo();
		System.out.println(list.size());
		for (CollectEmailInfo collectEmailInfo : list) {
			System.out.println(str+"    "+collectEmailInfo.getMessageId());
			if(collectEmailInfo.getMessageId().equals(str)){
				ce=collectEmailInfo;
				break;
			}
		}
		session.put("collectEmail", ce);
		
		return SUCCESS;
	}
	
	
	
	private List<Emailserver> list=new ArrayList<Emailserver>();
	
	public List<Emailserver> getList() {
		return list;
	}


	public void setList(List<Emailserver> list) {
		this.list = list;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String initEmailserver(){
		String str=ServletActionContext.getRequest().getParameter("flag");
	    list=this.emailService.getEmailserverList(); 
		System.out.println("========================"+list.size());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", list);
		if(str.equals("1")){
			return "collect";
		}else{
		return SUCCESS;
		}
	}

}
