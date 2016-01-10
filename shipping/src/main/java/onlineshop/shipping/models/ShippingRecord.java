package onlineshop.shipping.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipping")
public class ShippingRecord {
	public ShippingRecord(int orderId, long customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}
	public ShippingRecord(int orderId,long customerId, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerAddress = customerAddress;
	}
	public ShippingRecord(int orderId) {
		super();
		this.orderId = orderId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	private int orderId;
	private long customerId;
	private String customerAddress;
}
