package tn.mahjoub.rdv.exception;

import org.springframework.http.HttpStatus;

public class IllegalStateException extends ApiBaseException {

	public IllegalStateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.BAD_GATEWAY;
	}
	
	

}
