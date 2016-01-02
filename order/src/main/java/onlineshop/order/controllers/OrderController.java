package onlineshop.order.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import onlineshop.order.client.CustomerClient;
import onlineshop.order.client.ItemClient;
import onlineshop.order.models.Customer;
import onlineshop.order.models.Order;
import onlineshop.order.models.Orderdao;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	
	@Autowired
    private Orderdao od;
	
	
	private CustomerClient cc = new CustomerClient();
	
	//@Autowired
	private ItemClient ic = new ItemClient();

	
	@RequestMapping(value="/order/create")
	  @ResponseBody
	 
	  public String create(long customerId, long itemId, int count) {
	    try {
	    	 logger.info("enter order");
	      Order o = new Order(customerId, itemId, count);
	      logger.info("enter order 2");
	      od.save(o);
	    }
	    catch (Exception ex) {
	      return "Error creating the order: " + ex.toString();
	    }
	    return "order succesfully created!";
	  }
	
	
	@RequestMapping(value="/order/addOrderLine")
	  @ResponseBody
	  public String addOrderLine(long id, long itemId, int count) {
	    try {
	      Orderdao od = new Orderdao();
	      Order o = new Order();
	      od.save(o);
	    }
	    catch (Exception ex) {
	      return "Error creating the order: " + ex.toString();
	    }
	    return "order succesfully created!";
	  }
	
	@RequestMapping(value="/oreder/delete/")
	@ResponseBody
	public String delete(long id){
		try{
			Orderdao od = new Orderdao();
			Order o = new Order();
			od.delete(o);
		}
		catch(Exception ex){
			return "fail to delete order:"+ex.toString();
		}
		return "order delete success!!";
	}
	@RequestMapping(value="/order/list")
	@ResponseBody
	public String list(Order o){
		String result = "";
		try{
			List<Customer> cs = cc.getAll();
			for (Customer c:cs)
			{
				result = result.concat(c.getName()).concat(",");
			}
			logger.info("order list is " + result);
		}
		catch(Exception ex){
			return "fail to list order:"+ex.toString();
		}
		return result;
	}
}
