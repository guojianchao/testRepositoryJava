package com.email.model;

public class CollectEmailInfo {
	 private String subject;
	 private String sentdate;
	 private boolean replysign;
	 public boolean isReplysign() {
		return replysign;
	}
	public void setReplysign(boolean replysign) {
		this.replysign = replysign;
	}
	private boolean hasRead;
	 private boolean containAttachment;
	 private String form;
	 private String to;
	 private String cc;
	 private String bcc;
	 private String messageId;
	 private String bodycontent;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSentdate() {
		return sentdate;
	}
	public void setSentdate(String sentdate) {
		this.sentdate = sentdate;
	}

	public boolean getHasRead() {
		return hasRead;
	}
	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}
	public boolean getContainAttachment() {
		return containAttachment;
	}
	public void setContainAttachment(boolean containAttachment) {
		this.containAttachment = containAttachment;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getBodycontent() {
		return bodycontent;
	}
	public void setBodycontent(String bodycontent) {
		this.bodycontent = bodycontent;
	}
	 
	 
}
