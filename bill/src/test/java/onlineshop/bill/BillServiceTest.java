package onlineshop.bill;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import onlineshop.bill.client.CustomerClient;
import onlineshop.bill.client.ItemClient;
import onlineshop.bill.client.OrderClient;
import onlineshop.bill.models.BillDao;
import onlineshop.bill.models.BillService;

import static org.mockito.Mockito.*;




	
	
public class BillServiceTest {
	@InjectMocks
	private BillService bs;
	
	
	@Mock
	private CustomerClient cc;
	@Mock
	private ItemClient ic;
	@Mock
	private OrderClient oc;
	@Mock
	private BillDao bd;
	
	@Before 
	public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
	
	

	@Test
	public void testProcessBill() {
		
	}

}
