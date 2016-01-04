package onlineshop.customer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import static org.mockito.Mockito.*;


import onlineshop.customer.controllers.CustomerController;
import onlineshop.customer.models.CustomerDao;
import onlineshop.customer.models.Customer;

public class CustomerControllerTest {
	@InjectMocks
	private CustomerController ctlr;
	
	
	@Mock
	private CustomerDao dao;
	
	@Before 
	public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void testListCustomerController(){
		List<Customer> cs = new ArrayList<Customer>();
		cs.add(new Customer("test", "test@gg.com"));
		//mock the dao instance to return mocked customers when "getAll()" get called.
		Mockito.when(dao.getAll()).thenReturn(cs);
		
		Assert.assertEquals(ctlr.getAll().size(), cs.size());
	}
	
	@Test
    public void testAddCustomerController(){
		Customer c = new Customer("test", "test@gg.com");
		//mock the dao instance to do nothing when "create()" get called.
		doNothing().when(dao).save(c);
		
		Assert.assertEquals(ctlr.create("test", "test@gg.com"), "User succesfully created!");
	}
}
