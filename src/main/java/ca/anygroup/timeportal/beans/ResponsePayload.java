package ca.anygroup.timeportal.beans;

public class ResponsePayload {
	
	public String message;

	public ResponsePayload() { } 
	
	public ResponsePayload(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
