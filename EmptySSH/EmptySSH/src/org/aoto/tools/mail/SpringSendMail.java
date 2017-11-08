package org.aoto.tools.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SpringSendMail {
	
//	定义发件人对象和邮件辅助操作对象
private JavaMailSenderImpl mailSender;
private MimeMessageHelper messageHelper;
//<end>定义发件人对象和邮件辅助操作对象

//初始化发件人对象即完善发件人信息
public SpringSendMail() {
	mailSender = new JavaMailSenderImpl();
	mailSender.setDefaultEncoding("utf-8");
	mailSender.setHost("smtp.qq.com");
	mailSender.setUsername("zhaodehua@jasgroup.cn");
	mailSender.setPassword("612526zhao");
}//<end>初始化发件人对象即完善发件人信息

//发送邮件
public void sendMail(){
	//定义邮件对象
	MimeMessage message = mailSender.createMimeMessage();
	//<end>定义邮件对象
	try {
		//使用邮件操作辅助对象描述邮件内容
		//完善邮件头内容
		messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setFrom(mailSender.getUsername());
		messageHelper.setTo("1623960646@qq.com");
		messageHelper.setSubject("Spring邮件发送。。。");
		//<end>完善邮件头内容
		
		//描述邮件体
		messageHelper.setText(""
				+ "<a href='http://www.w3school.com.cn'>"
				   + "<h1>邮件开发学习！</h1>"
				+ "</a>"
				+ "<img src='cid:456.jpg'>"
				+ "<table>"
				   + "<tr>"
				   + "<th>姓名</th>"
				   + "<th>密码</th>"
				   + "<th>性别</th>"
				   + "</tr>"
				   + "<tr>"
				   + "<th>张萌</th>"
				   + "<th>123123</th>"
				   + "<th>女</th>"
				   + "</tr>"
				+ "</table>"
				, true);
		DataSource ds2 = new FileDataSource("C:/456.jpg");
		messageHelper.addInline("456.jpg", ds2);//内嵌图片定义第一个参数对应邮件文本中的cid
		DataSource ds = new FileDataSource("C:/111.txt");
		messageHelper.addAttachment("111.txt", ds);//附件片定义
		//<end>描述邮件体
		//<end>使用邮件操作辅助对象描述邮件内容
		
		mailSender.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}//<end>发送邮件





}
