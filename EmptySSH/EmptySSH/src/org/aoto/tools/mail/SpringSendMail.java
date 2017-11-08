package org.aoto.tools.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SpringSendMail {
	
//	���巢���˶�����ʼ�������������
private JavaMailSenderImpl mailSender;
private MimeMessageHelper messageHelper;
//<end>���巢���˶�����ʼ�������������

//��ʼ�������˶������Ʒ�������Ϣ
public SpringSendMail() {
	mailSender = new JavaMailSenderImpl();
	mailSender.setDefaultEncoding("utf-8");
	mailSender.setHost("smtp.qq.com");
	mailSender.setUsername("zhaodehua@jasgroup.cn");
	mailSender.setPassword("612526zhao");
}//<end>��ʼ�������˶������Ʒ�������Ϣ

//�����ʼ�
public void sendMail(){
	//�����ʼ�����
	MimeMessage message = mailSender.createMimeMessage();
	//<end>�����ʼ�����
	try {
		//ʹ���ʼ������������������ʼ�����
		//�����ʼ�ͷ����
		messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setFrom(mailSender.getUsername());
		messageHelper.setTo("1623960646@qq.com");
		messageHelper.setSubject("Spring�ʼ����͡�����");
		//<end>�����ʼ�ͷ����
		
		//�����ʼ���
		messageHelper.setText(""
				+ "<a href='http://www.w3school.com.cn'>"
				   + "<h1>�ʼ�����ѧϰ��</h1>"
				+ "</a>"
				+ "<img src='cid:456.jpg'>"
				+ "<table>"
				   + "<tr>"
				   + "<th>����</th>"
				   + "<th>����</th>"
				   + "<th>�Ա�</th>"
				   + "</tr>"
				   + "<tr>"
				   + "<th>����</th>"
				   + "<th>123123</th>"
				   + "<th>Ů</th>"
				   + "</tr>"
				+ "</table>"
				, true);
		DataSource ds2 = new FileDataSource("C:/456.jpg");
		messageHelper.addInline("456.jpg", ds2);//��ǶͼƬ�����һ��������Ӧ�ʼ��ı��е�cid
		DataSource ds = new FileDataSource("C:/111.txt");
		messageHelper.addAttachment("111.txt", ds);//����Ƭ����
		//<end>�����ʼ���
		//<end>ʹ���ʼ������������������ʼ�����
		
		mailSender.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}//<end>�����ʼ�





}
