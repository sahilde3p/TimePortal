package ca.anygroup.timeportal.service;

import org.springframework.stereotype.Service;

import ca.anygroup.timeportal.entity.Auth;

@Service
public interface AuthService {

	public Auth save(Auth auth);
}
