package onlineshop.shipping.client;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class MessageClient {
	public final static String ORDER_QUEUE_NAME = "orderq";
	public final static String SHIPPING_QUEUE_NAME = "shippingq";
	
	private static final Logger logger = LoggerFactory.getLogger(MessageClient.class);

	public void send(String q,String msg){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.99.100");
		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(q, false, false, false, null);
			String message = msg;
			channel.basicPublish("", q, null, message.getBytes());
			logger.info(" [x] Sent '" + message + "'");

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			logger.error("go into exception");
		} 
		finally{
			try {
				if (channel !=null){
				channel.close();
				connection.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public String recv(String q) throws Exception{
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("192.168.99.100");
			Connection connection = null;
			Channel channel = null;
			try {
				connection = factory.newConnection();
				channel = connection.createChannel();
				channel.queueDeclare(q, false, false, false, null);
				logger.info(" [*] Waiting for messages. ");

				QueueingConsumer consumer = new QueueingConsumer(channel);
				channel.basicConsume(q, true, consumer);

				while (true) {
					QueueingConsumer.Delivery delivery = consumer.nextDelivery();
					String message = new String(delivery.getBody());
					logger.info(" [x] Received '" + message + "'");
					return message;
				}

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				logger.error("go into exception");
				throw ex;
			} 
			finally{
				try {
					if (channel !=null){
					channel.close();
					connection.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
}
