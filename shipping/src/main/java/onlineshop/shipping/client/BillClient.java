package onlineshop.shipping.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import onlineshop.shipping.models.Bill;
import onlineshop.shipping.models.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class BillClient {
	private static final Logger logger = LoggerFactory.getLogger(CustomerClient.class);
	
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
    public Bill getById(int billId){
		
		
		List<ServiceInstance> instances = discoveryClient.getInstances("bill");
		logger.info("discovery bill returned size is {}", instances.size());
		String serviceIp = instances.get(0).getHost();
		int servicePort = instances.get(0).getPort();
		for (ServiceInstance instance:instances) {
			logger.info("bill service is {}, host is {}", instance.getServiceId(), instance.getHost());
		}
		RestTemplate restTemplate= new RestTemplate();
		Bill[] bs = restTemplate.getForObject("http://"+serviceIp+":"+servicePort+"/bill/list", Bill[].class);
		return Arrays.asList(bs).stream().filter(c->c.getId()==billId).collect(Collectors.toList()).get(0);		
	}
}
