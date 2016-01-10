package onlineshop.bill.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bill")
public class Bill {
	public Bill(int orderId,int customerId, float balance) {
		
		this.customerId = customerId;
		this.balance = balance;
		this.orderId=orderId;
	}
        
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int orderId;
	private int customerId;
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
	public int getCustomerId() {
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
