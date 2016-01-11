package onlineshop.bill.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import onlineshop.bill.models.Order;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class OrderClient {
	private static final Logger logger = LoggerFactory.getLogger(OrderClient.class);

	 RestTemplate restTemplate = new RestTemplate();;

	@Autowired
	private DiscoveryClient discoveryClient;
	public Order getById(long id){
		List<ServiceInstance> instances = discoveryClient.getInstances("item");
		String serviceIp = instances.get(0).getHost();
		int servicePort = instances.get(0).getPort();
		for (ServiceInstance instance:instances) {
			logger.info("order service is {},order host is {}", instance.getServiceId(), instance.getHost());
		}
		Order[] o = restTemplate.getForObject("http://"+serviceIp+":"+servicePort+"/order/list", Order[].class);
		return Arrays.asList(o).stream().filter(c->c.getId()==id).collect(Collectors.toList()).get(0);	
		
	}
}
