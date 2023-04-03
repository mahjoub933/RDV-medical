package tn.mahjoub.rdv.exception;

import org.springframework.http.HttpStatus;

public class FileUploadException extends ApiBaseException {

	
	
	public FileUploadException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.EXPECTATION_FAILED;
	}

}
