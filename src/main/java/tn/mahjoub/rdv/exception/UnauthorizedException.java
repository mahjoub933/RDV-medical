package tn.mahjoub.rdv.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiBaseException {

	public UnauthorizedException(String message) {
		super(message);
	}
	
	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.UNAUTHORIZED;
	}

}
