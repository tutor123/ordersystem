package onlineshop.bill.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import onlineshop.bill.models.Bill;
import onlineshop.bill.models.BillDao;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class BillController {
	private static final Logger logger = LoggerFactory.getLogger(BillController.class);

	
	  
	@Autowired
	private BillDao bd;
	@RequestMapping(value="/bill/add")
	  @ResponseBody
	  public String create(int orderId,int customerId, float balance) {
		    try {
		      Bill bl = new Bill(orderId, customerId,balance);
		      bd.save(bl);
		    }
		    catch (Exception ex) {
		      return "Error creating the order: " + ex.toString();
		    }
		    return "Order succesfully created!";
		  }
	@RequestMapping(value="/bill/list")
	  @ResponseBody
	  public List<Bill> getAll() {
			logger.info("enter getAll");
			return bd.getAll();
	}   
	
}
