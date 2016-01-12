package onlineshop.shipping.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import onlineshop.shipping.client.BillClient;
import onlineshop.shipping.client.CustomerClient;
import onlineshop.shipping.client.MessageClient;



@Component
public class ShippingService extends Thread{
	private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);


	@Autowired
	private MessageClient mgc;
	@Autowired
	private CustomerClient cc;
	@Autowired
	private BillClient bc;
	@Autowired
	private ShippingDao sd;

	public ShippingService() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ShippingService running");
		while(true){
			try {

				String msg=mgc.recv(MessageClient.SHIPPING_QUEUE_NAME);
				if (msg.startsWith("Bill accepted:"))
				{
					String id=msg.substring(msg.lastIndexOf(':')+1);
					logger.info("recv bill event,bill id {}",id);
					logger.info("Start shipping");
					logger.info("debug print bill id{}",Integer.parseInt(id));
					Bill b = bc.getById(Integer.parseInt(id));
					long cid = b.getCustomerId();
					Customer customer = cc.getById(cid);
					logger.info("customer id is {}",cid);
					String addr = customer.getStreet()+","+customer.getCity();
					logger.info("customer addr is {}",addr);
					ShippingRecord src= new ShippingRecord(Integer.parseInt(id),cid,addr);
					sd.save(src);
					logger.info("shiping record created");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
