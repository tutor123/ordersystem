package onlineshop.order.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long customerId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> items = new ArrayList<OrderLine>();
	
	public void addItem(long itemId, int count) {
		OrderLine ol = new OrderLine();
		ol.setItemId(itemId);
		ol.setCount(count);
		this.items.add(ol);
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(long customerId,long itemId, int count) {
		// TODO Auto-generated constructor stub
		this.customerId=customerId;
		
		addItem(itemId,count);
	}
}
