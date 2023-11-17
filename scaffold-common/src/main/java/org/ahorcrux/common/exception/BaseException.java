package org.ahorcrux.common.exception;


public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 8838429880037766070L;
	/**
	 * 应答码
	 */
	private IErrorCode result;

	/**
	 * 构造方法
	 * 
	 * @param result
	 */
	public BaseException(IErrorCode result) {
		this(result, result.message());
	}

	/**
	 * 构造方法
	 * 
	 * @param result
	 * @param message
	 */
	public BaseException(IErrorCode result, String message) {
		super(message);
		this.result = result;
	}

	public BaseException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 * 
	 * @param result
	 * @param cause
	 */
	public BaseException(IErrorCode result, Throwable cause) {
		this(result, result.message(), cause);
	}

	/**
	 * 构造方法
	 * 
	 * @param result
	 * @param message
	 * @param cause
	 */
	public BaseException(IErrorCode result, String message, Throwable cause) {
		super(message, cause);
		this.result = result;
	}

	public void setResult(IErrorCode result) {
		this.result = result;
	}

	public IErrorCode getResult() {
		return result;
	}
}