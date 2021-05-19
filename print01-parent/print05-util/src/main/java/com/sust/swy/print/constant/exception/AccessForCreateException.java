package com.sust.swy.print.constant.exception;

/**
 * 未实名认证会员创建项目异常
 * */
public class AccessForCreateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccessForCreateException() {
		super();
	}

	public AccessForCreateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccessForCreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessForCreateException(String message) {
		super(message);
	}

	public AccessForCreateException(Throwable cause) {
		super(cause);
	}

}
