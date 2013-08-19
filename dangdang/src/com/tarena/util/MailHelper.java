package com.tarena.util;



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
 * ���������͵����ʼ��İ�����
 */
public class MailHelper {

	public MailHelper() {
	}
	
	public static void main(String[] args) {
		MailHelper.sendMail("mail.beijing-sports.com", "guojianchao@beijing-sports.com", "bst_2013", "guojianchao@beijing-sports.com", "837776282@qq.com", "fjc", "��д���ʼ����ˣ�");
	}
	public static boolean sendMail(String emailReceiver,String htmlContents){
		boolean flag=false;
		try {
			MailHelper.sendMail("smtp.163.com", "LibraryNetwork@163.com", "LibraryNetwor", "LibraryNetwork@163.com", emailReceiver, "图书网验证码", htmlContents);

			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean sendMail(String serverAddress, String user,
			String pwd, String from, String emailReceiver, String subject,
			String htmlContents) {

		try {
			// ����Properties����
			Properties props = System.getProperties();
			// �����ż�������
			props.put("mail.smtp.auth", "true");
			//���ó�ʱʱ��
			props.put("mail.smtp.connectiontimeout", "10000"); //
			props.put("mail.smtp.timeout", "10000");   // 
			// �õ�Ĭ�ϵĶԻ�����
			Session session = Session.getDefaultInstance(props, null);

			// ����һ����Ϣ������ʼ������Ϣ�ĸ���Ԫ��
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(emailReceiver) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);

			// �����BodyPart�����뵽�˴�������Multipart��
			Multipart mp = new MimeMultipart();
			// ��������
			BodyPart bp = new MimeBodyPart();
			bp.setContent(htmlContents + getMailCorpright(),
					"text/html;charset=gbk");
			mp.addBodyPart(bp);
			// Multipart���뵽�ż�
			msg.setContent(mp);
			// �����ż�ͷ�ķ�������
			msg.setSentDate(new Date());
			msg.saveChanges();

			// �����ż�
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
 * ֻ�ô������ʼ���ַ���ʼ����⣬�ʼ����ݾͷ����ʼ���
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
//				// ����Properties����
//				Properties props = System.getProperties();
//				// �����ż�������
//				props.put("mail.smtp.auth", "true");
//				//���ó�ʱʱ��
//				props.put("mail.smtp.connectiontimeout", "10000"); //
//				props.put("mail.smtp.timeout", "10000");   // 
//				// �õ�Ĭ�ϵĶԻ�����
//				Session session = Session.getDefaultInstance(props, null);
//
//				// ����һ����Ϣ������ʼ������Ϣ�ĸ���Ԫ��
//				Message msg = new MimeMessage(session);
//				msg.setFrom(new InternetAddress(from));
//				InternetAddress[] address = { new InternetAddress(emailReceiver) };
//				msg.setRecipients(Message.RecipientType.TO, address);
//				msg.setSubject(MimeUtility.encodeText(subject, "GBK", "B"));
//				
//				// �����BodyPart�����뵽�˴�������Multipart��
//				Multipart mp = new MimeMultipart();
//				// ��������
//				BodyPart bp = new MimeBodyPart();
//				bp.setContent(htmlContents + getMailCorpright(),
//						"text/html;charset=gbk");
//				mp.addBodyPart(bp);
//				// Multipart���뵽�ż�
//				msg.setContent(mp);
//				// �����ż�ͷ�ķ�������
//				msg.setSentDate(new Date());
//				msg.saveChanges();
//
//				// �����ż�
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
