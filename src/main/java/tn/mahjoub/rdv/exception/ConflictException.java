package tn.mahjoub.rdv.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiBaseException {

	public ConflictException(String message) {
		super(message);
	}


	public HttpStatus getStatusCode() {
		return HttpStatus.CONFLICT;
	}
	
	

}
