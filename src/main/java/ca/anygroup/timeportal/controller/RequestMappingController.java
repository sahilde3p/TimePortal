package ca.anygroup.timeportal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.anygroup.timeportal.beans.AuthPayload;
import ca.anygroup.timeportal.beans.ResponsePayload;
import ca.anygroup.timeportal.beans.SendInviteInputPayload;
import ca.anygroup.timeportal.dao.CompanyDAO;
import ca.anygroup.timeportal.entity.Auth;
import ca.anygroup.timeportal.entity.Company;
import ca.anygroup.timeportal.service.AuthService;
import ca.anygroup.timeportal.service.InvitationGeneratorService;

@Controller
public class RequestMappingController {
	
	@Autowired
	private InvitationGeneratorService invitationGeneratorService;
	
	@Autowired
	private AuthService authService;

	@Autowired
	private CompanyDAO companyDAO;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("auth")
	public String authenticate() {
		return "home-page";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("sendInvite")
	public String sendInvite() {
		return "send-invite";
	}
	
	@PostMapping("sendInvite")
	public String generateInvitation(SendInviteInputPayload payload, Model model) {
		ResponsePayload response = invitationGeneratorService.generateInvitation(payload);
		model.addAttribute("response",response);
		return "send-invite";
	}
	
	@GetMapping("register/{companyId}/{token}")
	public String register() {
		return "register";
	}
	
	@PostMapping("register/{companyId}")
	public String register(@PathVariable String companyId, AuthPayload payload, Model model) {
		
		Company company = null;
		
		Optional<Company> optional = companyDAO.findById(companyId);
		company = optional.isPresent() ? optional.get() : null;
		
		if(company !=null) {
		Auth auth = new Auth(payload.getEmail(), 0, company);
		authService.save(auth);
		model.addAttribute("response", "Successfully Registered. Please login with your email");
		
		return "index";
		
		}
		
		model.addAttribute("response", "Unable to register. Something went wrong.");
		return "index";
	}
	
}
