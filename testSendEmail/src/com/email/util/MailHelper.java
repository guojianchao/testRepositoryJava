package com.email.util;



import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;


/**
 * 创建并发送电子邮件的帮助类
 */
public class MailHelper {

	public MailHelper() {
	}
	
	public static void main(String[] args) {
//		String user= "guojianchao@beijing-sports.com";
//		System.out.println(user.substring(user.indexOf("@")+1, user.length()));
		MailHelper.sendMail("mail.beijing-sports.com", "guojianchao@beijing-sports.com", "bst_2013", "guojianchao@beijing-sports.com", "837776282@qq.com", "fjc", "哥写的邮件成了！");
	}

	public static boolean sendMail(String serverAddress, String user,
			String pwd, String from, String emailReceiver, String subject,
			String htmlContents) {

		try {
			// 创建Properties对象
			Properties props = System.getProperties();
			System.out.println(props);
			// 创建信件服务器
			props.put("mail.smtp.auth", "true");
			//设置超时时间
			props.put("mail.smtp.connectiontimeout", "10000"); //
			props.put("mail.smtp.timeout", "10000");   // 
			// 得到默认的对话对象
			Session session = Session.getDefaultInstance(props, null);

			// 创建一个消息，并初始化该消息的各项元素
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(emailReceiver) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);

			// 后面的BodyPart将加入到此处创建的Multipart中
			Multipart mp = new MimeMultipart();
			// 设置内容
			BodyPart bp = new MimeBodyPart();
			bp.setContent(htmlContents + getMailCorpright(),
					"text/html;charset=gbk");
			mp.addBodyPart(bp);
			// Multipart加入到信件
			msg.setContent(mp);
			// 设置信件头的发送日期
			msg.setSentDate(new Date());
			msg.saveChanges();

			// 发送信件
			Transport trans = session.getTransport("smtp");
			trans.connect(serverAddress, user, pwd);

			if (trans.isConnected()) {
				trans.sendMessage(msg, msg.getAllRecipients());
				trans.close();
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}
/**
 * 只用传发送邮件地址与邮件标题，邮件内容就发送邮件。
 * @param emailReceiver
 * @param subject
 * @param htmlContents
 * @return
 */
	public static boolean sendSmtpMail(String emailReceiver, String subject,
			String htmlContents) {

//		try {
//			MailConfig mailconfig = SystemManager.getMailConfig(null);
//			if (mailconfig != null) {
//				// String subject = "";
//				String serverAddress = mailconfig.getSmtp_host();
//				String userName = mailconfig.getSmtp_user();
//				String pwd = mailconfig.getSmtp_password();
//				String from = mailconfig.getMail_from();
//				// 创建Properties对象
//				Properties props = System.getProperties();
//				// 创建信件服务器
//				props.put("mail.smtp.auth", "true");
//				//设置超时时间
//				props.put("mail.smtp.connectiontimeout", "10000"); //
//				props.put("mail.smtp.timeout", "10000");   // 
//				// 得到默认的对话对象
//				Session session = Session.getDefaultInstance(props, null);
//
//				// 创建一个消息，并初始化该消息的各项元素
//				Message msg = new MimeMessage(session);
//				msg.setFrom(new InternetAddress(from));
//				InternetAddress[] address = { new InternetAddress(emailReceiver) };
//				msg.setRecipients(Message.RecipientType.TO, address);
//				msg.setSubject(MimeUtility.encodeText(subject, "GBK", "B"));
//				
//				// 后面的BodyPart将加入到此处创建的Multipart中
//				Multipart mp = new MimeMultipart();
//				// 设置内容
//				BodyPart bp = new MimeBodyPart();
//				bp.setContent(htmlContents + getMailCorpright(),
//						"text/html;charset=gbk");
//				mp.addBodyPart(bp);
//				// Multipart加入到信件
//				msg.setContent(mp);
//				// 设置信件头的发送日期
//				msg.setSentDate(new Date());
//				msg.saveChanges();
//
//				// 发送信件
//				Transport trans = session.getTransport("smtp");
//				trans.connect(serverAddress, userName, pwd);
//
//				if (trans.isConnected()) {
//					trans.sendMessage(msg, msg.getAllRecipients());
//					trans.close();
//					return true;
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
		return false;
	}

	public static String getMailCorpright() {
		String mailCorpright = "";
		return mailCorpright;
	}
}
