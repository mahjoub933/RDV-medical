package tn.mahjoub.rdv.exception;

import java.util.List;

public class ExceptionValidationResponse<T> {

	private boolean ok;
	
	private List<T> errors;

	public ExceptionValidationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionValidationResponse(boolean ok, List<T> errors) {
		super();
		this.ok = ok;
		this.errors = errors;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List<T> getErrors() {
		return errors;
	}

	public void setErrors(List<T> errors) {
		this.errors = errors;
	}
	
	
}
