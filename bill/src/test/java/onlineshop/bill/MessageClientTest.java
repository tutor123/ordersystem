package onlineshop.bill;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import junit.framework.Assert;
import onlineshop.bill.client.MessageClient;
public class MessageClientTest {
	
	MessageClient mgc = spy(new MessageClient());
	@Mock
	ConnectionFactory factory;
	@Mock		
	Channel channel;
	@Mock
	Connection connection;
	@Mock
	DeclareOk ok;
	@Mock
	QueueingConsumer consumer;
	@Mock 
	QueueingConsumer.Delivery dy;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testSendRecv() throws Exception {

		String q="testq";
		String msg="test";
		String message = msg;
		//channel.basicPublish("", q, null, message.getBytes());
		doReturn(factory).when(mgc).makeConnectionFactory();
		doReturn(consumer).when(mgc).makeQueueingConsumer(channel);
		Mockito.when(factory.newConnection()).thenReturn(connection);
		Mockito.when(connection.createChannel()).thenReturn(channel);
		Mockito.when(channel.queueDeclare(q, false, false, false, null)).thenReturn(ok);
		doNothing().when(channel).basicPublish("", q, null, message.getBytes());

		Mockito.when(channel.basicConsume(q, true, consumer)).thenReturn("");

		Mockito.when(consumer.nextDelivery()).thenReturn(dy);

		Mockito.when(dy.getBody()).thenReturn(msg.getBytes());
		mgc.send(q, msg);
		Assert.assertEquals(mgc.recv(q), "test");
	}

}



