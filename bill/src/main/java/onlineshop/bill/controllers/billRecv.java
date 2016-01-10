package onlineshop.bill.controllers;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.QueueingConsumer;

public class billRecv {
	private final static String QUEUE_NAME = "hello";
	/*public static void main(String[] argv) throws Exception {
		

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
	
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
		}
		}*/
}
