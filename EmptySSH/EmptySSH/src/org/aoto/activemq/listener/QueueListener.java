package org.aoto.activemq.listener;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

public class QueueListener implements MessageListener {

	
	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage){
			TextMessage textMsg = (TextMessage) message;
			 System.out.println("接收到一个纯文本消息。");   
				try {
					System.out.println("消息内容是：" + textMsg.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
		}else if(message instanceof MapMessage){
			MapMessage mapMsg= (MapMessage)message;
			System.out.println("接收到一个Map消息。");  
			try {
				System.out.println("消息内容是：" + mapMsg.getString("zao"));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}else if(message instanceof BytesMessage){
			
		}else if(message instanceof StreamMessage){
			
		}else{
			//ObjectMessage
		}			 
	}
}
