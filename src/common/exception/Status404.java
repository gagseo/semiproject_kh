package common.exception;

import javax.servlet.ServletException;

public class Status404 extends ServletException {

	private static final long serialVersionUID = -4191760156152350510L;

	public Status404(String errMsg) {
		super(errMsg);
	}
}
