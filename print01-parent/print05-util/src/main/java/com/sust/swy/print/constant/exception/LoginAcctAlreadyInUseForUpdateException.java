package com.sust.swy.print.constant.exception;

/*
 * 账号重复异常
 * */
public class LoginAcctAlreadyInUseForUpdateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginAcctAlreadyInUseForUpdateException() {
		super();
	}

	public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginAcctAlreadyInUseForUpdateException(String message) {
		super(message);
	}

	public LoginAcctAlreadyInUseForUpdateException(Throwable cause) {
		super(cause);
	}

}
