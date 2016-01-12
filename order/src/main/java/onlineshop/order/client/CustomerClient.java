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
public class CustomerClient {
	private static final Logger logger = LoggerFactory.getLogger(CustomerClient.class);
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public List<Customer> getAll(){
		//RestTemplate restTemplate = new RestTemplate();
	     
		Customer[] cs = restTemplate.getForObject("http://localhost:8080/customer/list", Customer[].class);
	    
	     return Arrays.asList(cs);
	}
	public Customer getByName(String name){
		//RestTemplate restTemplate = new RestTemplate();
	     Customer cs = restTemplate.getForObject("http://localhost:8080/customer/getbyname", Customer.class);
	     //logger.info("order/list/getbyname");
	     //logger.info(cs.toString());
	     return cs;
		
	}
	
	public Customer getById(long id){
		
		
		List<ServiceInstance> instances = discoveryClient.getInstances("customer");
		logger.info("discovery client returned size is {}", instances.size());
		String serviceIp = instances.get(0).getHost();
		int servicePort = instances.get(0).getPort();
		for (ServiceInstance instance:instances) {
			logger.info("service is {}, host is {}", instance.getServiceId(), instance.getHost());
		}
		
		
		RestTemplate restTemplate = new RestTemplate();
		Customer[] cs = restTemplate.getForObject("http://"+serviceIp+":"+servicePort+"/customer/list", Customer[].class);
		return Arrays.asList(cs).stream().filter(c->c.getId()==id).collect(Collectors.toList()).get(0);		
	}

}
