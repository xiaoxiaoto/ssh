package org.aoto.tools.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.MimeMessage.RecipientType;

public class JavaMail {
//	javaMail邮件发送
	public void sendMail()  {
		//	定义session所需属性：如验证规则，使用协议等等	
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
        //定义session所需属性：如验证规则，使用协议等等
		
		//创建session对象：作用是为邮件对象提供服务
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		//创建session对象：作用是为邮件对象提供服务
		
		//创建邮件对象并对邮件内容进行描述
		Message mess = new MimeMessage(session);
		try {
			//定义邮件头信息
			mess.setFrom(new InternetAddress(MimeUtility.encodeText("赵德华", "utf-8", null)+"<zhaodehua@jasgroup.cn>"));
			mess.setSubject("问个好！");
			mess.setRecipients(RecipientType.TO, InternetAddress.parse(MimeUtility.encodeText("赵德华QQ", "utf-8", null)+"<1623960646@qq.com>"));
			//定义邮件头信息
			
			//定义邮件体和附件
			MimeMultipart messMultipart = new MimeMultipart("mixed");//整个邮件的类型“混合体类型”
			
			//定义邮件附加附件
			MimeBodyPart attch1 = new MimeBodyPart();
			DataSource ds1 = new FileDataSource("C:/111.txt");
			DataHandler dh1 = new DataHandler(ds1);
			attch1.setDataHandler(dh1);
			attch1.setFileName(MimeUtility.decodeText("111.txt"));
			
			MimeBodyPart attch2 = new MimeBodyPart();
			DataSource ds2 = new FileDataSource("C:/123.docx");
			DataHandler dh2 = new DataHandler(ds2);
			attch2.setDataHandler(dh2);
			attch2.setFileName(MimeUtility.decodeText("123.docx"));
			//定义邮件附加附件
			
			//定义邮件主题内容
			MimeBodyPart content = new MimeBodyPart();//因为邮件主题又是富文本：即包含有内嵌图片
			MimeMultipart bodyMultipart = new MimeMultipart("related");//邮件体的类型是“依赖类型”：即内嵌图片需依赖邮件主体而存在
			//定义邮件的文本（HTML样式）
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(""
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
					, "text/html;charset=gbk");
			//<end>定义邮件的文本（HTML样式）
			
			//定义内嵌图片
			MimeBodyPart gifPart = new MimeBodyPart();
			DataSource ds3 = new FileDataSource("C:/456.jpg");
			DataHandler dh3 = new DataHandler(ds3);
			gifPart.setDataHandler(dh3);
			gifPart.setContentID("456.jpg");//这里的参数值为邮件文本中的cid
			//<end>定义内嵌图片
			
			//整合邮件内容
			bodyMultipart.addBodyPart(htmlPart);
			bodyMultipart.addBodyPart(gifPart);
			content.setContent(bodyMultipart);
			//<end>整合邮件内容
			//<end>定义邮件主体内容
			
			messMultipart.addBodyPart(attch1);
			messMultipart.addBodyPart(attch2);
			messMultipart.addBodyPart(content);
			mess.setContent(messMultipart);
			//<end>定义邮件体和附件
			
			mess.saveChanges();
			
			//<end>创建邮件对象并对邮件内容进行描述
			Transport transport = session.getTransport();
			transport.connect("smtp.qq.com", "zhaodehua@jasgroup.cn",
					"612526zhao");
				transport.sendMessage(mess, new Address[] { new InternetAddress(
						"1623960646@qq.com") });
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//<end>	javaMail邮件发送

}
