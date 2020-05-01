package lu.lllc.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	} 
	
	@GetMapping("/autorest")
	public String index2() {
		return "index2";
	} 
	
	
	@GetMapping("/manualyJson")
	public String index3() {
		return "index3";
	} 
}
