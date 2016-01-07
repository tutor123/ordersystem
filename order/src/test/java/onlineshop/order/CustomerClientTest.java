package onlineshop.order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;
import onlineshop.order.client.CustomerClient;
import onlineshop.order.models.Customer;
public class CustomerClientTest {
	@InjectMocks
	CustomerClient cc;
	@Mock
	RestTemplate rt;


@Mock
DiscoveryClient discoveryClient;
@Mock
ServiceInstance mockInstance;
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testCustomerClientGetAll() {
		     
		Customer[] cs = new Customer[1];
		Mockito.when(rt.getForObject("http://localhost:8080/customer/list", Customer[].class)).thenReturn(cs);
		List<ServiceInstance> instances =new ArrayList<ServiceInstance>();
		instances.add(mockInstance);
		Mockito.when(discoveryClient.getInstances("customer")).thenReturn(instances);
		Mockito.when(mockInstance.getServiceId()).thenReturn("customer");
		Mockito.when(mockInstance.getHost()).thenReturn("localhost");
		Mockito.when(mockInstance.getPort()).thenReturn(8080);

	   Assert.assertEquals(cc.getAll().size(), cs.length);
	}
	@Test
	public void testCustomerClientGetByName() {
		     
		 Customer cs = new Customer("test");
		Mockito.when(rt.getForObject("http://localhost:8080/customer/getbyname", Customer.class)).thenReturn(cs);
	   Assert.assertEquals(cc.getByName("test").getName(), "test");
	}

}
