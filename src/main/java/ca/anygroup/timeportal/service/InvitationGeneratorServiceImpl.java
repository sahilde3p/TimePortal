package ca.anygroup.timeportal.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import ca.anygroup.timeportal.beans.ResponsePayload;
import ca.anygroup.timeportal.beans.SendInviteInputPayload;
import ca.anygroup.timeportal.dao.CompanyDAO;
import ca.anygroup.timeportal.dao.RegisterationTokenDAO;
import ca.anygroup.timeportal.entity.Company;
import ca.anygroup.timeportal.entity.RegisterationToken;
import ca.anygroup.timeportal.util.Keys;

@Component
public class InvitationGeneratorServiceImpl implements InvitationGeneratorService {

	@Resource
	private CompanyDAO companyDAO;
	
	@Resource
	RegisterationTokenDAO registerationTokenDAO;
	
	public InvitationGeneratorServiceImpl() { }
	
	@Transactional(rollbackOn = RuntimeException.class)
	public ResponsePayload generateInvitation(SendInviteInputPayload payload) {

		Company existingCompany = companyDAO.findByEmail(payload.getEmail());
		
		ResponsePayload response = null;

		if(existingCompany==null) {
			
			Company company = new Company();
			String companyId = Keys.getUniqueKey();

			RegisterationToken token = new RegisterationToken();
			token.setToken(Keys.getUniqueKey());

			company.setId(companyId);
			company.setName(payload.getCompanyName());
			company.setEmail(payload.getEmail());
			company.setAccepted(0);
			company.setToken(token); // It is Internally setting tken.setCompany(company)
			
			try {
				MailService.sendMail(payload.getEmail(), "ANYGroup TimePortal Registeration", "Welcome to test mail: here is link : "+ token.getToken());
			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponsePayload("Something Went Wrong");
			}
			registerationTokenDAO.save(token);
			response = new ResponsePayload("Client Successfully Invited. An Email has been sent to "+payload.getEmail());

		} else {
			response = new ResponsePayload("Client is Already Invited or has Already Registered");
		}
		
		return response;
	}


}
