package onlineshop.bill;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import junit.framework.Assert;
import onlineshop.bill.client.MessageClient;
public class MessageClientTest {
	@InjectMocks
	MessageClient mgc;
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
		Mockito.when(factory.newConnection()).thenReturn(connection);
		Mockito.when(connection.createChannel()).thenReturn(channel);
		Mockito.when(channel.queueDeclare(q, false, false, false, null)).thenReturn(ok);
		doNothing().when(channel).basicPublish("", q, null, message.getBytes());

		Mockito.when(channel.basicConsume(q, true, consumer)).thenReturn("test");

		Mockito.when(consumer.nextDelivery()).thenReturn(dy);

		Mockito.when(dy.getBody()).thenReturn(msg.getBytes());
		mgc.send(q, msg);
		Assert.assertEquals(mgc.recv(q), msg);

	}

}



