package onlineshop.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import onlineshop.customer.models.Customer;
import onlineshop.customer.models.CustomerDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	 @Autowired
	  private CustomerDao customerdao;
	@RequestMapping(value="/customer/create")
	  @ResponseBody
	  
	  public String create(String name, String email) {
	    try {
	      Customer customer = new Customer(name, email);
	      customerdao.save(customer);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created!";
	  }
	@RequestMapping(value="/customer/delete")
	  @ResponseBody
	  public String delete(String name) {
	    try {
	      Customer c = new Customer(name);
	      customerdao.delete(c);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user: " + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	@RequestMapping(value="/customer/list")
	  @ResponseBody
	  public List<Customer> getAll() {
		logger.info("enter getAll");
		return customerdao.getAll();
	    /*String userId = "";
	    try {
	    	List<Customer> cs = customerdao.getAll();
	        for (Customer c : cs) 
	        {
	    		logger.info("customer name is " + c.getName());
	        	userId = userId.concat(c.getName()).concat(",");
	        }
	    }
	    catch (Exception ex) {
	      return "Customer not found: " + ex.toString();
	    }
	    return "users are: " + userId;*/
	  }
	/**
	   * Update the email and the name for the user indentified by the passed id.
	   */
	  /*@RequestMapping(value="/update")
	  @ResponseBody
	  public String updateName(long id, String email, String name) {
	    try {
	      Customer c = customerdao.getById(id);
	      c.setEmail(email);
	      c.setName(name);
	      customerdao.update(c);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  } */

	  // ------------------------
	  // PRIVATE FIELDS
	  // ------------------------
	  
	  // Wire the UserDao used inside this controller.
	 
		@RequestMapping(value="/customer/getbyname")
		  @ResponseBody
		  public Customer getByName(String name) {
			 logger.info("enter getByName");
				return customerdao.getByName(name);
		
	}
	  
}

