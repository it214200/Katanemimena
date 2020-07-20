package gr.hua.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// using the url "/" controller will return index.jsp
	@RequestMapping("/")
	public String mainMenu() {
		
		return "index";
	}
	
}
