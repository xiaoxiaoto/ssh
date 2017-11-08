package org.aoto.activemq.web.contriller;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SendMessages {
	@Resource(name="jmsQueueTemplate")
	private JmsTemplate jmsQueueTemplate;
	@RequestMapping(value="jmsSendMessage")
	public void send(){
			
		jmsQueueTemplate.send(new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
//			MapMessage message = session.createMapMessage();
//				message.setString("zao", "shang");
				TextMessage message = session.createTextMessage();
				message.setText("zao");
				
				return message;
			}
			
		});
		System.out.println("发送消息成功！");
	}
	
	

	public JmsTemplate getJmsQueueTemplate() {
		return jmsQueueTemplate;
	}

	public void setJmsQueueTemplate(JmsTemplate jmsQueueTemplate) {
		this.jmsQueueTemplate = jmsQueueTemplate;
	}
}
