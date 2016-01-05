package onlineshop.order;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import junit.framework.Assert;
import onlineshop.order.controllers.OrderController;
import onlineshop.order.models.Item;
import onlineshop.order.models.Order;
import onlineshop.order.models.OrderLine;
import onlineshop.order.models.Orderdao;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class OrderTest {

	@InjectMocks
	OrderController oc;
	@Mock
	Orderdao od;
	
	
	

	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
		
	}


	@Test
	public void testOderList() {
		List<OrderLine> ito= new ArrayList<OrderLine>();
		ito.addAll(new Order(100, 100, 2));
		
		Mockito.when(od.getAll()).thenReturn(ito);
		
	}
	@Test
	public void testAddOder() {
	Order o = new Order(101,101,3);
	doNothing().when(od).save(o);
	Assert.assertEquals(oc.create(101, 101, 3), "order succesfully created");
	}
}
