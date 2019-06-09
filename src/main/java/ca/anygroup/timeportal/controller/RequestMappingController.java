package ca.anygroup.timeportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingController {

	@RequestMapping("/")
	public String login() {
		return "index";
	}
	
	@RequestMapping("auth")
	public String authenticate() {
		return "home-page";
	}
	
}
