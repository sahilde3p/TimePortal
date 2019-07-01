package ca.anygroup.timeportal.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ca.anygroup.timeportal.dao.AuthDAO;
import ca.anygroup.timeportal.entity.Auth;

@Component
public class AuthServiceImpl implements AuthService {

	@Resource
	private AuthDAO authDAO;
	
	@Override
	public Auth save(Auth auth) {
		
		return authDAO.save(new Auth());
		
	}

}
