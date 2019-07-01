package ca.anygroup.timeportal.service;

import org.springframework.stereotype.Service;

import ca.anygroup.timeportal.beans.ResponsePayload;
import ca.anygroup.timeportal.beans.SendInviteInputPayload;

@Service
public interface InvitationGeneratorService {

	public ResponsePayload generateInvitation(SendInviteInputPayload payload);
	
}
