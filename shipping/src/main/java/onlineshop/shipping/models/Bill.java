package onlineshop.shipping.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bill")
public class Bill {
	public Bill() {
		super();
	}
	public Bill(int orderId,long customerId, float balance) {
		
		this.customerId = customerId;
		this.balance = balance;
		this.orderId=orderId;
	}
        
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int orderId;
	private long customerId;
	private float balance;
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
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
}
