package onlineshop.shipping.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.servlet.ModelAndView;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;


import onlineshop.shipping.models.ShippingDao;
import onlineshop.shipping.models.ShippingRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class ShippingController {
	private static final Logger logger = LoggerFactory.getLogger(ShippingController.class);
	@Autowired
	private ShippingDao sd;
	
	@RequestMapping(value="/shipping/add")
	@ResponseBody
	public String create(int orderId,long customerId,String customerAddress ) {

		try {
			ShippingRecord shipRd = new ShippingRecord(orderId,customerId, customerAddress);
			sd.save(shipRd);
		}
		catch (Exception ex) {
			return "Error creating the shipping: " + ex.toString();
		}
		return "Shipping succesfully created!";
	}

}
