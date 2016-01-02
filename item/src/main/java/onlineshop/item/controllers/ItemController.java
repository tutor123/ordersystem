package onlineshop.item.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import onlineshop.item.models.Item;
import onlineshop.item.models.Itemdao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	  @Autowired
	  private Itemdao itemdao;
	  private Item i;
	
	 
	@RequestMapping(value="/item/add")
	  @ResponseBody
	  public String addItem( String name,float price) {
	    try {
	      Item i =new Item(name,price);
	      itemdao.save(i);
	    }
	    catch (Exception ex) {
	      return "Error creating the item: " + ex.toString();
	    }
	    return "item succesfully created!";
	  }
	@RequestMapping(value="/item/delete")
	  @ResponseBody
	  public String delete(String name) {
	    try {
	      
	      itemdao.delete(name);
	    }
	    catch (Exception ex) {
	      return "Error deleting the item: " + ex.toString();
	    }
	    return "Item succesfully deleted!";
	  }
	@RequestMapping(value="/item/list")
	  @ResponseBody
	  public Item getAll() {
		 logger.info("enter itemgetAll");
			return itemdao.getAll().get(0);
	   /* String itemId;
	    try {
	    	itemdao.getAll();
	      itemId = String.valueOf(i.getId());
	     
	    }
	    catch (Exception ex) {
	      return "Item not found: " + ex.toString();
	    }
	    return "The item id is: " + itemId;*/
	  }

	@RequestMapping(value="/item/getbyname")
	  @ResponseBody
	  public Item getByName(String name) {
		 logger.info("enter getByName");
			return itemdao.getByName(name);
	
}
}