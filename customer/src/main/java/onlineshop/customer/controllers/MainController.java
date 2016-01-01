package onlineshop.customer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController {

	
		// TODO Auto-generated constructor stub
		@RequestMapping("/")
		  @ResponseBody
		  public String index() {
		    return "Proudly handcrafted by blair";
		
	

}
}
