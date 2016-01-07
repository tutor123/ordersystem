package onlineshop.order.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	
	@Autowired
	 RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;
	public List<Item> getAll(){
		List<ServiceInstance> instances = discoveryClient.getInstances("item");
		logger.info("discovery client returned size is {}", instances.size());
		String serviceIp = instances.get(0).getHost();
		int servicePort = instances.get(0).getPort();
		for (ServiceInstance instance:instances) {
			logger.info("service is {}, host is {}", instance.getServiceId(), instance.getHost());
		}
		Item[] it = restTemplate.getForObject("http://"+serviceIp+":"+servicePort+"/item/list", Item[].class);
		return Arrays.asList(it);

	}
	public Item getByName(String name){
		// RestTemplate restTemplate = new RestTemplate();
		Item it = restTemplate.getForObject("http://localhost:8082/item/list", Item.class);
				return it;
	}
	
	public Item getById(long id){
		Item[] it = restTemplate.getForObject("http://localhost:8082/item/list", Item[].class);
		return Arrays.asList(it).stream().filter(c->c.getId()==id).collect(Collectors.toList()).get(0);		
	}
}
