package onlineshop.order.client;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import onlineshop.order.controllers.OrderController;
import onlineshop.order.models.*;

@Service
public class ItemClient {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	public List<Item> getAll(){
		RestTemplate restTemplate = new RestTemplate();
		Item[] it = restTemplate.getForObject("http://localhost:8082/item/list", Item[].class);
		logger.info("item/list");
		for (Item i:it)
			logger.info(i.toString());
		return Arrays.asList(it);

	}
	public Item getByName(String name){
		RestTemplate restTemplate = new RestTemplate();
		Item it = restTemplate.getForObject("http://localhost:8082/item/list", Item.class);
		logger.info("item/getbyname");
		logger.info(it.toString());
		return it;
	}
	
	public Item getById(long id){
		RestTemplate restTemplate = new RestTemplate();
		Item[] it = restTemplate.getForObject("http://localhost:8082/item/list", Item[].class);
		return Arrays.asList(it).stream().filter(c->c.getId()==id).collect(Collectors.toList()).get(0);		
	}
}
