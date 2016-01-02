package onlineshop.order.client;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import onlineshop.order.controllers.OrderController;
import onlineshop.order.models.*;

public class CustomerClient {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	public List<Customer> getAll(){
		RestTemplate restTemplate = new RestTemplate();
	     
		Customer[] cs = restTemplate.getForObject("http://localhost:8080/customer/list", Customer[].class);
	     logger.info("item/list");
	     for (Customer i:cs)
	     	logger.info(i.toString());
	     return Arrays.asList(cs);
	}
	public Customer getByName(String name){
		RestTemplate restTemplate = new RestTemplate();
	     Customer cs = restTemplate.getForObject("http://localhost:8080/customer/getbyname", Customer.class);
	     logger.info("order/list/getbyname");
	     logger.info(cs.toString());
	     return cs;
		
	}

}
