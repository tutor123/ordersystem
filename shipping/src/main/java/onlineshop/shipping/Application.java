package onlineshop.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import onlineshop.shipping.models.ShippingService;



@SpringBootApplication
@EnableDiscoveryClient

public class Application {
	 public static void main(String[] args) throws InterruptedException{
		 
		    ApplicationContext applicationContext = SpringApplication.run( Application.class,args);
	    	ShippingService ss = (ShippingService)applicationContext.getBean(ShippingService.class);
	    	ss.start();
		  }

}

   
