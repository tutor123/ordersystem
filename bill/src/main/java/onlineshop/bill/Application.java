package onlineshop.bill;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import onlineshop.bill.models.BillService;



@SpringBootApplication
@EnableDiscoveryClient

public class Application
{
    public static void main( String[] args ) throws InterruptedException
    {
    	ApplicationContext applicationContext = SpringApplication.run( Application.class,args);
    	BillService bs = (BillService)applicationContext.getBean(BillService.class);
    	bs.start();
    }
}
