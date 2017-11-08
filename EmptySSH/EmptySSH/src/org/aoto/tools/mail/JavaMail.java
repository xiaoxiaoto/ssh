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
//	javaMail�ʼ�����
	public void sendMail()  {
		//	����session�������ԣ�����֤����ʹ��Э��ȵ�	
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
        //����session�������ԣ�����֤����ʹ��Э��ȵ�
		
		//����session����������Ϊ�ʼ������ṩ����
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		//����session����������Ϊ�ʼ������ṩ����
		
		//�����ʼ����󲢶��ʼ����ݽ�������
		Message mess = new MimeMessage(session);
		try {
			//�����ʼ�ͷ��Ϣ
			mess.setFrom(new InternetAddress(MimeUtility.encodeText("�Ե»�", "utf-8", null)+"<zhaodehua@jasgroup.cn>"));
			mess.setSubject("�ʸ��ã�");
			mess.setRecipients(RecipientType.TO, InternetAddress.parse(MimeUtility.encodeText("�Ե»�QQ", "utf-8", null)+"<1623960646@qq.com>"));
			//�����ʼ�ͷ��Ϣ
			
			//�����ʼ���͸���
			MimeMultipart messMultipart = new MimeMultipart("mixed");//�����ʼ������͡���������͡�
			
			//�����ʼ����Ӹ���
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
			//�����ʼ����Ӹ���
			
			//�����ʼ���������
			MimeBodyPart content = new MimeBodyPart();//��Ϊ�ʼ��������Ǹ��ı�������������ǶͼƬ
			MimeMultipart bodyMultipart = new MimeMultipart("related");//�ʼ���������ǡ��������͡�������ǶͼƬ�������ʼ����������
			//�����ʼ����ı���HTML��ʽ��
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(""
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
					, "text/html;charset=gbk");
			//<end>�����ʼ����ı���HTML��ʽ��
			
			//������ǶͼƬ
			MimeBodyPart gifPart = new MimeBodyPart();
			DataSource ds3 = new FileDataSource("C:/456.jpg");
			DataHandler dh3 = new DataHandler(ds3);
			gifPart.setDataHandler(dh3);
			gifPart.setContentID("456.jpg");//����Ĳ���ֵΪ�ʼ��ı��е�cid
			//<end>������ǶͼƬ
			
			//�����ʼ�����
			bodyMultipart.addBodyPart(htmlPart);
			bodyMultipart.addBodyPart(gifPart);
			content.setContent(bodyMultipart);
			//<end>�����ʼ�����
			//<end>�����ʼ���������
			
			messMultipart.addBodyPart(attch1);
			messMultipart.addBodyPart(attch2);
			messMultipart.addBodyPart(content);
			mess.setContent(messMultipart);
			//<end>�����ʼ���͸���
			
			mess.saveChanges();
			
			//<end>�����ʼ����󲢶��ʼ����ݽ�������
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
	}//<end>	javaMail�ʼ�����

}
