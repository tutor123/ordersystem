package onlineshop.bill.models;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import onlineshop.bill.client.CustomerClient;
import onlineshop.bill.client.ItemClient;
import onlineshop.bill.client.OrderClient;

public class BillService {
	private static final Logger logger = LoggerFactory.getLogger(BillService.class);

	private OrderClient oc;

	private ItemClient ic;
	private CustomerClient cc;
	
	public float calculateTotalPrice(int orderId){
		float total=0;
		Order o = oc.getById(orderId);
		List<OrderLine> its=o.getItems();
		for(OrderLine it:its){
			
			long id=it.getItemId();
			total=ic.getById(id).getPrice();
			total=total*it.getCount();
		}
		
		return total;
	} 
	public boolean checkBalance(int orderId){
		
		long cid=oc.getById(orderId).getCustomerId();
		Customer c = cc.getById(cid);
		if ( c.getBalance()>=this.calculateTotalPrice(orderId))
		{
			logger.info("enough balance");
			return true;
			
		}
		logger.info("need to add more balance");
		return false;
		
		
	}
}
