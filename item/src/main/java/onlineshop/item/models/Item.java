package onlineshop.item.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private float price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}
	public void addItem(String name, float price){
		this.name=name;
		this.price=price;
		
	}
	public Item(String name, float price) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.price=price;
	}
}
